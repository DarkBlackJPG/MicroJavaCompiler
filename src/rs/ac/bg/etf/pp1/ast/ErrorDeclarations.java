// generated with ast extension for cup
// version 0.8
// 23/11/2020 15:46:59


package rs.ac.bg.etf.pp1.ast;

public class ErrorDeclarations extends Decls {

    private ErrorDecls ErrorDecls;

    public ErrorDeclarations (ErrorDecls ErrorDecls) {
        this.ErrorDecls=ErrorDecls;
        if(ErrorDecls!=null) ErrorDecls.setParent(this);
    }

    public ErrorDecls getErrorDecls() {
        return ErrorDecls;
    }

    public void setErrorDecls(ErrorDecls ErrorDecls) {
        this.ErrorDecls=ErrorDecls;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ErrorDecls!=null) ErrorDecls.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ErrorDecls!=null) ErrorDecls.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ErrorDecls!=null) ErrorDecls.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ErrorDeclarations(\n");

        if(ErrorDecls!=null)
            buffer.append(ErrorDecls.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ErrorDeclarations]");
        return buffer.toString();
    }
}
