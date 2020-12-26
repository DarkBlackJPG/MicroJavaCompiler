// generated with ast extension for cup
// version 0.8
// 26/11/2020 23:7:12


package rs.ac.bg.etf.pp1.ast;

public class Condition implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private CondExpression CondExpression;

    public Condition (CondExpression CondExpression) {
        this.CondExpression=CondExpression;
        if(CondExpression!=null) CondExpression.setParent(this);
    }

    public CondExpression getCondExpression() {
        return CondExpression;
    }

    public void setCondExpression(CondExpression CondExpression) {
        this.CondExpression=CondExpression;
    }

    public SyntaxNode getParent() {
        return parent;
    }

    public void setParent(SyntaxNode parent) {
        this.parent=parent;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line=line;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(CondExpression!=null) CondExpression.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(CondExpression!=null) CondExpression.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(CondExpression!=null) CondExpression.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("Condition(\n");

        if(CondExpression!=null)
            buffer.append(CondExpression.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [Condition]");
        return buffer.toString();
    }
}
