// generated with ast extension for cup
// version 0.8
// 11/0/2021 9:48:24


package rs.ac.bg.etf.pp1.ast;

public class ErrorConstDecls extends ConstDecls {

    public ErrorConstDecls () {
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
        buffer.append("ErrorConstDecls(\n");

        buffer.append(tab);
        buffer.append(") [ErrorConstDecls]");
        return buffer.toString();
    }
}