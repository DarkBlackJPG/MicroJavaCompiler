// generated with ast extension for cup
// version 0.8
// 27/11/2020 18:54:14


package rs.ac.bg.etf.pp1.ast;

public class ExprNoTernStatement extends Expr {

    private ExprNoTern ExprNoTern;

    public ExprNoTernStatement (ExprNoTern ExprNoTern) {
        this.ExprNoTern=ExprNoTern;
        if(ExprNoTern!=null) ExprNoTern.setParent(this);
    }

    public ExprNoTern getExprNoTern() {
        return ExprNoTern;
    }

    public void setExprNoTern(ExprNoTern ExprNoTern) {
        this.ExprNoTern=ExprNoTern;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ExprNoTern!=null) ExprNoTern.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ExprNoTern!=null) ExprNoTern.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ExprNoTern!=null) ExprNoTern.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ExprNoTernStatement(\n");

        if(ExprNoTern!=null)
            buffer.append(ExprNoTern.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ExprNoTernStatement]");
        return buffer.toString();
    }
}
