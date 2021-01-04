// generated with ast extension for cup
// version 0.8
// 3/0/2021 19:14:3


package rs.ac.bg.etf.pp1.ast;

public class HasMethodVariables extends MethodVariables {

    private MethodVariables MethodVariables;
    private VariableDeclarations VariableDeclarations;

    public HasMethodVariables (MethodVariables MethodVariables, VariableDeclarations VariableDeclarations) {
        this.MethodVariables=MethodVariables;
        if(MethodVariables!=null) MethodVariables.setParent(this);
        this.VariableDeclarations=VariableDeclarations;
        if(VariableDeclarations!=null) VariableDeclarations.setParent(this);
    }

    public MethodVariables getMethodVariables() {
        return MethodVariables;
    }

    public void setMethodVariables(MethodVariables MethodVariables) {
        this.MethodVariables=MethodVariables;
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
        if(MethodVariables!=null) MethodVariables.accept(visitor);
        if(VariableDeclarations!=null) VariableDeclarations.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(MethodVariables!=null) MethodVariables.traverseTopDown(visitor);
        if(VariableDeclarations!=null) VariableDeclarations.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(MethodVariables!=null) MethodVariables.traverseBottomUp(visitor);
        if(VariableDeclarations!=null) VariableDeclarations.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("HasMethodVariables(\n");

        if(MethodVariables!=null)
            buffer.append(MethodVariables.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VariableDeclarations!=null)
            buffer.append(VariableDeclarations.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [HasMethodVariables]");
        return buffer.toString();
    }
}
