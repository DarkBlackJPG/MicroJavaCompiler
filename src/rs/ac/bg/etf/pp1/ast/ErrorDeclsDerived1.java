// generated with ast extension for cup
// version 0.8
// 23/11/2020 15:46:59


package rs.ac.bg.etf.pp1.ast;

public class ErrorDeclsDerived1 extends ErrorDecls {

    public ErrorDeclsDerived1 () {
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
        buffer.append("ErrorDeclsDerived1(\n");

        buffer.append(tab);
        buffer.append(") [ErrorDeclsDerived1]");
        return buffer.toString();
    }
}