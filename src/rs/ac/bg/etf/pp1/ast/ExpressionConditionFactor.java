// generated with ast extension for cup
// version 0.8
// 29/11/2020 14:25:28


package rs.ac.bg.etf.pp1.ast;

public class ExpressionConditionFactor extends CondFactor {

    private ExprNoTern ExprNoTern;
    private RelationalExpression RelationalExpression;

    public ExpressionConditionFactor (ExprNoTern ExprNoTern, RelationalExpression RelationalExpression) {
        this.ExprNoTern=ExprNoTern;
        if(ExprNoTern!=null) ExprNoTern.setParent(this);
        this.RelationalExpression=RelationalExpression;
        if(RelationalExpression!=null) RelationalExpression.setParent(this);
    }

    public ExprNoTern getExprNoTern() {
        return ExprNoTern;
    }

    public void setExprNoTern(ExprNoTern ExprNoTern) {
        this.ExprNoTern=ExprNoTern;
    }

    public RelationalExpression getRelationalExpression() {
        return RelationalExpression;
    }

    public void setRelationalExpression(RelationalExpression RelationalExpression) {
        this.RelationalExpression=RelationalExpression;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ExprNoTern!=null) ExprNoTern.accept(visitor);
        if(RelationalExpression!=null) RelationalExpression.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ExprNoTern!=null) ExprNoTern.traverseTopDown(visitor);
        if(RelationalExpression!=null) RelationalExpression.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ExprNoTern!=null) ExprNoTern.traverseBottomUp(visitor);
        if(RelationalExpression!=null) RelationalExpression.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ExpressionConditionFactor(\n");

        if(ExprNoTern!=null)
            buffer.append(ExprNoTern.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(RelationalExpression!=null)
            buffer.append(RelationalExpression.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ExpressionConditionFactor]");
        return buffer.toString();
    }
}
