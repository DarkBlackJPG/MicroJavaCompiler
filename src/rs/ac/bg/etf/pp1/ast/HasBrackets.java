// generated with ast extension for cup
// version 0.8
// 11/0/2021 14:23:46


package rs.ac.bg.etf.pp1.ast;

public class HasBrackets extends FormParamsBrackets {

    public HasBrackets () {
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
        buffer.append("HasBrackets(\n");

        buffer.append(tab);
        buffer.append(") [HasBrackets]");
        return buffer.toString();
    }
}
