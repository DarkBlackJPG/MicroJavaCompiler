// generated with ast extension for cup
// version 0.8
// 21/11/2020 22:57:44


package rs.ac.bg.etf.pp1.ast;

public class MoreVariables extends VariableList {

    private VariableList VariableList;
    private VariableDeclaration VariableDeclaration;

    public MoreVariables (VariableList VariableList, VariableDeclaration VariableDeclaration) {
        this.VariableList=VariableList;
        if(VariableList!=null) VariableList.setParent(this);
        this.VariableDeclaration=VariableDeclaration;
        if(VariableDeclaration!=null) VariableDeclaration.setParent(this);
    }

    public VariableList getVariableList() {
        return VariableList;
    }

    public void setVariableList(VariableList VariableList) {
        this.VariableList=VariableList;
    }

    public VariableDeclaration getVariableDeclaration() {
        return VariableDeclaration;
    }

    public void setVariableDeclaration(VariableDeclaration VariableDeclaration) {
        this.VariableDeclaration=VariableDeclaration;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(VariableList!=null) VariableList.accept(visitor);
        if(VariableDeclaration!=null) VariableDeclaration.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(VariableList!=null) VariableList.traverseTopDown(visitor);
        if(VariableDeclaration!=null) VariableDeclaration.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(VariableList!=null) VariableList.traverseBottomUp(visitor);
        if(VariableDeclaration!=null) VariableDeclaration.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MoreVariables(\n");

        if(VariableList!=null)
            buffer.append(VariableList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VariableDeclaration!=null)
            buffer.append(VariableDeclaration.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MoreVariables]");
        return buffer.toString();
    }
}
