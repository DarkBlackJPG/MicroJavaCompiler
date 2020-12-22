// generated with ast extension for cup
// version 0.8
// 22/11/2020 19:29:48


package rs.ac.bg.etf.pp1.ast;

public class CleanDesignatorList extends DesignatorList {

    private String identification;

    public CleanDesignatorList (String identification) {
        this.identification=identification;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification=identification;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("CleanDesignatorList(\n");

        buffer.append(" "+tab+identification);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [CleanDesignatorList]");
        return buffer.toString();
    }
}
