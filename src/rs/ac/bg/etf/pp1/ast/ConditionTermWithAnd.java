// generated with ast extension for cup
// version 0.8
// 21/11/2020 21:18:6


package rs.ac.bg.etf.pp1.ast;

public class ConditionTermWithAnd extends CondTerm {

    private CondExpression CondExpression;
    private CondFactor CondFactor;

    public ConditionTermWithAnd (CondExpression CondExpression, CondFactor CondFactor) {
        this.CondExpression=CondExpression;
        if(CondExpression!=null) CondExpression.setParent(this);
        this.CondFactor=CondFactor;
        if(CondFactor!=null) CondFactor.setParent(this);
    }

    public CondExpression getCondExpression() {
        return CondExpression;
    }

    public void setCondExpression(CondExpression CondExpression) {
        this.CondExpression=CondExpression;
    }

    public CondFactor getCondFactor() {
        return CondFactor;
    }

    public void setCondFactor(CondFactor CondFactor) {
        this.CondFactor=CondFactor;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(CondExpression!=null) CondExpression.accept(visitor);
        if(CondFactor!=null) CondFactor.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(CondExpression!=null) CondExpression.traverseTopDown(visitor);
        if(CondFactor!=null) CondFactor.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(CondExpression!=null) CondExpression.traverseBottomUp(visitor);
        if(CondFactor!=null) CondFactor.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConditionTermWithAnd(\n");

        if(CondExpression!=null)
            buffer.append(CondExpression.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(CondFactor!=null)
            buffer.append(CondFactor.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConditionTermWithAnd]");
        return buffer.toString();
    }
}
