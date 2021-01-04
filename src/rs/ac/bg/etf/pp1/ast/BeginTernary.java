// generated with ast extension for cup
// version 0.8
// 3/0/2021 19:14:3


package rs.ac.bg.etf.pp1.ast;

public class BeginTernary implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private CondFactor CondFactor;

    public BeginTernary (CondFactor CondFactor) {
        this.CondFactor=CondFactor;
        if(CondFactor!=null) CondFactor.setParent(this);
    }

    public CondFactor getCondFactor() {
        return CondFactor;
    }

    public void setCondFactor(CondFactor CondFactor) {
        this.CondFactor=CondFactor;
    }

    public SyntaxNode getParent() {
        return parent;
    }

    public void setParent(SyntaxNode parent) {
        this.parent=parent;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line=line;
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
        buffer.append("BeginTernary(\n");

        if(CondFactor!=null)
            buffer.append(CondFactor.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [BeginTernary]");
        return buffer.toString();
    }
}
