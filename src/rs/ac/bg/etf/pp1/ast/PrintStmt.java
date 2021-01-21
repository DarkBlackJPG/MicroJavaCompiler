// generated with ast extension for cup
// version 0.8
// 20/0/2021 15:40:23


package rs.ac.bg.etf.pp1.ast;

public class PrintStmt extends Statement {

    private PrintStmtList PrintStmtList;

    public PrintStmt (PrintStmtList PrintStmtList) {
        this.PrintStmtList=PrintStmtList;
        if(PrintStmtList!=null) PrintStmtList.setParent(this);
    }

    public PrintStmtList getPrintStmtList() {
        return PrintStmtList;
    }

    public void setPrintStmtList(PrintStmtList PrintStmtList) {
        this.PrintStmtList=PrintStmtList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(PrintStmtList!=null) PrintStmtList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(PrintStmtList!=null) PrintStmtList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(PrintStmtList!=null) PrintStmtList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("PrintStmt(\n");

        if(PrintStmtList!=null)
            buffer.append(PrintStmtList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [PrintStmt]");
        return buffer.toString();
    }
}
