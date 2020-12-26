// generated with ast extension for cup
// version 0.8
// 26/11/2020 20:18:35


package rs.ac.bg.etf.pp1.ast;

public class NonEmptyRelationalExpression extends RelationalExpression {

    private RelOp RelOp;
    private ExprNoTern ExprNoTern;

    public NonEmptyRelationalExpression (RelOp RelOp, ExprNoTern ExprNoTern) {
        this.RelOp=RelOp;
        if(RelOp!=null) RelOp.setParent(this);
        this.ExprNoTern=ExprNoTern;
        if(ExprNoTern!=null) ExprNoTern.setParent(this);
    }

    public RelOp getRelOp() {
        return RelOp;
    }

    public void setRelOp(RelOp RelOp) {
        this.RelOp=RelOp;
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
        if(RelOp!=null) RelOp.accept(visitor);
        if(ExprNoTern!=null) ExprNoTern.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(RelOp!=null) RelOp.traverseTopDown(visitor);
        if(ExprNoTern!=null) ExprNoTern.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(RelOp!=null) RelOp.traverseBottomUp(visitor);
        if(ExprNoTern!=null) ExprNoTern.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("NonEmptyRelationalExpression(\n");

        if(RelOp!=null)
            buffer.append(RelOp.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ExprNoTern!=null)
            buffer.append(ExprNoTern.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [NonEmptyRelationalExpression]");
        return buffer.toString();
    }
}
