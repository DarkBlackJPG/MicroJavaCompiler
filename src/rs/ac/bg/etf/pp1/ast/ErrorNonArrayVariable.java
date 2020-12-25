// generated with ast extension for cup
// version 0.8
// 25/11/2020 19:46:11


package rs.ac.bg.etf.pp1.ast;

public class ErrorNonArrayVariable extends ErrorVariables {

    private String variableName;

    public ErrorNonArrayVariable (String variableName) {
        this.variableName=variableName;
    }

    public String getVariableName() {
        return variableName;
    }

    public void setVariableName(String variableName) {
        this.variableName=variableName;
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
        buffer.append("ErrorNonArrayVariable(\n");

        buffer.append(" "+tab+variableName);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ErrorNonArrayVariable]");
        return buffer.toString();
    }
}
