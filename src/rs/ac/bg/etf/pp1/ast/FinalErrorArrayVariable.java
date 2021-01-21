// generated with ast extension for cup
// version 0.8
// 20/0/2021 15:40:23


package rs.ac.bg.etf.pp1.ast;

public class FinalErrorArrayVariable extends ErrorVariables {

    private String F1;
    private String variableName;

    public FinalErrorArrayVariable (String F1, String variableName) {
        this.F1=F1;
        this.variableName=variableName;
    }

    public String getF1() {
        return F1;
    }

    public void setF1(String F1) {
        this.F1=F1;
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
        buffer.append("FinalErrorArrayVariable(\n");

        buffer.append(" "+tab+F1);
        buffer.append("\n");

        buffer.append(" "+tab+variableName);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FinalErrorArrayVariable]");
        return buffer.toString();
    }
}
