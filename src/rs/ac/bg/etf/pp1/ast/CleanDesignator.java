// generated with ast extension for cup
// version 0.8
// 20/0/2021 15:40:23


package rs.ac.bg.etf.pp1.ast;

public class CleanDesignator extends Designator {

    private String identification;

    public CleanDesignator (String identification) {
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
        buffer.append("CleanDesignator(\n");

        buffer.append(" "+tab+identification);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [CleanDesignator]");
        return buffer.toString();
    }
}
