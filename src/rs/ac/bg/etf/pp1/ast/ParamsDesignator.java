// generated with ast extension for cup
// version 0.8
// 26/11/2020 1:30:52


package rs.ac.bg.etf.pp1.ast;

public class ParamsDesignator extends Factor {

    private Designator Designator;
    private ActParsChoice ActParsChoice;

    public ParamsDesignator (Designator Designator, ActParsChoice ActParsChoice) {
        this.Designator=Designator;
        if(Designator!=null) Designator.setParent(this);
        this.ActParsChoice=ActParsChoice;
        if(ActParsChoice!=null) ActParsChoice.setParent(this);
    }

    public Designator getDesignator() {
        return Designator;
    }

    public void setDesignator(Designator Designator) {
        this.Designator=Designator;
    }

    public ActParsChoice getActParsChoice() {
        return ActParsChoice;
    }

    public void setActParsChoice(ActParsChoice ActParsChoice) {
        this.ActParsChoice=ActParsChoice;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Designator!=null) Designator.accept(visitor);
        if(ActParsChoice!=null) ActParsChoice.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Designator!=null) Designator.traverseTopDown(visitor);
        if(ActParsChoice!=null) ActParsChoice.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Designator!=null) Designator.traverseBottomUp(visitor);
        if(ActParsChoice!=null) ActParsChoice.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ParamsDesignator(\n");

        if(Designator!=null)
            buffer.append(Designator.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ActParsChoice!=null)
            buffer.append(ActParsChoice.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ParamsDesignator]");
        return buffer.toString();
    }
}
