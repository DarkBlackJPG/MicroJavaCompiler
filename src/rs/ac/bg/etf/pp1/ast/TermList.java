// generated with ast extension for cup
// version 0.8
// 11/0/2021 9:48:24


package rs.ac.bg.etf.pp1.ast;

public class TermList extends ExprNoTernAddOpList {

    private ExprNoTernAddOpList ExprNoTernAddOpList;
    private AddOp AddOp;
    private Term Term;

    public TermList (ExprNoTernAddOpList ExprNoTernAddOpList, AddOp AddOp, Term Term) {
        this.ExprNoTernAddOpList=ExprNoTernAddOpList;
        if(ExprNoTernAddOpList!=null) ExprNoTernAddOpList.setParent(this);
        this.AddOp=AddOp;
        if(AddOp!=null) AddOp.setParent(this);
        this.Term=Term;
        if(Term!=null) Term.setParent(this);
    }

    public ExprNoTernAddOpList getExprNoTernAddOpList() {
        return ExprNoTernAddOpList;
    }

    public void setExprNoTernAddOpList(ExprNoTernAddOpList ExprNoTernAddOpList) {
        this.ExprNoTernAddOpList=ExprNoTernAddOpList;
    }

    public AddOp getAddOp() {
        return AddOp;
    }

    public void setAddOp(AddOp AddOp) {
        this.AddOp=AddOp;
    }

    public Term getTerm() {
        return Term;
    }

    public void setTerm(Term Term) {
        this.Term=Term;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ExprNoTernAddOpList!=null) ExprNoTernAddOpList.accept(visitor);
        if(AddOp!=null) AddOp.accept(visitor);
        if(Term!=null) Term.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ExprNoTernAddOpList!=null) ExprNoTernAddOpList.traverseTopDown(visitor);
        if(AddOp!=null) AddOp.traverseTopDown(visitor);
        if(Term!=null) Term.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ExprNoTernAddOpList!=null) ExprNoTernAddOpList.traverseBottomUp(visitor);
        if(AddOp!=null) AddOp.traverseBottomUp(visitor);
        if(Term!=null) Term.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("TermList(\n");

        if(ExprNoTernAddOpList!=null)
            buffer.append(ExprNoTernAddOpList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(AddOp!=null)
            buffer.append(AddOp.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Term!=null)
            buffer.append(Term.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [TermList]");
        return buffer.toString();
    }
}
