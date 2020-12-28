// generated with ast extension for cup
// version 0.8
// 28/11/2020 22:35:21


package rs.ac.bg.etf.pp1.ast;

public class ConditionTermFactor extends CondTerm {

    private CondFactor CondFactor;

    public ConditionTermFactor (CondFactor CondFactor) {
        this.CondFactor=CondFactor;
        if(CondFactor!=null) CondFactor.setParent(this);
    }

    public CondFactor getCondFactor() {
        return CondFactor;
    }

    public void setCondFactor(CondFactor CondFactor) {
        this.CondFactor=CondFactor;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(CondFactor!=null) CondFactor.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(CondFactor!=null) CondFactor.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(CondFactor!=null) CondFactor.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConditionTermFactor(\n");

        if(CondFactor!=null)
            buffer.append(CondFactor.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConditionTermFactor]");
        return buffer.toString();
    }
}
