// generated with ast extension for cup
// version 0.8
// 25/11/2020 19:46:11


package rs.ac.bg.etf.pp1.ast;

public class SingleSwitchCaseDefinition extends SwichCaseDefinition {

    private Integer numberValue;
    private CaseStatementList CaseStatementList;

    public SingleSwitchCaseDefinition (Integer numberValue, CaseStatementList CaseStatementList) {
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
        buffer.append("SingleSwitchCaseDefinition(\n");

        buffer.append(" "+tab+numberValue);
        buffer.append("\n");

        if(CaseStatementList!=null)
            buffer.append(CaseStatementList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [SingleSwitchCaseDefinition]");
        return buffer.toString();
    }
}
