// generated with ast extension for cup
// version 0.8
// 22/11/2020 19:29:48


package rs.ac.bg.etf.pp1.ast;

public class ExpressionConditionFactor extends CondFactor {

    private Expr Expr;
    private RelationalExpression RelationalExpression;

    public ExpressionConditionFactor (Expr Expr, RelationalExpression RelationalExpression) {
        this.Expr=Expr;
        if(Expr!=null) Expr.setParent(this);
        this.RelationalExpression=RelationalExpression;
        if(RelationalExpression!=null) RelationalExpression.setParent(this);
    }

    public Expr getExpr() {
        return Expr;
    }

    public void setExpr(Expr Expr) {
        this.Expr=Expr;
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
        if(Expr!=null) Expr.accept(visitor);
        if(RelationalExpression!=null) RelationalExpression.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Expr!=null) Expr.traverseTopDown(visitor);
        if(RelationalExpression!=null) RelationalExpression.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Expr!=null) Expr.traverseBottomUp(visitor);
        if(RelationalExpression!=null) RelationalExpression.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ExpressionConditionFactor(\n");

        if(Expr!=null)
            buffer.append(Expr.toString("  "+tab));
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
