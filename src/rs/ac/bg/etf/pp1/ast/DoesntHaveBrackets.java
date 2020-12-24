// generated with ast extension for cup
// version 0.8
// 24/11/2020 20:56:45


package rs.ac.bg.etf.pp1.ast;

public class DoesntHaveBrackets extends FormParamsBrackets {

    public DoesntHaveBrackets () {
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
        buffer.append("DoesntHaveBrackets(\n");

        buffer.append(tab);
        buffer.append(") [DoesntHaveBrackets]");
        return buffer.toString();
    }
}
