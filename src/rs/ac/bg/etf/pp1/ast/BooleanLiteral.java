// generated with ast extension for cup
// version 0.8
// 20/0/2021 15:40:23


package rs.ac.bg.etf.pp1.ast;

public class BooleanLiteral extends Literals {

    private String booleanValue;

    public BooleanLiteral (String booleanValue) {
        this.booleanValue=booleanValue;
    }

    public String getBooleanValue() {
        return booleanValue;
    }

    public void setBooleanValue(String booleanValue) {
        this.booleanValue=booleanValue;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("BooleanLiteral(\n");

        buffer.append(" "+tab+booleanValue);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [BooleanLiteral]");
        return buffer.toString();
    }
}
