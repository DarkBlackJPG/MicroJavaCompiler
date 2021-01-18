// generated with ast extension for cup
// version 0.8
// 18/0/2021 18:35:13


package rs.ac.bg.etf.pp1.ast;

public class WithNumConst extends PrintStmtList {

    private Expr Expr;
    private Integer intValue;

    public WithNumConst (Expr Expr, Integer intValue) {
        this.Expr=Expr;
        if(Expr!=null) Expr.setParent(this);
        this.intValue=intValue;
    }

    public Expr getExpr() {
        return Expr;
    }

    public void setExpr(Expr Expr) {
        this.Expr=Expr;
    }

    public Integer getIntValue() {
        return intValue;
    }

    public void setIntValue(Integer intValue) {
        this.intValue=intValue;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Expr!=null) Expr.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Expr!=null) Expr.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Expr!=null) Expr.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("WithNumConst(\n");

        if(Expr!=null)
            buffer.append(Expr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(" "+tab+intValue);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [WithNumConst]");
        return buffer.toString();
    }
}
