// generated with ast extension for cup
// version 0.8
// 29/11/2020 14:25:28


package rs.ac.bg.etf.pp1.ast;

public class ExprTernStatement extends Expr {

    private CondFactor CondFactor;
    private ExprNoTern ExprNoTern;
    private ExprNoTern ExprNoTern1;

    public ExprTernStatement (CondFactor CondFactor, ExprNoTern ExprNoTern, ExprNoTern ExprNoTern1) {
        this.CondFactor=CondFactor;
        if(CondFactor!=null) CondFactor.setParent(this);
        this.ExprNoTern=ExprNoTern;
        if(ExprNoTern!=null) ExprNoTern.setParent(this);
        this.ExprNoTern1=ExprNoTern1;
        if(ExprNoTern1!=null) ExprNoTern1.setParent(this);
    }

    public CondFactor getCondFactor() {
        return CondFactor;
    }

    public void setCondFactor(CondFactor CondFactor) {
        this.CondFactor=CondFactor;
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
        if(CondFactor!=null) CondFactor.accept(visitor);
        if(ExprNoTern!=null) ExprNoTern.accept(visitor);
        if(ExprNoTern1!=null) ExprNoTern1.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(CondFactor!=null) CondFactor.traverseTopDown(visitor);
        if(ExprNoTern!=null) ExprNoTern.traverseTopDown(visitor);
        if(ExprNoTern1!=null) ExprNoTern1.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(CondFactor!=null) CondFactor.traverseBottomUp(visitor);
        if(ExprNoTern!=null) ExprNoTern.traverseBottomUp(visitor);
        if(ExprNoTern1!=null) ExprNoTern1.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ExprTernStatement(\n");

        if(CondFactor!=null)
            buffer.append(CondFactor.toString("  "+tab));
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
