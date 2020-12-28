// generated with ast extension for cup
// version 0.8
// 28/11/2020 22:35:21


package rs.ac.bg.etf.pp1.ast;

public class ConstDefinition extends Const {

    private String identification;
    private AssignOp AssignOp;
    private Literals Literals;

    public ConstDefinition (String identification, AssignOp AssignOp, Literals Literals) {
        this.identification=identification;
        this.AssignOp=AssignOp;
        if(AssignOp!=null) AssignOp.setParent(this);
        this.Literals=Literals;
        if(Literals!=null) Literals.setParent(this);
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification=identification;
    }

    public AssignOp getAssignOp() {
        return AssignOp;
    }

    public void setAssignOp(AssignOp AssignOp) {
        this.AssignOp=AssignOp;
    }

    public Literals getLiterals() {
        return Literals;
    }

    public void setLiterals(Literals Literals) {
        this.Literals=Literals;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(AssignOp!=null) AssignOp.accept(visitor);
        if(Literals!=null) Literals.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(AssignOp!=null) AssignOp.traverseTopDown(visitor);
        if(Literals!=null) Literals.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(AssignOp!=null) AssignOp.traverseBottomUp(visitor);
        if(Literals!=null) Literals.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConstDefinition(\n");

        buffer.append(" "+tab+identification);
        buffer.append("\n");

        if(AssignOp!=null)
            buffer.append(AssignOp.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Literals!=null)
            buffer.append(Literals.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstDefinition]");
        return buffer.toString();
    }
}
