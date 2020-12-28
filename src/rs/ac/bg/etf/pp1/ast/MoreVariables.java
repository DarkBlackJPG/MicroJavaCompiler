// generated with ast extension for cup
// version 0.8
// 28/11/2020 15:22:6


package rs.ac.bg.etf.pp1.ast;

public class MoreVariables extends VariableList {

    private ErrorVariables ErrorVariables;
    private VariableList VariableList;

    public MoreVariables (ErrorVariables ErrorVariables, VariableList VariableList) {
        this.ErrorVariables=ErrorVariables;
        if(ErrorVariables!=null) ErrorVariables.setParent(this);
        this.VariableList=VariableList;
        if(VariableList!=null) VariableList.setParent(this);
    }

    public ErrorVariables getErrorVariables() {
        return ErrorVariables;
    }

    public void setErrorVariables(ErrorVariables ErrorVariables) {
        this.ErrorVariables=ErrorVariables;
    }

    public VariableList getVariableList() {
        return VariableList;
    }

    public void setVariableList(VariableList VariableList) {
        this.VariableList=VariableList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ErrorVariables!=null) ErrorVariables.accept(visitor);
        if(VariableList!=null) VariableList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ErrorVariables!=null) ErrorVariables.traverseTopDown(visitor);
        if(VariableList!=null) VariableList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ErrorVariables!=null) ErrorVariables.traverseBottomUp(visitor);
        if(VariableList!=null) VariableList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MoreVariables(\n");

        if(ErrorVariables!=null)
            buffer.append(ErrorVariables.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VariableList!=null)
            buffer.append(VariableList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MoreVariables]");
        return buffer.toString();
    }
}
