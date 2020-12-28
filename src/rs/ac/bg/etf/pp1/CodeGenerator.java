package rs.ac.bg.etf.pp1;

import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.mj.runtime.Code;
import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Struct;

import java.lang.reflect.Method;

public class CodeGenerator extends VisitorAdaptor {
    private int mainPC;

    public int getMainPC() {
        return mainPC;
    }

    public void setMainPC(int mainPC) {
        this.mainPC = mainPC;

    }
    private void printTrue() {
        Obj t = new Obj(Obj.Con, "$", Table.charType, 't', 0);
        Obj r = new Obj(Obj.Con, "$", Table.charType, 'r', 0);
        Obj u = new Obj(Obj.Con, "$", Table.charType, 'u', 0);
        Obj e = new Obj(Obj.Con, "$", Table.charType, 'e', 0);
        Code.load(t);
        Code.loadConst(2);
        Code.put(Code.bprint);
        Code.load(r);
        Code.loadConst(1);
        Code.put(Code.bprint);
        Code.load(u);
        Code.loadConst(1);
        Code.put(Code.bprint);
        Code.load(e);
        Code.loadConst(1);
        Code.put(Code.bprint);
    }
    private void printFalse() {
        Obj f = new Obj(Obj.Con, "$", Table.charType, 'f', 0);
        Obj a = new Obj(Obj.Con, "$", Table.charType, 'a', 0);
        Obj l = new Obj(Obj.Con, "$", Table.charType, 'l', 0);
        Obj s = new Obj(Obj.Con, "$", Table.charType, 's', 0);
        Obj e = new Obj(Obj.Con, "$", Table.charType, 'e', 0);
        Code.load(f);
        Code.loadConst(2);
        Code.put(Code.bprint);
        Code.load(a);
        Code.loadConst(1);
        Code.put(Code.bprint);
        Code.load(l);
        Code.loadConst(1);
        Code.put(Code.bprint);
        Code.load(s);
        Code.loadConst(1);
        Code.put(Code.bprint);
        Code.load(e);
        Code.loadConst(1);
        Code.put(Code.bprint);
    }
    public void visit(MethodTypeName methodTypeName) {
        if("main".equalsIgnoreCase(methodTypeName.getMethodIdentification())) {
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
        if(expression.getType().getKind() == Struct.Int) {
            Code.loadConst(4);
            Code.put(Code.print);
        } else if(expression.getType().getKind() == Struct.Char){
            // Char and Boolean
            Code.loadConst(1);
            Code.put(Code.bprint);
        } else {
             // Bool
        }

    }
    // PrintStmtList ::= (WithNumConst) Expr COMMA NUM_CONST:intValue;
    // TODO Sta ovo uopste radi? Msm sta radi onaj int
    public void visit(WithNumConst withNumConst) {
        Obj expression = withNumConst.getExpr().obj;
        if(expression.getType().getKind() == Struct.Int) {
            Code.loadConst(withNumConst.getIntValue());
            Code.put(Code.print);
        } else if(expression.getType().getKind() == Struct.Char){
            // Char and Boolean
            // Boolean => 't' za true, 'f' false za false
            Code.loadConst(withNumConst.getIntValue());
            Code.put(Code.bprint);
        } else {
            // Bool
        }
    }

    public void visit(AssignDesignator assignDesignator) {
        Code.store(assignDesignator.getDesignator().obj);
    }
    public void visit(CleanDesignator cleanDesignator) {
        SyntaxNode parent = cleanDesignator.getParent();

        // Todo tu treba napisati takav if gde mi potvrdjujemo da ovaj designator se koristi samo u assignop
        if (AssignDesignator.class != parent.getClass()) {
            Code.load(cleanDesignator.obj);
        }

    }
    // Todo
    public void visit(ExprNoTernStatement exprNoTernStatement) {

    }
    // Todo
    public void visit(ExprTernStatement exprNoTernStatement) {

    }
    // Todo
    public void visit(NegativeTerm negativeTerm) {

    }
    // Todo
    public void visit(AddOperationTerm addOperationTerm) {

    }
    // Todo
    public void visit(OneTerm oneTerm) {

    }
    // Todo
    public void visit(NonMullOpTerm nonMullOpTerm) {

    }
    // Todo
    public void visit(MullOpTerm mullOpTerm) {

    }
    // Todo
    public void visit(NoParamsDesignator noParamsDesignator) {

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
//        Obj con = Table.insert(Obj.Con, "$", booleanConstant.obj.getType());
//        con.setLevel(0);
//        con.setAdr((booleanConstant.getBoolValue().equalsIgnoreCase("true")) ? 1 : 0);
        if (booleanConstant.getBoolValue().equalsIgnoreCase("true")) {
           printTrue();
        } else {
           printFalse();
        }
    }
    // Todo
    public void visit(NumericLiteral numericLiteral) {
        Obj con = Table.insert(Obj.Con, "$", numericLiteral.obj.getType());
        con.setLevel(0);
        con.setAdr(numericLiteral.getNumValue());
        //Code.load(con);
    }
    // Todo
    public void visit(BooleanLiteral booleanLiteral) {
        if (booleanLiteral.getBooleanValue().equalsIgnoreCase("true")) {
          printTrue();
        } else {
          printFalse();
        }
    }
    // Todo
    public void visit(CharLiteral charLiteral) {
        Obj con = Table.insert(Obj.Con, "$", charLiteral.obj.getType());
        con.setLevel(0);
        con.setAdr(charLiteral.getCharValue());

        //Code.load(con);
    }


}
