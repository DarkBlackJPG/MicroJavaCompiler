// generated with ast extension for cup
// version 0.8
// 25/11/2020 19:46:11


package rs.ac.bg.etf.pp1.ast;

public class AddopPlus extends AddOp {

    public AddopPlus () {
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
        buffer.append("AddopPlus(\n");

        buffer.append(tab);
        buffer.append(") [AddopPlus]");
        return buffer.toString();
    }
}
