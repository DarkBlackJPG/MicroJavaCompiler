// generated with ast extension for cup
// version 0.8
// 11/0/2021 14:23:46


package rs.ac.bg.etf.pp1.ast;

public class NonEmptySwitchCaseList extends SwitchCaseList {

    private SwitchCaseList SwitchCaseList;
    private SwichCaseDefinition SwichCaseDefinition;

    public NonEmptySwitchCaseList (SwitchCaseList SwitchCaseList, SwichCaseDefinition SwichCaseDefinition) {
        this.SwitchCaseList=SwitchCaseList;
        if(SwitchCaseList!=null) SwitchCaseList.setParent(this);
        this.SwichCaseDefinition=SwichCaseDefinition;
        if(SwichCaseDefinition!=null) SwichCaseDefinition.setParent(this);
    }

    public SwitchCaseList getSwitchCaseList() {
        return SwitchCaseList;
    }

    public void setSwitchCaseList(SwitchCaseList SwitchCaseList) {
        this.SwitchCaseList=SwitchCaseList;
    }

    public SwichCaseDefinition getSwichCaseDefinition() {
        return SwichCaseDefinition;
    }

    public void setSwichCaseDefinition(SwichCaseDefinition SwichCaseDefinition) {
        this.SwichCaseDefinition=SwichCaseDefinition;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(SwitchCaseList!=null) SwitchCaseList.accept(visitor);
        if(SwichCaseDefinition!=null) SwichCaseDefinition.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(SwitchCaseList!=null) SwitchCaseList.traverseTopDown(visitor);
        if(SwichCaseDefinition!=null) SwichCaseDefinition.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(SwitchCaseList!=null) SwitchCaseList.traverseBottomUp(visitor);
        if(SwichCaseDefinition!=null) SwichCaseDefinition.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("NonEmptySwitchCaseList(\n");

        if(SwitchCaseList!=null)
            buffer.append(SwitchCaseList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(SwichCaseDefinition!=null)
            buffer.append(SwichCaseDefinition.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [NonEmptySwitchCaseList]");
        return buffer.toString();
    }
}
