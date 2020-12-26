package rs.ac.bg.etf.pp1;

import java.util.HashMap;

import org.apache.log4j.Logger;

import rs.ac.bg.etf.pp1.Table.Table;
import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.symboltable.concepts.*;

public class SemanticAnalyzer extends VisitorAdaptor {
    int printCallCount = 0;
    int varDeclCount = 0;
    int varArrayDeclCount = 0;
    int constDeclCount = 0;
    boolean returnTokenRequired = false;
    boolean mainMethodDetected = false;

    enum ReturnValue {
        VOID,
        INT,
        CHAR,
        BOOL,
        CLASS,
        ARRAY,
        NONE
    }

    Struct methodReturnValue = Table.noType;

    final String mainMethodName = "main";

    Struct currentReturnMethodType = null;

    Obj currentMethod = null;

    Struct currentType = Table.noType;

    Logger log = Logger.getLogger(getClass());

    final HashMap<Integer, String> nazivi_tipova = new HashMap<Integer, String>();

    public static final int None = 0;
    public static final int Int = 1;
    public static final int Char = 2;
    public static final int Array = 3;
    public static final int Class = 4;
    public static final int Bool = 5;
    public static final int Enum = 6;
    public static final int Interface = 7;

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
        // errorDetected = true;
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
            report_error("Tip " + type.getType() + " ne postoji. [Line: " + type.getLine() + "]", null);
            type.struct = Table.noType;
        } else {
            if (Obj.Type == typeNode.getKind()) {
                type.struct = typeNode.getType();
                currentType = typeNode.getType();
            } else {
                report_error(
                        "GRESKA! Ime " + type.getType() + " nije naziv tipa u jeziku [Line " + type.getLine() + "]",
                        null);
                type.struct = Table.noType;
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
        currentReturnMethodType = typedReturn.getType().struct;

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

    public void visit(CleanDesignator cleanDesignator) {
        Obj temp = Table.find(cleanDesignator.getIdentification());
        if (temp != Table.noObj) {
            cleanDesignator.obj = temp;
        } else {
            report_error("Ne postoji deklarisana promenljiva sa ovim imenom: " + cleanDesignator.getIdentification(),
                    cleanDesignator);
        }
    }

    // TODO treba provera za array tip isto
    public void visit(IncrementDesignator incrementDesignator) {
        Obj designator = incrementDesignator.getDesignator().obj;
        if (designator.getType() != Table.intType) {
            report_error("Ocekivan tip int, dobijen tip " + nazivi_tipova.get(designator.getKind()) + "[Line: "
                    + incrementDesignator.getLine() + "]", null);
        }
    }

    // TODO treba provera za array tip
    public void visit(DecrementDesignator decrementDesignator) {
        Obj designator = decrementDesignator.getDesignator().obj;
        if (designator.getType() != Table.intType) {
            report_error("Ocekivan tip int, dobijen tip " + nazivi_tipova.get(designator.getKind()) + "[Line: "
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
        oneTerm.struct = oneTerm.getTerm().struct;
    }

    public void visit(AddOperationTerm addOperationTerm) {
        addOperationTerm.struct = addOperationTerm.getExprNoTernAddOpList().struct;
    }

    public void visit(TermList termList) {
        Struct termTree = termList.getTerm().struct;
        Struct factorStruct = termList.getExprNoTernAddOpList().struct;

        if (factorStruct.getElemType().equals(Struct.Int) && termTree.equals(factorStruct)) {
            termList.struct = termTree;
        } else {
            report_error(String.format("Nemoguce sabiranje sa tipovima (%s) i (%s)! [Line: %d]",
                    nazivi_tipova.get(termTree.getKind()),
                    nazivi_tipova.get(factorStruct.getKind()),
                    termList.getLine()), null);
        }
    }

    public void visit(AssignDesignator assignDesignator) {
        Struct designator = assignDesignator.getDesignator().obj.getType();
        Struct expression = assignDesignator.getExpr().struct;
        if (designator.equals(expression)) {
            // TODO kompatibilnost sa array???
            // assigndesignator.struct?
        } else {
            report_error("Dodela nemoguca izmedju (" +
                    nazivi_tipova.get(designator.getKind()) + ") i ("
                    + nazivi_tipova.get(expression.getKind()) + ")! [Line:"
                    + assignDesignator.getLine() + "]", null);
        }
    }

    public void visit(ExprNoTernStatement exprNoTernStatement) {
        exprNoTernStatement.struct = exprNoTernStatement.getExprNoTern().struct;
    }

    public void visit(NumericConstant numericConstant) {
        numericConstant.struct = Table.intType;
    }

    public void visit(CharacterConstant characterConstant) {
        characterConstant.struct = Table.charType;
    }

    public void visit(BooleanConstant booleanConstant) {
        booleanConstant.struct = Table.boolType;
    }

    public void visit(NoParamsDesignator NoParamsDesignator) {
        NoParamsDesignator.struct = NoParamsDesignator.getDesignator().obj.getType();
    }

    public void visit(NonMullOpTerm term) {
        term.struct = term.getFactor().struct;
    }

    public void visit(MullOpTerm termOp) {
        Struct termTree = termOp.getTerm().struct;
        Struct factorStruct = termOp.getFactor().struct;
        if (factorStruct.getElemType().equals(Struct.Int) && termTree.equals(factorStruct)) {
            termOp.struct = termTree;
        } else {
            report_error(String.format("Nemoguce sabiranje sa tipovima (%s) i (%s)! [Line: %d]",
                    nazivi_tipova.get(termTree.getKind()),
                    nazivi_tipova.get(factorStruct.getKind()),
                    termOp.getLine()), null);
        }
        // TODO equals za termove

    }

    public void visit(ReturnStmt returnStmt) {
        Struct struct = returnStmt.getReturnStmts().struct;
        if (struct.equals(currentReturnMethodType)) {
            // TODO Provera za nizove
        } else {
            report_error(String.format("Povratna vrednost metode [%s] je (%s)," +
                            " povratna vrednost je (%s)",
                    currentMethod.getName(),
                    nazivi_tipova.get(currentReturnMethodType.getKind()),
                    nazivi_tipova.get(struct.getKind())), null);
        }
    }

    public void visit(NonEmptyReturn nonEmptyReturn) {
        nonEmptyReturn.struct = nonEmptyReturn.getExpr().struct;
    }

    public void visit(EmptyReturn epsilon) {
        epsilon.struct = Table.noType;
    }
}
