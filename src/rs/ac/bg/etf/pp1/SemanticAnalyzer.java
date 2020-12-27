package rs.ac.bg.etf.pp1;
import java.util.HashMap;
import org.apache.log4j.Logger;
import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.symboltable.concepts.*;


public class SemanticAnalyzer extends VisitorAdaptor {
    int printCallCount = 0;
    int varDeclCount = 0;
    int varArrayDeclCount = 0;
    int constDeclCount = 0;
    boolean returnTokenRequired = false;
    boolean mainMethodDetected = false;

    // Potreba da se detektuje ulazna tacka programa
    final String mainMethodName = "main";

    // Sluzi da se uporede methodReturnValue i currentReturn Value
    // Moze da se optimizuje tako sto se proverava u return stmt
    Struct methodReturnValue = Table.noType;
    Struct currentReturnMethodType = null;
    // Da znamo opseg
    Obj currentMethod = null;

    // Sluzi da odmah ubacimo u tabelu simbola kada detektujemo naziv VariableDeclaration
    Struct currentType = Table.noType;

    Logger log = Logger.getLogger(getClass());

    final HashMap<Integer, String> nazivi_tipova = new HashMap<>();


    // TODO Implementirati ovu detekciju i sprecavanje kompajliranja
    boolean errorDetected = false;

    // Za potrebe ispisa gresaka
    public SemanticAnalyzer() {
        super();
        nazivi_tipova.put(Struct.None, "void");
        nazivi_tipova.put(Struct.Int, "int");
        nazivi_tipova.put(Struct.Char, "char");
        nazivi_tipova.put(Struct.Array, "array");
        nazivi_tipova.put(Struct.Class, "class");
        nazivi_tipova.put(Struct.Bool, "bool");
        nazivi_tipova.put(Struct.Enum, "enum");
        nazivi_tipova.put(Struct.Interface, "interface");
    }

    public void report_error(String message, SyntaxNode info) {
        errorDetected = true;
        StringBuilder msg = new StringBuilder(message);
        int line = (info == null) ? 0 : info.getLine();
        if (line != 0)
            msg.append(" na liniji ").append(line);
        log.error("\u001b[0;31m" + msg.toString() + "\u001b[m");
    }

    public void report_info(String message, SyntaxNode info) {
        StringBuilder msg = new StringBuilder(message);
        int line = (info == null) ? 0 : info.getLine();
        if (line != 0)
            msg.append(" na liniji ").append(line);
        log.info("\u001b[0;33m" + msg.toString() + "\u001b[m");
    }

    // VariableDeclaration is superclass
    public void visit(NonArrayVariable vardecl) {
        varDeclCount++;
        Obj variableNode = Table.find(vardecl.getVariableName());
        if (variableNode == Table.noObj) {
            Table.insert(Obj.Var, vardecl.getVariableName(), currentType);
        } else {
            report_error("Promenlijva sa imenom " + vardecl.getVariableName() + " je vec deklarisana "
                    + vardecl.getLine() + "]", vardecl);
        }
    }

    public void visit(ErrorNonArrayVariable vardecl) {
        varDeclCount++;
        Obj variableNode = Table.find(vardecl.getVariableName());
        if (variableNode == Table.noObj) {
            Table.insert(Obj.Var, vardecl.getVariableName(), currentType);
        } else {
            report_error("Promenlijva sa imenom " + vardecl.getVariableName() + " je vec deklarisana "
                    + vardecl.getLine() + "!", vardecl);
        }

    }

    public void visit(ArrayVariable vardecl) {
        varArrayDeclCount++;
        Obj variableNode = Table.find(vardecl.getVariableName());
        if (variableNode == Table.noObj) {
            Table.insert(Obj.Var, vardecl.getVariableName(), new Struct(Struct.Array, currentType));
        } else {
            report_error("Promenlijva sa imenom " + vardecl.getVariableName() + " je vec deklarisana"
                    + vardecl.getLine() + "!", vardecl);
        }

    }

    public void visit(ErrorArrayVariable vardecl) {
        varArrayDeclCount++;
        Obj variableNode = Table.find(vardecl.getVariableName());
        if (variableNode == Table.noObj) {
            Table.insert(Obj.Var, vardecl.getVariableName(), new Struct(Struct.Array, currentType));
        } else {
            report_error("Promenlijva sa imenom " + vardecl.getVariableName() + " je vec deklarisana "
                    + vardecl.getLine() + "!", vardecl);
        }

    }

    public void visit(NumericLiteral num) {
        num.obj = new Obj(Obj.Con, "", Table.intType, num.getNumValue(), 0);
    }

    public void visit(CharLiteral num) {
        num.obj = new Obj(Obj.Con, "", Table.charType, num.getCharValue(), 0);
    }

    public void visit(BooleanLiteral num) {
        String value = num.getBooleanValue();
        boolean isTrue = value.equals("true");
        num.obj = new Obj(Obj.Con, "", Table.boolType, isTrue ? 1 : 0, 0);
    }

    public void visit(ConstDefinition vardecl) {
        constDeclCount++;
        Obj variableNode = Table.find(vardecl.getIdentification());
        if (variableNode == Table.noObj) {
            variableNode = Table.insert(Obj.Con, vardecl.getIdentification(), currentType);
            Obj literalObj = vardecl.getLiterals().obj;
            Struct literalType = literalObj.getType();
            if (literalType.equals(currentType)) {
                variableNode.setAdr(vardecl.getLiterals().obj.getAdr());
            } else {
                report_error("Ne moze da se dodeljuje " + literalType.toString() + " konstanti sa tipom "
                        + currentType.toString() + "!", null);
            }
        } else {
            report_error("Promenlijva sa imenom " + vardecl.getIdentification() + " je vec deklarisana "
                    + vardecl.getLine() + "!", vardecl);
        }
    }

    public void visit(PrintStmt print) {
        printCallCount++;
    }

    public void visit(Type type) {
        Obj typeNode = Table.find(type.getType());
        if (typeNode == Table.noObj) {
            report_error(String.format("Definisan tip %s ne postoji u jeziku! [Line: %d]",
                    type.getType(),
                    type.getLine()),
                    null);
            type.obj = new Obj(Obj.NO_VALUE, "", Table.noType);
        } else {
            if (Obj.Type == typeNode.getKind()) {
                type.obj = new Obj(Obj.Type, "", typeNode.getType());
                currentType = typeNode.getType();
            } else {
                report_error(
                        String.format("Promenljiva %s nije tip! [Line: %d]"
                                , type.getType(),
                                type.getLine()),
                        null);
                type.obj = new Obj(Obj.NO_VALUE, "", Table.noType);
            }
        }
    }

    public void visit(ProgramName programName) {
        programName.obj = Table.insert(Obj.Prog, programName.getProgramName(), Table.noType);
        Table.openScope();

    }

    public void visit(Program program) {
        Table.chainLocalSymbols(program.getProgName().obj);
        Table.closeScope();

    }

    public void visit(TypedReturn typedReturn) {
        currentReturnMethodType = typedReturn.getType().obj.getType();
        methodReturnValue = currentReturnMethodType.getElemType();
        returnTokenRequired = true;
    }

    // TODO Da li moze void return da ima return obican?
    public void visit(VoidReturn voidReturn) {
        currentReturnMethodType = Table.noType;
        methodReturnValue = Table.noType;
        returnTokenRequired = false;
    }

    public void visit(MethodTypeName methodTypeName) {
        currentMethod = Table.insert(Obj.Meth, methodTypeName.getMethodIdentification(), currentReturnMethodType);
        methodTypeName.obj = currentMethod;
        Table.openScope();
        if (mainMethodName.equalsIgnoreCase(methodTypeName.getMethodIdentification())) {
            mainMethodDetected = true;
        }
        report_info("Detektovana metoda " + methodTypeName.getMethodIdentification(), methodTypeName);
    }

    public void visit(OneMethodDeclaration methodDeclaration) {
        Table.chainLocalSymbols(currentMethod);
        Table.closeScope();
        currentMethod = null;
        currentReturnMethodType = null;
    }

    // TODO provera za nizove
    public void visit(CleanDesignator cleanDesignator) {
        Obj temp = Table.find(cleanDesignator.getIdentification());

        if (temp == Table.noObj || temp.getKind() == Obj.Type || temp.getKind() == Obj.Prog) {
            temp = new Obj(Obj.NO_VALUE, cleanDesignator.getIdentification(), Table.noType);
            report_error(String.format("Neodgovarajuce ime promenljive ili promenljiva ne postoji! [Line %d]", cleanDesignator.getLine()), null);
        }
        cleanDesignator.obj = temp;
    }

    public void visit(DesignatorListOneElement designatorListOneElement) {
        Obj temp = Table.find(designatorListOneElement.getIdentification());

        if (temp == Table.noObj || temp.getKind() == Obj.Type || temp.getKind() == Obj.Prog) {
            temp = new Obj(Obj.NO_VALUE, designatorListOneElement.getIdentification(), Table.noType);
            report_error(String.format("Neodgovarajuce ime promenljive ili promenljiva ne postoji! [Line %d]", designatorListOneElement.getLine()), null);
        }
        designatorListOneElement.obj = temp;
    }

    public void visit(ArrayElementDesignatorList arrayElementDesignatorList) {
        Obj expressionObj = arrayElementDesignatorList.getExpr().obj;
        Obj designatorListObj = arrayElementDesignatorList.getDesignatorList().obj;

        if (expressionObj.getType().getKind() != Struct.Int) {
            report_error(String.format("Ne moze da se indeksira sa tipom (%s)! [Line: {%d}]",
                    nazivi_tipova.get(expressionObj.getKind()),
                    arrayElementDesignatorList.getLine()), null);
        } else {
            if (designatorListObj.getType().getKind() == Struct.Array) {
                Struct elementType = designatorListObj.getType().getElemType();
                Struct objectStruct = Table.noType;
                if (elementType != null) {
                    objectStruct = elementType;
                }
                arrayElementDesignatorList.obj = new Obj(Obj.Elem, "", objectStruct);
            } else {
                report_error(String.format("Nemoguce je indeksirati promenljivu koja nije tipa niza! [Line: {%d}]",
                        arrayElementDesignatorList.getLine()), null);
            }
        }
    }

    public void visit(ArrayElementAccessDesignator arrayElementAccessDesignator) {
        Obj expressionObj = arrayElementAccessDesignator.getExpr().obj;
        Obj designatorListObj = arrayElementAccessDesignator.getDesignatorList().obj;
        if (expressionObj.getType().getKind() != Struct.Int) {
            report_error(String.format("Ne moze da se indeksira sa tipom (%s)! [Line: {%d}]",
                    nazivi_tipova.get(expressionObj.getKind()),
                    arrayElementAccessDesignator.getLine()), null);
        } else {
            if (designatorListObj.getType().getKind() == Struct.Array) {
                Struct elementType = designatorListObj.getType().getElemType();
                Struct objectStruct = Table.noType;
                if (elementType != null) {
                    objectStruct = elementType;
                }
                arrayElementAccessDesignator.obj = new Obj(Obj.Elem, "", objectStruct);
            } else {
                report_error(String.format("Nemoguce je indeksirati promenljivu koja nije tipa niza! [Line: {%d}]",
                        arrayElementAccessDesignator.getLine()), null);
            }
        }
    }


    // TODO treba provera za array tip isto
    public void visit(IncrementDesignator incrementDesignator) {
        Obj designator = incrementDesignator.getDesignator().obj;
        if (designator.getType() != Table.intType) {
            report_error("Ocekivan tip (int), dobijen tip (" + nazivi_tipova.get(designator.getKind()) + ")! [Line: "
                    + incrementDesignator.getLine() + "]", null);
        }
    }

    // TODO treba provera za array tip
    public void visit(DecrementDesignator decrementDesignator) {
        Obj designator = decrementDesignator.getDesignator().obj;
        if (designator.getType() != Table.intType) {
            report_error("Ocekivan tip (int), dobijen tip (" + nazivi_tipova.get(designator.getKind()) + ")! [Line: "
                    + decrementDesignator.getLine() + "]", null);
        }
    }


    public void visit(MethodCallDesignator methodCallDesignator) {
        Obj functionObject = methodCallDesignator.getDesignator().obj;
        if (functionObject.getKind() == Obj.Meth) {
            report_info("Pronadjen poziv funkcije [Line" + methodCallDesignator.getLine() + "]", null);
            //methodCallDesignator.struct = functionObject.getType();
        } else {
            report_error("Ocekuje se poziv metode, prosledjen tip:  " + nazivi_tipova.get(functionObject.getKind())
                    + "[Line: " + methodCallDesignator.getLine() + "]", null);
            //methodCallDesignator.struct = Table.noType;
        }
    }

    public void visit(OneTerm oneTerm) {
        oneTerm.obj = oneTerm.getTerm().obj;
    }

    public void visit(AddOperationTerm addOperationTerm) {
        addOperationTerm.obj = addOperationTerm.getExprNoTernAddOpList().obj;
    }

    public void visit(NegativeTerm negativeTerm) {
        Obj expression = negativeTerm.getExprNoTernAddOpList().obj;
        if (expression.getType().getKind() == Struct.Int) {
            negativeTerm.obj = new Obj(Obj.Var, "", Table.noType);
        } else {
            report_error(String.format("Ocekuje se tip (int), dostavljen tip (%s)! [Line: %d]",
                    nazivi_tipova.get(expression.getType().getKind()),
                    negativeTerm.getLine()),
                    null);
            negativeTerm.obj = new Obj(Obj.NO_VALUE, "", Table.noType);
        }
    }

    public void visit(TermList termList) {
        Obj termTree = termList.getTerm().obj;
        Obj factor = termList.getExprNoTernAddOpList().obj;

        // TODO Za nizove nisam siguran jos kako kodira ovaj object
        if (termTree.getType().equals(Table.intType) &&
                factor.getType().equals(Table.intType)) {
            termList.obj = new Obj(Obj.Var, "", Table.intType);
        } else {
            report_error(String.format("Nemoguce sabiranje sa tipovima (%s) i (%s)! [Line: %d]",
                    nazivi_tipova.get(termTree.getKind()),
                    nazivi_tipova.get(factor.getKind()),
                    termList.getLine()), null);

        }

    }

    public void visit(AssignDesignator assignDesignator) {
        Obj designator = assignDesignator.getDesignator().obj;
        Obj expression = assignDesignator.getExpr().obj;

        if (designator.getKind() == Obj.Con) {
            report_error(String.format("%s je KONSTANTA, ne moze da se dodeljuje nova vrednost konstanti! [Line: %d]",
                    designator.getName(), assignDesignator.getLine()), null);
            return;
        }
        if (!expression.getType().assignableTo(designator.getType())) {
            // TODO kompatibilnost sa array??
            if (expression.getType().getKind() == 3 && designator.getType().getKind() == 3) {
                report_error(String.format("Promenljiva tipa Array of (%s) ne moze da se dodeli promenljivoj tipa Array of (%s)! [Line: %d]",
                        nazivi_tipova.get(expression.getType().getElemType().getKind()),
                        nazivi_tipova.get(designator.getType().getElemType().getKind()),
                        assignDesignator.getLine()
                ), null);
            } else {
                report_error(String.format("Promenljiva tipa (%s) ne moze da se dodeli promenljivoj tipa (%s)! [Line: %d]",
                        nazivi_tipova.get(expression.getType().getKind()),
                        nazivi_tipova.get(designator.getType().getKind()),
                        assignDesignator.getLine()
                ), null);
            }
        }
    }

    public void visit(ExprNoTernStatement exprNoTernStatement) {
        exprNoTernStatement.obj = exprNoTernStatement.getExprNoTern().obj;
    }

    public void visit(NumericConstant numericConstant) {
        // Level 1 jer je unutar nekog scope-a
        numericConstant.obj = new Obj(Obj.Con, "", Table.intType, numericConstant.getNumValue(), 1);
    }

    public void visit(CharacterConstant characterConstant) {
        characterConstant.obj = new Obj(Obj.Con, "", Table.charType, characterConstant.getCharValue(), 1);
    }

    public void visit(BooleanConstant booleanConstant) {
        booleanConstant.obj = new Obj(Obj.Con, "", Table.boolType, booleanConstant.getBoolValue().equalsIgnoreCase("true") ? 1 : 0, 1);
    }

    public void visit(NoParamsDesignator NoParamsDesignator) {
        Obj designatorObject = NoParamsDesignator.getDesignator().obj;
        if (designatorObject.getName().equalsIgnoreCase("pet")) {
            int aa;
        }
        if (designatorObject != null) {
            NoParamsDesignator.obj = designatorObject;
        } else {
            NoParamsDesignator.obj = new Obj(Obj.NO_VALUE, "", Table.noType);
        }
    }

    public void visit(NonMullOpTerm term) {
        term.obj = term.getFactor().obj;
    }

    public void visit(MullOpTerm termOp) {
        Obj termTree = termOp.getTerm().obj;
        Obj factor = termOp.getFactor().obj;
        if (termTree == null || factor == null) {
            report_error(String.format("Fatalna greska se dogodila! [Line %d]", termOp.getLine()), null);
            System.exit(411);
        }

        if (factor.getType().equals(Table.intType) && termTree.getType().compatibleWith(factor.getType())) {
            termOp.obj = new Obj(Obj.Var, "", Table.intType);
        } else {
            report_error(String.format("Nemoguce izvrsiti operaciju sa tipom (%s) i (%s)! [Line: %d]",
                    nazivi_tipova.get(termTree.getType().getKind()),
                    nazivi_tipova.get(factor.getType().getKind()),
                    termOp.getLine()), null);
            termOp.obj = new Obj(Obj.NO_VALUE, "", Table.noType);
        }
        // TODO equals za termove

    }

    public void visit(ParenthesesExpression parenthesesExpression) {
        parenthesesExpression.obj = parenthesesExpression.getExpr().obj;
    }

    public void visit(NewTypeArray newTypeArray) {
        Obj typeObject = newTypeArray.getType().obj;
        Obj expressionObject = newTypeArray.getExpr().obj;

        if (expressionObject.getType().getKind() == Struct.Int) {
            newTypeArray.obj = new Obj(Obj.Var, "", new Struct(Struct.Array, typeObject.getType()));
        } else {
            report_error(String.format("Velicina niza treba da bude tipa (int), dostavljen tip je (%s)! [Line: %d]",
                    nazivi_tipova.get(expressionObject.getType().getKind()),
                    newTypeArray.getLine()),
                    null);
            newTypeArray.obj = new Obj(Obj.NO_VALUE, "", Table.noType);
        }

    }

    public void visit(ReturnStmt returnStmt) {
        Obj returnStatementObject = returnStmt.getReturnStmts().obj;
        if (returnStatementObject.getType().equals(currentReturnMethodType)) {
            // TODO Provera za nizove
        } else {
            report_error(String.format("Povratna vrednost metode [%s] je (%s)," +
                            " povratna vrednost je (%s)",
                    currentMethod.getName(),
                    nazivi_tipova.get(currentReturnMethodType.getKind()),
                    nazivi_tipova.get(returnStatementObject.getType().getKind())), null);
        }
    }

    public void visit(NonEmptyReturn nonEmptyReturn) {
        nonEmptyReturn.obj = new Obj(Obj.Type, "", nonEmptyReturn.getExpr().obj.getType());
    }

    public void visit(EmptyReturn epsilon) {
        epsilon.obj = new Obj(Obj.Type, "", Table.noType);
    }

    public void visit(EmptyRelationalExpression emptyRelationalExpression) {
        emptyRelationalExpression.obj = new Obj(Obj.NO_VALUE, "", Table.noType);
    }

    public void visit(NonEmptyRelationalExpression nonEmptyRelationalExpression) {
        Obj expression = nonEmptyRelationalExpression.getExprNoTern().obj;
        String operation = nonEmptyRelationalExpression.getRelOp().obj.getName();
        nonEmptyRelationalExpression.obj = new Obj(Obj.Type, operation, expression.getType());
    }

    public void visit(ExpressionConditionFactor expressionConditionFactor) {
        Obj leftExpression = expressionConditionFactor.getExprNoTern().obj;
        Obj rightExpression = expressionConditionFactor.getRelationalExpression().obj;
        String operation = rightExpression.getName();
        if (rightExpression.getType().getKind() != Table.noType.getKind()) {
            if (rightExpression.getType().getKind() == Struct.Array
                    && leftExpression.getType().getKind() == Struct.Array) {
                if (leftExpression.getType().getElemType().getKind() == rightExpression.getType().getElemType().getKind()) {
                    if (operation.equalsIgnoreCase("!=") || operation.equalsIgnoreCase("==")) {
                        expressionConditionFactor.obj = new Obj(Obj.Type, "", Table.boolType);
                    } else {
                        report_error(String.format("Prilikom uporedjivanja nizova, dozvoljeni relacioni opearteri su [!=] ili [==]!" +
                                        " Koriscena operacija je (%s)! [Line: %d]",
                                operation,
                                expressionConditionFactor.getLine()),
                                null);
                    }
                } else {
                    report_error(String.format("Tipovi nisu kompatibilni! Uporedjuje se Array of (%s) i Array of (%s) [Line: %d]",
                            nazivi_tipova.get(leftExpression.getType().getElemType().getKind()),
                            nazivi_tipova.get(rightExpression.getType().getElemType().getKind()),
                            expressionConditionFactor.getLine()),
                            null);
                }
            } else {
                /*
                 * TODO - Da li operator moze da uporedjuje boolean promenljive koriscenjem <, <= i slicno?
                 *
                 *  Tj da li neki boolean moze da bude veci ili manji od nekog drugog boolean? Tehnicki vodimo boolean kao
                 * integer tako da mozemo da uporedjujemo, ali da li ima smisla?
                 * */
                if (rightExpression.getType().getKind() == leftExpression.getType().getKind()) {
                    if (rightExpression.getType().getKind() == Struct.Bool) {
                        if (operation.equalsIgnoreCase("==") || operation.equalsIgnoreCase("!=")) {
                            expressionConditionFactor.obj = new Obj(Obj.Type, "", Table.boolType);
                        } else {
                            report_error(String.format("Dozvoljeni operatori za uporedjivanje boolean tipova su [==] i [!=]!" +
                                            " Prilozen operator je [%s]! [Line: %d]",
                                    operation,
                                    expressionConditionFactor.getLine()
                                    ),
                                    null);
                        }
                    } else {
                        expressionConditionFactor.obj = new Obj(Obj.Type, "", rightExpression.getType());
                    }
                } else {
                    report_error(String.format("Tipovi nisu kompatibilni! Uporedjuje se (%s) i (%s) [Line: %d]",
                            nazivi_tipova.get(leftExpression.getType().getKind()),
                            nazivi_tipova.get(rightExpression.getType().getKind()),
                            expressionConditionFactor.getLine()),
                            null);
                }
            }
        } else {
            if (leftExpression.getType().getKind() != Struct.Bool) {
                report_error(String.format("Uslov u ternarnom operatoru nije logickog tipa, prilozen (%s)! [Line: %d]",
                        nazivi_tipova.get(leftExpression.getType().getKind()),
                        expressionConditionFactor.getLine()), null);
                expressionConditionFactor.obj = new Obj(Obj.NO_VALUE, "", Table.noType);
            } else {
                expressionConditionFactor.obj = new Obj(Obj.Type, "", Table.boolType);
            }
        }
    }

    public void visit(TernaryExpressionStmt ternaryExpressionStmt) {
        Obj trueExpression = ternaryExpressionStmt.getExpr().obj;
        Obj falseExpression = ternaryExpressionStmt.getExpr1().obj;

        if (trueExpression.getType().getKind() == falseExpression.getType().getKind()) {
            ternaryExpressionStmt.obj = new Obj(Obj.Type, "", trueExpression.getType());
        } else {
            report_error(String.format("Izraz za true je tipa (%s), izraz za false je (%s). Tipovi treba da budu kompatibilni!" +
                            " [Line: %d]",
                    nazivi_tipova.get(trueExpression.getType().getKind()),
                    nazivi_tipova.get(falseExpression.getType().getKind()),
                    ternaryExpressionStmt.getLine()),
                    null);
            ternaryExpressionStmt.obj = new Obj(Obj.NO_VALUE, "", Table.noType);
        }

    }

    public void visit(RelopEquals relopEquals) {
        relopEquals.obj = new Obj(Obj.NO_VALUE, "==", Table.noType);
    }

    public void visit(RelopNotEqual relopNotEqual) {
        relopNotEqual.obj = new Obj(Obj.NO_VALUE, "!=", Table.noType);
    }

    public void visit(RelopLargerThan relopLargerThan) {
        relopLargerThan.obj = new Obj(Obj.NO_VALUE, ">", Table.noType);
    }

    public void visit(RelopLargerEqual relopLargerEqual) {
        relopLargerEqual.obj = new Obj(Obj.NO_VALUE, ">=", Table.noType);
    }

    public void visit(RelopLessThan relopLessThan) {
        relopLessThan.obj = new Obj(Obj.NO_VALUE, "<", Table.noType);
    }

    public void visit(RelopLessEqual relopLessEqual) {
        relopLessEqual.obj = new Obj(Obj.NO_VALUE, "<=", Table.noType);
    }
}