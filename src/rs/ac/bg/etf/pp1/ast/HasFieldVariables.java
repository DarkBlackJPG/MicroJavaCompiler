// generated with ast extension for cup
// version 0.8
// 10/0/2021 23:47:14


package rs.ac.bg.etf.pp1.ast;

public class HasFieldVariables extends FieldList {

    private FieldList FieldList;
    private VariableDeclarations VariableDeclarations;

    public HasFieldVariables (FieldList FieldList, VariableDeclarations VariableDeclarations) {
        this.FieldList=FieldList;
        if(FieldList!=null) FieldList.setParent(this);
        this.VariableDeclarations=VariableDeclarations;
        if(VariableDeclarations!=null) VariableDeclarations.setParent(this);
    }

    public FieldList getFieldList() {
        return FieldList;
    }

    public void setFieldList(FieldList FieldList) {
        this.FieldList=FieldList;
    }

    public VariableDeclarations getVariableDeclarations() {
        return VariableDeclarations;
    }

    public void setVariableDeclarations(VariableDeclarations VariableDeclarations) {
        this.VariableDeclarations=VariableDeclarations;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(FieldList!=null) FieldList.accept(visitor);
        if(VariableDeclarations!=null) VariableDeclarations.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(FieldList!=null) FieldList.traverseTopDown(visitor);
        if(VariableDeclarations!=null) VariableDeclarations.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(FieldList!=null) FieldList.traverseBottomUp(visitor);
        if(VariableDeclarations!=null) VariableDeclarations.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("HasFieldVariables(\n");

        if(FieldList!=null)
            buffer.append(FieldList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VariableDeclarations!=null)
            buffer.append(VariableDeclarations.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [HasFieldVariables]");
        return buffer.toString();
    }
}
