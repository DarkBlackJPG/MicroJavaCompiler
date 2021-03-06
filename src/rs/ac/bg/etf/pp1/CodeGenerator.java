package rs.ac.bg.etf.pp1;

import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.mj.runtime.*;
import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Struct;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
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

        if (expression.getType().getKind() == Struct.Int) {
            Code.loadConst(x);
            for (int i = 0; i < withNumConst.getIntValue(); i++) {
                Code.put(Code.dup2);
            }

            for (int i = 0; i < withNumConst.getIntValue(); i++)
                Code.put(Code.print);
        } else if (expression.getType().getKind() == Struct.Char) {
            // Char and Boolean
            // Boolean => 't' za true, 'f' false za false

            Code.loadConst(x);
            for (int i = 0; i < withNumConst.getIntValue(); i++) {
                Code.put(Code.dup2);
            }

            for (int i = 0; i < withNumConst.getIntValue(); i++)
                Code.put(Code.bprint);

        } else {
            for (int i = 0; i < withNumConst.getIntValue(); i++) {
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

    private boolean assignableTo(Struct assignee, Struct dest) {
        return assignee.equals(dest) || assignee == Table.nullType && dest.isRefType() || assignee.getKind() == 3 && dest.getKind() == 3 && dest.getElemType() == Table.noType;
    }

    public void visit(AssignDesignator assignDesignator) {
        boolean[] notNew = {true};

        assignDesignator.traverseBottomUp(new VisitorAdaptor() {
            public void visit(NewTypeArray newTypeArray) {
                notNew[0] = false;
            }
        });

        if (assignDesignator.getDesignator().obj.getType().getKind() == Struct.Array && notNew[0]) {

            if (assignDesignator.getDesignator().obj.getType().getElemType().getKind() == Struct.Int) {
                if (assignableTo(assignDesignator.getExpr().obj.getType(), assignDesignator.getDesignator().obj.getType())) {
                    Code.store(assignDesignator.getDesignator().obj);
                } else {
                    Code.put(Code.astore);
                }
            } else if (assignDesignator.getDesignator().obj.getType().getElemType().getKind() == Struct.Char
                    || assignDesignator.getDesignator().obj.getType().getElemType().getKind() == Struct.Bool) {
                if (assignableTo(assignDesignator.getExpr().obj.getType(), assignDesignator.getDesignator().obj.getType())) {
                    Code.store(assignDesignator.getDesignator().obj);
                } else {
                    Code.put(Code.bastore);
                }

            }
        } else {
            if (assignDesignator.getDesignator() instanceof ArrayElementAccessDesignator && notNew[0]) {
                ArrayElementAccessDesignator s = (ArrayElementAccessDesignator) assignDesignator.getDesignator();
                Obj ss = s.getDesignatorList().obj;
                int fpos = ss.getFpPos();
                if (fpos == -5) {

                    Obj index = Table.insert(Obj.Var, "sad2wf2ef", Table.intType);
                    Obj original = Table.insert(Obj.Var, "sad2wf2ef", Table.intType);
                    Obj value = Table.insert(Obj.Var, "sadsadasdwqfqwf", Table.intType);
                    Obj array = Table.insert(Obj.Var, "BULLLSHISADHIUASHDIUSAH", Table.intType);
                    Code.put(Code.dup2);
                    Code.put(Code.pop);
                    Code.load(ss);
                    Code.put(Code.arraylength);
                    Code.loadConst(2);
                    Code.put(Code.div);
                    Code.put(Code.add);
                    Code.load(ss);

                    Code.put(Code.enter);
                    Code.put(0);
                    Code.put(4);
                    Code.store(array);
                    Code.store(index);
                    Code.store(value);
                    Code.store(original);
                    Code.load(index);
                    Code.put(Code.aload);
                    Code.loadConst(0);
                    int ifFalseJumpFixupAddress;
                    Code.putFalseJump(Code.eq, 0);
                    ifFalseJumpFixupAddress = Code.pc - 2;
                    Code.load(array);
                    Code.load(index);
                    Code.loadConst(1);
                    Code.put(Code.astore);
                    Code.load(array);
                    Code.load(original);
                    Code.load(value);
                    Code.put(Code.astore);
                    Code.fixup(ifFalseJumpFixupAddress);
                    Code.put(Code.exit);
                }
            } else {
                Code.store(assignDesignator.getDesignator().obj);
            }
        }

    }

    private boolean isFinal = false;

    public void visit(CleanDesignator cleanDesignator) {
        SyntaxNode parent = cleanDesignator.getParent();
        if (cleanDesignator.obj.getFpPos() == -5) {
            isFinal = true;
        }
        if (AssignDesignator.class != parent.getClass()
                && ReadStmt.class != parent.getClass()
                && cleanDesignator.obj.getKind() != Obj.Meth) {
            Code.load(cleanDesignator.obj);
        }

    }

//
//    private HashMap<String, Integer> jumpAddress = new HashMap<>();
//
//    public void visit(LabelDefinition labelDefinition) {
//        String identification = labelDefinition.getIdentification();
//        int currentJumpAddress;
//        if (jumpAddress.get(identification) == null) {
//            //Code.putJump(0);
//            jumpAddress.put(identification, Code.pc); // Ako je adresa < 0 to znaci da jos ne znamo adresu na koju skacemo
//        } else {
//            if (jumpAddress.get(identification) > 0) {
//                System.exit(-10000);
//            } else {
//                currentJumpAddress = jumpAddress.get(identification) * -1;
//                Code.fixup(currentJumpAddress);
//            }
//        }
//    }
//
//    public void visit(GotoStatement gotoStatement) {
//        String identification = gotoStatement.getIdentification();
//        int currentJumpAddress;
//        if (jumpAddress.get(identification) == null) {
//            Code.putJump(0);
//            jumpAddress.put(identification, (Code.pc - 2) * -1); // Ako je adresa < 0 to znaci da jos ne znamo adresu na koju skacemo
//        } else {
//            currentJumpAddress = jumpAddress.get(identification);
//            Code.putJump(currentJumpAddress);
//        }
//    }

    public void visit(ArrayElementAccessDesignator arrayElementAccessDesignator) {
        SyntaxNode parent = arrayElementAccessDesignator.getParent();
        if (parent.getClass() != DecrementDesignator.class && parent.getClass() != IncrementDesignator.class) {
            if (parent.getClass() != AssignDesignator.class && parent.getClass() != ReadStmt.class) {
                if (arrayElementAccessDesignator.getDesignatorList().obj.getType().getElemType().getKind() == Struct.Char) {
                    Code.put(Code.baload);
                } else {
                    Code.put(Code.aload);
                }
            }
        } else {
            Code.put(Code.dup2);
            if (arrayElementAccessDesignator.getDesignatorList().obj.getType().getElemType().getKind() == Struct.Char) {
                Code.put(Code.baload);
            } else {
                Code.put(Code.aload);
            }
        }
    }

    public void visit(DesignatorListOneElement designatorListOneElement) {
        Obj o = designatorListOneElement.obj;
        Code.load(o);
    }

    public void visit(ArrayElementDesignatorList arrayElementAccessDesignator) {
        SyntaxNode parent = arrayElementAccessDesignator.getParent();
        if (parent.getClass() != DecrementDesignator.class && parent.getClass() != IncrementDesignator.class) {
            if (parent.getClass() != AssignDesignator.class && parent.getClass() != ReadStmt.class) {
                if (arrayElementAccessDesignator.getDesignatorList().obj.getType().getKind() == Struct.Char) {
                    Code.put(Code.baload);
                } else {
                    Code.put(Code.aload);
                }
            }
        } else {
            Code.put(Code.dup2);
            if (arrayElementAccessDesignator.getDesignatorList().obj.getType().getKind() == Struct.Char) {
                Code.put(Code.baload);
            } else {
                Code.put(Code.aload);
            }
        }
    }

    public void visit(ExprTernStatement exprNoTernStatement) {
        Code.put(Code.enter);
        Code.put(0);
        Code.put(4);
        Obj falseOpt = Table.insert(Obj.Var, "$$_123432213ab_$$", exprNoTernStatement.obj.getType());
        Obj trueOpt = Table.insert(Obj.Var, "$$_123432213ba$$", exprNoTernStatement.obj.getType());
        Code.store(falseOpt);
        Code.store(trueOpt);
        int falseJumpAddress;
        int jumpToEndAdress;
        int relopCode = ternaryRelopStack.pop();
        Code.putFalseJump(relopCode, 0);
        falseJumpAddress = Code.pc - 2;
        Code.load(trueOpt);
        Code.putJump(0);
        jumpToEndAdress = Code.pc - 2;
        Code.fixup(falseJumpAddress);
        Code.load(falseOpt);
        Code.fixup(jumpToEndAdress);
        Code.put(Code.exit);
    }

    public void visit(NegativeTerm negativeTerm) {
        Code.put(Code.neg);
    }

    public void visit(ParamsDesignator paramsDesignator) {
        String o = paramsDesignator.getDesignator().obj.getName();
        if (o.equals("ord")) {
            // empty
        } else if (o.equals("len")) {
            Code.put(Code.arraylength);
        } else if (o.equals("chr")) {
            // empty
        }
    }

    public void visit(TermList termList) {
        if (termList.getAddOp() instanceof AddopPlus) {
            Code.put(Code.add);
        } else {
            Code.put(Code.sub);
        }
    }

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

//    public void visit(BeginTernary beginTernary) {
//
//    }

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

    public void visit(NumericConstant numericConstant) {
        Obj con = Table.insert(Obj.Con, "$", numericConstant.obj.getType());
        con.setLevel(0);
        con.setAdr(numericConstant.getNumValue());
        Code.load(con);
    }

    public void visit(CharacterConstant characterConstant) {

        Obj con = Table.insert(Obj.Con, "$", characterConstant.obj.getType());
        con.setLevel(0);
        con.setAdr(characterConstant.getCharValue());

        Code.load(con);
    }

    public void visit(BooleanConstant booleanConstant) {

        if (booleanConstant.getBoolValue().equalsIgnoreCase("true")) {
            Code.load(new Obj(Obj.Con, "$bool", new Struct(Struct.Bool), 1, 0));
        } else {
            Code.load(new Obj(Obj.Con, "$bool", new Struct(Struct.Bool), 0, 0));
        }
    }

    public void visit(NumericLiteral numericLiteral) {
        Obj con = Table.insert(Obj.Con, "$", numericLiteral.obj.getType());
        con.setLevel(0);
        con.setAdr(numericLiteral.getNumValue());
        Code.load(con);
    }

    public void visit(BooleanLiteral booleanLiteral) {

        if (booleanLiteral.getBooleanValue().equalsIgnoreCase("true")) {
            //printTrue();
            Code.load(new Obj(Obj.Con, "$bool", new Struct(Struct.Bool), 1, 1));
        } else {
            Code.load(new Obj(Obj.Con, "$bool", new Struct(Struct.Bool), 0, 1));
        }
    }

    public void visit(CharLiteral charLiteral) {
        Obj con = Table.insert(Obj.Con, "$", charLiteral.obj.getType());
        con.setLevel(0);
        con.setAdr(charLiteral.getCharValue());
        Code.load(con);
    }

    public void visit(IncrementDesignator incrementDesignator) {
        Code.loadConst(1);
        Code.put(Code.add);
        Code.store(incrementDesignator.getDesignator().obj);
    }

    public void visit(DecrementDesignator incrementDesignator) {
        Code.loadConst(1);
        Code.put(Code.neg);
        Code.put(Code.add);
        Code.store(incrementDesignator.getDesignator().obj);
    }

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
            Code.put(Code.bread); // r
            Code.put(Code.bread); // u
            Code.put(Code.bread); // e
            Code.put(Code.pop);
            Code.put(Code.pop);
            Code.put(Code.pop);
            Code.loadConst(1);
            Code.putJump(0);
            jumpToEnd = Code.pc - 2;
            Code.fixup(jumpIfFalse);
            Code.put(Code.bread); // a
            Code.put(Code.bread); // l
            Code.put(Code.bread); // s
            Code.put(Code.bread); // e
            Code.put(Code.pop);
            Code.put(Code.pop);
            Code.put(Code.pop);
            Code.put(Code.pop);
            Code.loadConst(0);
            Code.fixup(jumpToEnd);
        }
        Code.store(o);


//      TODO jebeni read wtf jebote

//        Code.put(Code.bread); // Read IN
//        Code.loadConst(10); // Put eol value
//        int jumpIfFalse; /// check if eol
//        int jumpIfFalse2; // Check if carrige return
//
//        Code.putFalseJump(Code.eq, 0); // put relop
//        jumpIfFalse = Code.pc - 2; // Remember fixup address
//        Code.put(Code.pop); // What to do if true
//        Code.fixup(jumpIfFalse); // Fixup jumpIfFalse address
//
//
//        Code.loadConst(13); // Put carrige return ASCII value
//        Code.putFalseJump(Code.eq, 0); // Relop
//        jumpIfFalse2 = Code.pc - 2; // Remember address
//        Code.put(Code.pop); // What to do if true
//        Code.fixup(jumpIfFalse2);


    }


    // Kad dodjemo do ovog delea, trebalo bi da imamo na steku vec velicinu niza
    // Ova metoda treba da postavi adresu niza
    public void visit(NewTypeArray newTypeArray) {
        if (isFinal) {
            Code.loadConst(2);
            Code.put(Code.mul);
        }
        Code.put(Code.newarray);
        if (newTypeArray.getType().obj.getType().getKind() == Struct.Int || newTypeArray.getType().obj.getType().getKind() == Struct.Bool) {
            Code.put(1);
        } else {
            Code.put(0);
        }
    }
}