// generated with ast extension for cup
// version 0.8
// 23/11/2020 13:17:15


package rs.ac.bg.etf.pp1.ast;

public class EmptyFormPars extends FormalParameters {

    public EmptyFormPars () {
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
        buffer.append("EmptyFormPars(\n");

        buffer.append(tab);
        buffer.append(") [EmptyFormPars]");
        return buffer.toString();
    }
}