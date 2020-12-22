// generated with ast extension for cup
// version 0.8
// 22/11/2020 19:29:48


package rs.ac.bg.etf.pp1.ast;

public class ExpressionWithTernary extends Expr {

    private ExprTern ExprTern;

    public ExpressionWithTernary (ExprTern ExprTern) {
        this.ExprTern=ExprTern;
        if(ExprTern!=null) ExprTern.setParent(this);
    }

    public ExprTern getExprTern() {
        return ExprTern;
    }

    public void setExprTern(ExprTern ExprTern) {
        this.ExprTern=ExprTern;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ExprTern!=null) ExprTern.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ExprTern!=null) ExprTern.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ExprTern!=null) ExprTern.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ExpressionWithTernary(\n");

        if(ExprTern!=null)
            buffer.append(ExprTern.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ExpressionWithTernary]");
        return buffer.toString();
    }
}
