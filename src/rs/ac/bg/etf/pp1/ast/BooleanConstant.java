// generated with ast extension for cup
// version 0.8
// 18/0/2021 18:35:13


package rs.ac.bg.etf.pp1.ast;

public class BooleanConstant extends Factor {

    private String boolValue;

    public BooleanConstant (String boolValue) {
        this.boolValue=boolValue;
    }

    public String getBoolValue() {
        return boolValue;
    }

    public void setBoolValue(String boolValue) {
        this.boolValue=boolValue;
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
        buffer.append("BooleanConstant(\n");

        buffer.append(" "+tab+boolValue);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [BooleanConstant]");
        return buffer.toString();
    }
}
