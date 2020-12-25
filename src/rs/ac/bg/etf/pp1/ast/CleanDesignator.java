// generated with ast extension for cup
// version 0.8
// 25/11/2020 19:46:11


package rs.ac.bg.etf.pp1.ast;

public class CleanDesignator extends Designator {

    private String identification;
    private DesignatorList DesignatorList;

    public CleanDesignator (String identification, DesignatorList DesignatorList) {
        this.identification=identification;
        this.DesignatorList=DesignatorList;
        if(DesignatorList!=null) DesignatorList.setParent(this);
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification=identification;
    }

    public DesignatorList getDesignatorList() {
        return DesignatorList;
    }

    public void setDesignatorList(DesignatorList DesignatorList) {
        this.DesignatorList=DesignatorList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DesignatorList!=null) DesignatorList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesignatorList!=null) DesignatorList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesignatorList!=null) DesignatorList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("CleanDesignator(\n");

        buffer.append(" "+tab+identification);
        buffer.append("\n");

        if(DesignatorList!=null)
            buffer.append(DesignatorList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [CleanDesignator]");
        return buffer.toString();
    }
}
