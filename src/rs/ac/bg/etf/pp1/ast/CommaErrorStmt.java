// generated with ast extension for cup
// version 0.8
// 18/0/2021 18:35:13


package rs.ac.bg.etf.pp1.ast;

public class CommaErrorStmt extends ErrorVariables {

    public CommaErrorStmt () {
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
        buffer.append("CommaErrorStmt(\n");

        buffer.append(tab);
        buffer.append(") [CommaErrorStmt]");
        return buffer.toString();
    }
}
