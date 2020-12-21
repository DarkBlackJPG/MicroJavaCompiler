// generated with ast extension for cup
// version 0.8
// 21/11/2020 22:57:44


package rs.ac.bg.etf.pp1.ast;

public class NonEmptySwitchCaseList extends SwitchCaseList {

    private Integer numberValue;
    private CaseStatementList CaseStatementList;

    public NonEmptySwitchCaseList (Integer numberValue, CaseStatementList CaseStatementList) {
        this.numberValue=numberValue;
        this.CaseStatementList=CaseStatementList;
        if(CaseStatementList!=null) CaseStatementList.setParent(this);
    }

    public Integer getNumberValue() {
        return numberValue;
    }

    public void setNumberValue(Integer numberValue) {
        this.numberValue=numberValue;
    }

    public CaseStatementList getCaseStatementList() {
        return CaseStatementList;
    }

    public void setCaseStatementList(CaseStatementList CaseStatementList) {
        this.CaseStatementList=CaseStatementList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(CaseStatementList!=null) CaseStatementList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(CaseStatementList!=null) CaseStatementList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(CaseStatementList!=null) CaseStatementList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("NonEmptySwitchCaseList(\n");

        buffer.append(" "+tab+numberValue);
        buffer.append("\n");

        if(CaseStatementList!=null)
            buffer.append(CaseStatementList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [NonEmptySwitchCaseList]");
        return buffer.toString();
    }
}
