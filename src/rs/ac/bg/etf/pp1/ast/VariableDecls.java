// generated with ast extension for cup
// version 0.8
// 3/11/2020 22:59:1


package rs.ac.bg.etf.pp1.ast;

public class VariableDecls extends VariableDeclarations {

    private Type Type;
    private VariableList VariableList;

    public VariableDecls (Type Type, VariableList VariableList) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.VariableList=VariableList;
        if(VariableList!=null) VariableList.setParent(this);
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
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
        if(Type!=null) Type.accept(visitor);
        if(VariableList!=null) VariableList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(VariableList!=null) VariableList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(VariableList!=null) VariableList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VariableDecls(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VariableList!=null)
            buffer.append(VariableList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VariableDecls]");
        return buffer.toString();
    }
}
