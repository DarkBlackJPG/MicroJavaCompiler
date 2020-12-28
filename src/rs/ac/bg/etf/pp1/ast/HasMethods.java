// generated with ast extension for cup
// version 0.8
// 28/11/2020 15:22:6


package rs.ac.bg.etf.pp1.ast;

public class HasMethods extends ClassMethodList {

    private ClassMethodList ClassMethodList;
    private MethodDeclaration MethodDeclaration;

    public HasMethods (ClassMethodList ClassMethodList, MethodDeclaration MethodDeclaration) {
        this.ClassMethodList=ClassMethodList;
        if(ClassMethodList!=null) ClassMethodList.setParent(this);
        this.MethodDeclaration=MethodDeclaration;
        if(MethodDeclaration!=null) MethodDeclaration.setParent(this);
    }

    public ClassMethodList getClassMethodList() {
        return ClassMethodList;
    }

    public void setClassMethodList(ClassMethodList ClassMethodList) {
        this.ClassMethodList=ClassMethodList;
    }

    public MethodDeclaration getMethodDeclaration() {
        return MethodDeclaration;
    }

    public void setMethodDeclaration(MethodDeclaration MethodDeclaration) {
        this.MethodDeclaration=MethodDeclaration;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ClassMethodList!=null) ClassMethodList.accept(visitor);
        if(MethodDeclaration!=null) MethodDeclaration.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ClassMethodList!=null) ClassMethodList.traverseTopDown(visitor);
        if(MethodDeclaration!=null) MethodDeclaration.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ClassMethodList!=null) ClassMethodList.traverseBottomUp(visitor);
        if(MethodDeclaration!=null) MethodDeclaration.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("HasMethods(\n");

        if(ClassMethodList!=null)
            buffer.append(ClassMethodList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(MethodDeclaration!=null)
            buffer.append(MethodDeclaration.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [HasMethods]");
        return buffer.toString();
    }
}
