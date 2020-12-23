// generated with ast extension for cup
// version 0.8
// 23/11/2020 15:46:59


package rs.ac.bg.etf.pp1.ast;

public class ReturnStmt extends Statement {

    private ReturnStmts ReturnStmts;

    public ReturnStmt (ReturnStmts ReturnStmts) {
        this.ReturnStmts=ReturnStmts;
        if(ReturnStmts!=null) ReturnStmts.setParent(this);
    }

    public ReturnStmts getReturnStmts() {
        return ReturnStmts;
    }

    public void setReturnStmts(ReturnStmts ReturnStmts) {
        this.ReturnStmts=ReturnStmts;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ReturnStmts!=null) ReturnStmts.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ReturnStmts!=null) ReturnStmts.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ReturnStmts!=null) ReturnStmts.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ReturnStmt(\n");

        if(ReturnStmts!=null)
            buffer.append(ReturnStmts.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ReturnStmt]");
        return buffer.toString();
    }
}
