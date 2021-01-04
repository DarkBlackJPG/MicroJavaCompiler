// generated with ast extension for cup
// version 0.8
// 3/0/2021 19:14:3


package rs.ac.bg.etf.pp1.ast;

public class ExprTernStatement extends Expr {

    private BeginTernary BeginTernary;
    private ExprNoTern ExprNoTern;
    private ExprNoTern ExprNoTern1;

    public ExprTernStatement (BeginTernary BeginTernary, ExprNoTern ExprNoTern, ExprNoTern ExprNoTern1) {
        this.BeginTernary=BeginTernary;
        if(BeginTernary!=null) BeginTernary.setParent(this);
        this.ExprNoTern=ExprNoTern;
        if(ExprNoTern!=null) ExprNoTern.setParent(this);
        this.ExprNoTern1=ExprNoTern1;
        if(ExprNoTern1!=null) ExprNoTern1.setParent(this);
    }

    public BeginTernary getBeginTernary() {
        return BeginTernary;
    }

    public void setBeginTernary(BeginTernary BeginTernary) {
        this.BeginTernary=BeginTernary;
    }

    public ExprNoTern getExprNoTern() {
        return ExprNoTern;
    }

    public void setExprNoTern(ExprNoTern ExprNoTern) {
        this.ExprNoTern=ExprNoTern;
    }

    public ExprNoTern getExprNoTern1() {
        return ExprNoTern1;
    }

    public void setExprNoTern1(ExprNoTern ExprNoTern1) {
        this.ExprNoTern1=ExprNoTern1;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(BeginTernary!=null) BeginTernary.accept(visitor);
        if(ExprNoTern!=null) ExprNoTern.accept(visitor);
        if(ExprNoTern1!=null) ExprNoTern1.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(BeginTernary!=null) BeginTernary.traverseTopDown(visitor);
        if(ExprNoTern!=null) ExprNoTern.traverseTopDown(visitor);
        if(ExprNoTern1!=null) ExprNoTern1.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(BeginTernary!=null) BeginTernary.traverseBottomUp(visitor);
        if(ExprNoTern!=null) ExprNoTern.traverseBottomUp(visitor);
        if(ExprNoTern1!=null) ExprNoTern1.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ExprTernStatement(\n");

        if(BeginTernary!=null)
            buffer.append(BeginTernary.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ExprNoTern!=null)
            buffer.append(ExprNoTern.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ExprNoTern1!=null)
            buffer.append(ExprNoTern1.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ExprTernStatement]");
        return buffer.toString();
    }
}
