// generated with ast extension for cup
// version 0.8
// 4/0/2021 14:13:13


package rs.ac.bg.etf.pp1.ast;

public class AddOperationTerm extends ExprNoTern {

    private ExprNoTernAddOpList ExprNoTernAddOpList;

    public AddOperationTerm (ExprNoTernAddOpList ExprNoTernAddOpList) {
        this.ExprNoTernAddOpList=ExprNoTernAddOpList;
        if(ExprNoTernAddOpList!=null) ExprNoTernAddOpList.setParent(this);
    }

    public ExprNoTernAddOpList getExprNoTernAddOpList() {
        return ExprNoTernAddOpList;
    }

    public void setExprNoTernAddOpList(ExprNoTernAddOpList ExprNoTernAddOpList) {
        this.ExprNoTernAddOpList=ExprNoTernAddOpList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ExprNoTernAddOpList!=null) ExprNoTernAddOpList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ExprNoTernAddOpList!=null) ExprNoTernAddOpList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ExprNoTernAddOpList!=null) ExprNoTernAddOpList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("AddOperationTerm(\n");

        if(ExprNoTernAddOpList!=null)
            buffer.append(ExprNoTernAddOpList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [AddOperationTerm]");
        return buffer.toString();
    }
}
