// generated with ast extension for cup
// version 0.8
// 26/11/2020 20:18:35


package rs.ac.bg.etf.pp1.ast;

public class NonArrayVariable extends VariableDeclaration {

    private String variableName;

    public NonArrayVariable (String variableName) {
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
        buffer.append("NonArrayVariable(\n");

        buffer.append(" "+tab+variableName);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [NonArrayVariable]");
        return buffer.toString();
    }
}
