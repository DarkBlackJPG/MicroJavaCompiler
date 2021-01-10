// generated with ast extension for cup
// version 0.8
// 10/0/2021 23:47:14


package rs.ac.bg.etf.pp1.ast;

public class NonEmptyCaseStatementList extends CaseStatementList {

    private CaseStatementList CaseStatementList;
    private Statement Statement;

    public NonEmptyCaseStatementList (CaseStatementList CaseStatementList, Statement Statement) {
        this.CaseStatementList=CaseStatementList;
        if(CaseStatementList!=null) CaseStatementList.setParent(this);
        this.Statement=Statement;
        if(Statement!=null) Statement.setParent(this);
    }

    public CaseStatementList getCaseStatementList() {
        return CaseStatementList;
    }

    public void setCaseStatementList(CaseStatementList CaseStatementList) {
        this.CaseStatementList=CaseStatementList;
    }

    public Statement getStatement() {
        return Statement;
    }

    public void setStatement(Statement Statement) {
        this.Statement=Statement;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(CaseStatementList!=null) CaseStatementList.accept(visitor);
        if(Statement!=null) Statement.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(CaseStatementList!=null) CaseStatementList.traverseTopDown(visitor);
        if(Statement!=null) Statement.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(CaseStatementList!=null) CaseStatementList.traverseBottomUp(visitor);
        if(Statement!=null) Statement.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("NonEmptyCaseStatementList(\n");

        if(CaseStatementList!=null)
            buffer.append(CaseStatementList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Statement!=null)
            buffer.append(Statement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [NonEmptyCaseStatementList]");
        return buffer.toString();
    }
}
