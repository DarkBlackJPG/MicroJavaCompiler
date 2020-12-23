// generated with ast extension for cup
// version 0.8
// 23/11/2020 15:46:59


package rs.ac.bg.etf.pp1.ast;

public class ErrorConstListDecl extends ConstList {

    private ErrorConstList ErrorConstList;

    public ErrorConstListDecl (ErrorConstList ErrorConstList) {
        this.ErrorConstList=ErrorConstList;
        if(ErrorConstList!=null) ErrorConstList.setParent(this);
    }

    public ErrorConstList getErrorConstList() {
        return ErrorConstList;
    }

    public void setErrorConstList(ErrorConstList ErrorConstList) {
        this.ErrorConstList=ErrorConstList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ErrorConstList!=null) ErrorConstList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ErrorConstList!=null) ErrorConstList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ErrorConstList!=null) ErrorConstList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ErrorConstListDecl(\n");

        if(ErrorConstList!=null)
            buffer.append(ErrorConstList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ErrorConstListDecl]");
        return buffer.toString();
    }
}
