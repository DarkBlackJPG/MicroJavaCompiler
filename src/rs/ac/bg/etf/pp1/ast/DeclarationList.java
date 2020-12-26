// generated with ast extension for cup
// version 0.8
// 26/11/2020 20:18:35


package rs.ac.bg.etf.pp1.ast;

public class DeclarationList extends Declarations {

    private Declarations Declarations;
    private Decls Decls;

    public DeclarationList (Declarations Declarations, Decls Decls) {
        this.Declarations=Declarations;
        if(Declarations!=null) Declarations.setParent(this);
        this.Decls=Decls;
        if(Decls!=null) Decls.setParent(this);
    }

    public Declarations getDeclarations() {
        return Declarations;
    }

    public void setDeclarations(Declarations Declarations) {
        this.Declarations=Declarations;
    }

    public Decls getDecls() {
        return Decls;
    }

    public void setDecls(Decls Decls) {
        this.Decls=Decls;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Declarations!=null) Declarations.accept(visitor);
        if(Decls!=null) Decls.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Declarations!=null) Declarations.traverseTopDown(visitor);
        if(Decls!=null) Decls.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Declarations!=null) Declarations.traverseBottomUp(visitor);
        if(Decls!=null) Decls.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DeclarationList(\n");

        if(Declarations!=null)
            buffer.append(Declarations.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Decls!=null)
            buffer.append(Decls.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DeclarationList]");
        return buffer.toString();
    }
}
