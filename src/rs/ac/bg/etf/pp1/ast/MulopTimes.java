// generated with ast extension for cup
// version 0.8
// 4/0/2021 14:13:13


package rs.ac.bg.etf.pp1.ast;

public class MulopTimes extends MulOp {

    public MulopTimes () {
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
        buffer.append("MulopTimes(\n");

        buffer.append(tab);
        buffer.append(") [MulopTimes]");
        return buffer.toString();
    }
}
