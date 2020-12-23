// generated with ast extension for cup
// version 0.8
// 23/11/2020 13:17:15


package rs.ac.bg.etf.pp1.ast;

public class ConditionExpressionWithOr extends CondExpression {

    private CondExpression CondExpression;
    private CondTerm CondTerm;

    public ConditionExpressionWithOr (CondExpression CondExpression, CondTerm CondTerm) {
        this.CondExpression=CondExpression;
        if(CondExpression!=null) CondExpression.setParent(this);
        this.CondTerm=CondTerm;
        if(CondTerm!=null) CondTerm.setParent(this);
    }

    public CondExpression getCondExpression() {
        return CondExpression;
    }

    public void setCondExpression(CondExpression CondExpression) {
        this.CondExpression=CondExpression;
    }

    public CondTerm getCondTerm() {
        return CondTerm;
    }

    public void setCondTerm(CondTerm CondTerm) {
        this.CondTerm=CondTerm;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(CondExpression!=null) CondExpression.accept(visitor);
        if(CondTerm!=null) CondTerm.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(CondExpression!=null) CondExpression.traverseTopDown(visitor);
        if(CondTerm!=null) CondTerm.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(CondExpression!=null) CondExpression.traverseBottomUp(visitor);
        if(CondTerm!=null) CondTerm.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConditionExpressionWithOr(\n");

        if(CondExpression!=null)
            buffer.append(CondExpression.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(CondTerm!=null)
            buffer.append(CondTerm.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConditionExpressionWithOr]");
        return buffer.toString();
    }
}
