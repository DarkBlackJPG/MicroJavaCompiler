// generated with ast extension for cup
// version 0.8
// 21/11/2020 21:18:6


package rs.ac.bg.etf.pp1.ast;

public class BooleanConstant extends Factor {

    private Integer boolValue;

    public BooleanConstant (Integer boolValue) {
        this.boolValue=boolValue;
    }

    public Integer getBoolValue() {
        return boolValue;
    }

    public void setBoolValue(Integer boolValue) {
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
