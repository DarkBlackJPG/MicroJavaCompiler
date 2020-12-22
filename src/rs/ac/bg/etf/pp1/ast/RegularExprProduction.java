// generated with ast extension for cup
// version 0.8
// 22/11/2020 1:40:0


package rs.ac.bg.etf.pp1.ast;

public class RegularExprProduction extends Expr {

    private RegularExpr RegularExpr;

    public RegularExprProduction (RegularExpr RegularExpr) {
        this.RegularExpr=RegularExpr;
        if(RegularExpr!=null) RegularExpr.setParent(this);
    }

    public RegularExpr getRegularExpr() {
        return RegularExpr;
    }

    public void setRegularExpr(RegularExpr RegularExpr) {
        this.RegularExpr=RegularExpr;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(RegularExpr!=null) RegularExpr.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(RegularExpr!=null) RegularExpr.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(RegularExpr!=null) RegularExpr.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("RegularExprProduction(\n");

        if(RegularExpr!=null)
            buffer.append(RegularExpr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [RegularExprProduction]");
        return buffer.toString();
    }
}
