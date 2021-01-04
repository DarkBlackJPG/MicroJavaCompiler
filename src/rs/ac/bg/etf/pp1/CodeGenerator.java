package rs.ac.bg.etf.pp1;

import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.mj.runtime.*;
import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Struct;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Stack;

public class CodeGenerator extends VisitorAdaptor {
    private int mainPC;
    public CodeGenerator() {
        relOpHashMap.put("==", Code.eq);
        relOpHashMap.put(">", Code.gt);
        relOpHashMap.put(">=", Code.ge);
        relOpHashMap.put("!=", Code.ne);
        relOpHashMap.put("<=", Code.le);
        relOpHashMap.put("<", Code.lt);
    }

    public int getMainPC() {
        return mainPC;
    }

    public void setMainPC(int mainPC) {
        this.mainPC = mainPC;

    }

    private void readBoolean() {

    }

    private void printTrue() {
        Code.loadConst('t');
        Code.loadConst(2);
        Code.put(Code.bprint);
        Code.loadConst('r');
        Code.loadConst(1);
        Code.put(Code.bprint);
        Code.loadConst('u');
        Code.loadConst(1);
        Code.put(Code.bprint);
        Code.loadConst('e');
        Code.loadConst(1);
        Code.put(Code.bprint);
    }

    private void printFalse() {
        Code.loadConst('f');
        Code.loadConst(2);
        Code.put(Code.bprint);
        Code.loadConst('a');
        Code.loadConst(1);
        Code.put(Code.bprint);
        Code.loadConst('l');
        Code.loadConst(1);
        Code.put(Code.bprint);
        Code.loadConst('s');
        Code.loadConst(1);
        Code.put(Code.bprint);
        Code.loadConst('e');
        Code.loadConst(1);
        Code.put(Code.bprint);
    }

    public void visit(MethodTypeName methodTypeName) {
        if ("main".equalsIgnoreCase(methodTypeName.getMethodIdentification())) {
            setMainPC(Code.pc);
        }
        methodTypeName.obj.setAdr(Code.pc);

        SyntaxNode parent = methodTypeName.getParent();

        CounterVisitor.FormalParamCounter formalParamCounter = new CounterVisitor.FormalParamCounter();
        parent.traverseTopDown(formalParamCounter);

        CounterVisitor.MethodVariablesCounter methodVariablesCounter = new CounterVisitor.MethodVariablesCounter();
        parent.traverseTopDown(methodVariablesCounter);

        Code.put(Code.enter);
        Code.put(formalParamCounter.getCount());
        Code.put(formalParamCounter.getCount() + methodVariablesCounter.getCount());
    }

    public void visit(OneMethodDeclaration oneMethodDeclaration) {
        Code.put(Code.exit);
        Code.put(Code.return_);
    }

    // PrintStmtList ::= (NoNumConst) Expr;
    // Postavljamo samo sirinu na stek
    public void visit(NoNumConst noNumConst) {

        Obj expression = noNumConst.getExpr().obj;
        if (expression.getType().getKind() == Struct.Int) {
            Code.loadConst(4);
            Code.put(Code.print);
        } else if (expression.getType().getKind() == Struct.Char) {
            // Char and Boolean
            Code.loadConst(1);
            Code.put(Code.bprint);
        } else {
            int jumpIfFalseLocation;
            int jumpEndExpression;
            Code.put(Code.dup);
            Code.loadConst(1);
            Code.putFalseJump(Code.eq, 0);
            jumpIfFalseLocation = Code.pc - 2;
            printTrue();
            Code.putJump(0);
            jumpEndExpression = Code.pc - 2;

            Code.fixup(jumpIfFalseLocation);
            printFalse();
            Code.fixup(jumpEndExpression);
            Code.put(Code.pop);
        }

    }

    // PrintStmtList ::= (WithNumConst) Expr COMMA NUM_CONST:intValue;
    public void visit(WithNumConst withNumConst) {
        Obj expression = withNumConst.getExpr().obj;
        int x = 5;
        for(int i = 0; i < withNumConst.getIntValue(); i++) {
            if (expression.getType().getKind() == Struct.Int) {
                Code.loadConst(x);
                Code.put(Code.print);
            } else if (expression.getType().getKind() == Struct.Char) {
                // Char and Boolean
                // Boolean => 't' za true, 'f' false za false
                Code.loadConst(x);
                Code.put(Code.bprint);
            } else {
                int jumpIfFalseLocation;
                int jumpEndExpression;
                Code.put(Code.dup);
                Code.loadConst(1);
                Code.putFalseJump(Code.eq, 0);
                jumpIfFalseLocation = Code.pc - 2;
                printTrue();
                Code.putJump(0);
                jumpEndExpression = Code.pc - 2;

                Code.fixup(jumpIfFalseLocation);
                printFalse();
                Code.fixup(jumpEndExpression);
            }
        }
        Code.put(Code.pop);
    }

    public void visit(AssignDesignator assignDesignator) {
        boolean[] notNew = {true};

        assignDesignator.traverseTopDown(new VisitorAdaptor() {
            public void visit(NewTypeArray newTypeArray) {
                notNew[0] = false;
            }
        });

        if (assignDesignator.getDesignator().obj.getType().getKind() == Struct.Array && notNew[0]) {
            if (assignDesignator.getDesignator().obj.getType().getElemType().getKind() == Struct.Int) {
                Code.put(Code.astore);
            } else {
                Code.put(Code.bastore);
            }
        } else {
            Code.store(assignDesignator.getDesignator().obj);
        }

    }

    public void visit(CleanDesignator cleanDesignator) {
        SyntaxNode parent = cleanDesignator.getParent();
        if (AssignDesignator.class != parent.getClass()
        && ReadStmt.class != parent.getClass()) {
            Code.load(cleanDesignator.obj);
        }
    }

    public void visit(ArrayElementAccessDesignator arrayElementAccessDesignator) {
        // Expression postavlja broj
        SyntaxNode parent = arrayElementAccessDesignator.getParent();

        if (parent.getClass() != AssignDesignator.class && parent.getClass() != ReadStmt.class) {
            if (arrayElementAccessDesignator.getDesignatorList().obj.getType().getKind() == Struct.Char) {
                Code.put(Code.baload);
            } else {
                Code.put(Code.aload);
            }
        }
    }

    public void visit(DesignatorListOneElement designatorListOneElement) {
        Code.load(designatorListOneElement.obj);
    }

    // TODO za matrice
    public void visit(ArrayElementDesignatorList arrayElementDesignatorList) {

    }

    // Todo
    public void visit(ExprTernStatement exprNoTernStatement) {
        Table.openScope();
        Obj falseOpt = Table.insert(Obj.Var, "a", exprNoTernStatement.obj.getType());
        Obj trueOpt = Table.insert(Obj.Var, "b", exprNoTernStatement.obj.getType());
        Code.store(falseOpt);
        Code.store(trueOpt);
        Table.closeScope();
        int fwdJmpIfFalse;
        int fwdJmpEnd;
        int relopCode = ternaryRelopStack.pop();
        Code.putFalseJump(relopCode, 0);
        fwdJmpIfFalse = Code.pc - 2;
        Code.load(trueOpt);
        Code.putJump(0);
        fwdJmpEnd = Code.pc - 2;

        Code.fixup(fwdJmpIfFalse);
        Code.load(falseOpt);
        Code.fixup(fwdJmpEnd);
    }

    // Todo
    public void visit(NegativeTerm negativeTerm) {
        Code.put(Code.neg);

    }

    public void visit(AddOperationTerm addOperationTerm) {

    }

    public void visit(TermList termList) {
        if (termList.getAddOp() instanceof AddopPlus) {
            Code.put(Code.add);
        } else {
            Code.put(Code.sub);
        }
    }


    // Todo
    public void visit(MullOpTerm mullOpTerm) {
        MulOp mullOp = mullOpTerm.getMulOp();
        if (mullOp instanceof MulopTimes) {
            Code.put(Code.mul);
        } else if (mullOp instanceof MulopDivide) {
            Code.put(Code.div);
        } else {
            Code.put(Code.rem);
        }


    }

    HashMap<String, Integer> relOpHashMap = new HashMap<>();
    Stack<Integer> ternaryRelopStack = new Stack<>();

    public void visit(BeginTernary beginTernary) {

    }

    public void visit(ExpressionConditionFactor expressionConditionFactor) {
        if (expressionConditionFactor.getRelationalExpression().obj.getType().getKind() == Struct.None) {
            Code.loadConst(1);
            ternaryRelopStack.push(Code.eq);
        }
    }

    public void visit(NonEmptyRelationalExpression nonEmptyRelationalExpression) {
        Integer relop = relOpHashMap.get(nonEmptyRelationalExpression.getRelOp().obj.getName());
        ternaryRelopStack.push(relop);
    }

    // Todo
    public void visit(NumericConstant numericConstant) {
        Obj con = Table.insert(Obj.Con, "$", numericConstant.obj.getType());
        con.setLevel(0);
        con.setAdr(numericConstant.getNumValue());
        Code.load(con);
    }

    // Todo
    public void visit(CharacterConstant characterConstant) {

        Obj con = Table.insert(Obj.Con, "$", characterConstant.obj.getType());
        con.setLevel(0);
        con.setAdr(characterConstant.getCharValue());

        Code.load(con);
    }

    // Todo
    public void visit(BooleanConstant booleanConstant) {

        if (booleanConstant.getBoolValue().equalsIgnoreCase("true")) {
            Code.load(new Obj(Obj.Con, "$bool", new Struct(Struct.Bool), 1, 0));
        } else {
            Code.load(new Obj(Obj.Con, "$bool", new Struct(Struct.Bool), 0, 0));
        }
    }

    // Todo
    public void visit(NumericLiteral numericLiteral) {
        Obj con = Table.insert(Obj.Con, "$", numericLiteral.obj.getType());
        con.setLevel(0);
        con.setAdr(numericLiteral.getNumValue());
        Code.load(con);
    }

    // Todo
    public void visit(BooleanLiteral booleanLiteral) {

        if (booleanLiteral.getBooleanValue().equalsIgnoreCase("true")) {
            //printTrue();
            Code.load(new Obj(Obj.Con, "$bool", new Struct(Struct.Bool), 1, 1));
        } else {
            Code.load(new Obj(Obj.Con, "$bool", new Struct(Struct.Bool), 0, 1));
        }
    }

    // Todo
    public void visit(CharLiteral charLiteral) {
        Obj con = Table.insert(Obj.Con, "$", charLiteral.obj.getType());
        con.setLevel(0);
        con.setAdr(charLiteral.getCharValue());
        Code.load(con);
    }

    // TODO resiti inkrementiranje za nizovne tipove
    public void visit(IncrementDesignator incrementDesignator) {
        Code.loadConst(1);
        Code.put(Code.add);
        Code.store(incrementDesignator.getDesignator().obj);
    }

    // TODO resiti dekrementiranje za nizovne tipove
    public void visit(DecrementDesignator incrementDesignator) {
        Code.loadConst(1);
        Code.put(Code.neg);
        Code.put(Code.add);
        Code.store(incrementDesignator.getDesignator().obj);
    }

    // TODo read samo zabada
    public void visit(ReadStmt readStmt) {
        Obj o = readStmt.getDesignator().obj;
        if (o.getType().getKind() == Struct.Int) {
            Code.put(Code.read);
        } else if (o.getType().getKind() == Struct.Char) {
            Code.put(Code.bread);
        } else if (o.getType().getKind() == Struct.Bool) {
            Code.put(Code.bread);
            Code.loadConst('t');
            int jumpIfFalse;
            int jumpToEnd;
            Code.putFalseJump(Code.eq, 0);
            jumpIfFalse = Code.pc - 2;
            Code.loadConst(1);
            Code.putJump(0);
            jumpToEnd = Code.pc - 2;

            Code.fixup(jumpIfFalse);
            Code.loadConst(0);
            Code.fixup(jumpToEnd);
        }
        Code.store(o);
    }

    // Kad dodjemo do ovog delea, trebalo bi da imamo na steku vec velicinu niza
    // Ova metoda treba da postavi adresu niza
    public void visit(NewTypeArray newTypeArray) {

        Code.put(Code.newarray);
        if (newTypeArray.getType().obj.getType().getKind() == Struct.Int) {
            Code.put(1);
        } else {
            Code.put(0);
        }
    }
}
