// generated with ast extension for cup
// version 0.8
// 26/11/2020 23:7:12


package rs.ac.bg.etf.pp1.ast;

public class ErrorVariableDeclarationsDerived1 extends ErrorVariableDeclarations {

    public ErrorVariableDeclarationsDerived1 () {
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
        buffer.append("ErrorVariableDeclarationsDerived1(\n");

        buffer.append(tab);
        buffer.append(") [ErrorVariableDeclarationsDerived1]");
        return buffer.toString();
    }
}