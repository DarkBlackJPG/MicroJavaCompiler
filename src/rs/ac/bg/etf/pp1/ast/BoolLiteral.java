// generated with ast extension for cup
// version 0.8
// 3/11/2020 22:59:1


package rs.ac.bg.etf.pp1.ast;

public class BoolLiteral extends Literals {

    private Boolean boolValue;

    public BoolLiteral (Boolean boolValue) {
        this.boolValue=boolValue;
        if(boolValue!=null) boolValue.setParent(this);
    }

    public Boolean getBoolValue() {
        return boolValue;
    }

    public void setBoolValue(Boolean boolValue) {
        this.boolValue=boolValue;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(boolValue!=null) boolValue.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(boolValue!=null) boolValue.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(boolValue!=null) boolValue.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("BoolLiteral(\n");

        if(boolValue!=null)
            buffer.append(boolValue.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [BoolLiteral]");
        return buffer.toString();
    }
}
