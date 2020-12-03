// generated with ast extension for cup
// version 0.8
// 3/11/2020 22:59:1


package rs.ac.bg.etf.pp1.ast;

public class VarDeclarations extends Decls {

    private VariableDeclarations VariableDeclarations;

    public VarDeclarations (VariableDeclarations VariableDeclarations) {
        this.VariableDeclarations=VariableDeclarations;
        if(VariableDeclarations!=null) VariableDeclarations.setParent(this);
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
        if(VariableDeclarations!=null) VariableDeclarations.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(VariableDeclarations!=null) VariableDeclarations.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(VariableDeclarations!=null) VariableDeclarations.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VarDeclarations(\n");

        if(VariableDeclarations!=null)
            buffer.append(VariableDeclarations.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VarDeclarations]");
        return buffer.toString();
    }
}
