// generated with ast extension for cup
// version 0.8
// 20/0/2021 15:40:23


package rs.ac.bg.etf.pp1.ast;

public class NonEmptyMethodStatements extends MethodStatements {

    private MethodStatements MethodStatements;
    private Statement Statement;

    public NonEmptyMethodStatements (MethodStatements MethodStatements, Statement Statement) {
        this.MethodStatements=MethodStatements;
        if(MethodStatements!=null) MethodStatements.setParent(this);
        this.Statement=Statement;
        if(Statement!=null) Statement.setParent(this);
    }

    public MethodStatements getMethodStatements() {
        return MethodStatements;
    }

    public void setMethodStatements(MethodStatements MethodStatements) {
        this.MethodStatements=MethodStatements;
    }

    public Statement getStatement() {
        return Statement;
    }

    public void setStatement(Statement Statement) {
        this.Statement=Statement;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(MethodStatements!=null) MethodStatements.accept(visitor);
        if(Statement!=null) Statement.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(MethodStatements!=null) MethodStatements.traverseTopDown(visitor);
        if(Statement!=null) Statement.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(MethodStatements!=null) MethodStatements.traverseBottomUp(visitor);
        if(Statement!=null) Statement.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("NonEmptyMethodStatements(\n");

        if(MethodStatements!=null)
            buffer.append(MethodStatements.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Statement!=null)
            buffer.append(Statement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [NonEmptyMethodStatements]");
        return buffer.toString();
    }
}
