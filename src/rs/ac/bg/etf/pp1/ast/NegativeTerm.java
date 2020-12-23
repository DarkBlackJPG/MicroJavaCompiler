// generated with ast extension for cup
// version 0.8
// 23/11/2020 13:17:15


package rs.ac.bg.etf.pp1.ast;

public class NegativeTerm extends ExprNoTern {

    private ExprNoTernAddOpList ExprNoTernAddOpList;

    public NegativeTerm (ExprNoTernAddOpList ExprNoTernAddOpList) {
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
        buffer.append("NegativeTerm(\n");

        if(ExprNoTernAddOpList!=null)
            buffer.append(ExprNoTernAddOpList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [NegativeTerm]");
        return buffer.toString();
    }
}
