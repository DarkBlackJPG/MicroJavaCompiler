// generated with ast extension for cup
// version 0.8
// 20/0/2021 15:40:23


package rs.ac.bg.etf.pp1.ast;

public class ConstantDeclerations extends Decls {

    private ConstDecls ConstDecls;

    public ConstantDeclerations (ConstDecls ConstDecls) {
        this.ConstDecls=ConstDecls;
        if(ConstDecls!=null) ConstDecls.setParent(this);
    }

    public ConstDecls getConstDecls() {
        return ConstDecls;
    }

    public void setConstDecls(ConstDecls ConstDecls) {
        this.ConstDecls=ConstDecls;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ConstDecls!=null) ConstDecls.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ConstDecls!=null) ConstDecls.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ConstDecls!=null) ConstDecls.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConstantDeclerations(\n");

        if(ConstDecls!=null)
            buffer.append(ConstDecls.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstantDeclerations]");
        return buffer.toString();
    }
}
