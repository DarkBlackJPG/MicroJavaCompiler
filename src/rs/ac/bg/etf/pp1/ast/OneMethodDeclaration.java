// generated with ast extension for cup
// version 0.8
// 29/11/2020 14:25:28


package rs.ac.bg.etf.pp1.ast;

public class OneMethodDeclaration extends MethodDeclaration {

    private MethodTypeName MethodTypeName;
    private FormalParameters FormalParameters;
    private MethodVariables MethodVariables;
    private MethodStatements MethodStatements;

    public OneMethodDeclaration (MethodTypeName MethodTypeName, FormalParameters FormalParameters, MethodVariables MethodVariables, MethodStatements MethodStatements) {
        this.MethodTypeName=MethodTypeName;
        if(MethodTypeName!=null) MethodTypeName.setParent(this);
        this.FormalParameters=FormalParameters;
        if(FormalParameters!=null) FormalParameters.setParent(this);
        this.MethodVariables=MethodVariables;
        if(MethodVariables!=null) MethodVariables.setParent(this);
        this.MethodStatements=MethodStatements;
        if(MethodStatements!=null) MethodStatements.setParent(this);
    }

    public MethodTypeName getMethodTypeName() {
        return MethodTypeName;
    }

    public void setMethodTypeName(MethodTypeName MethodTypeName) {
        this.MethodTypeName=MethodTypeName;
    }

    public FormalParameters getFormalParameters() {
        return FormalParameters;
    }

    public void setFormalParameters(FormalParameters FormalParameters) {
        this.FormalParameters=FormalParameters;
    }

    public MethodVariables getMethodVariables() {
        return MethodVariables;
    }

    public void setMethodVariables(MethodVariables MethodVariables) {
        this.MethodVariables=MethodVariables;
    }

    public MethodStatements getMethodStatements() {
        return MethodStatements;
    }

    public void setMethodStatements(MethodStatements MethodStatements) {
        this.MethodStatements=MethodStatements;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(MethodTypeName!=null) MethodTypeName.accept(visitor);
        if(FormalParameters!=null) FormalParameters.accept(visitor);
        if(MethodVariables!=null) MethodVariables.accept(visitor);
        if(MethodStatements!=null) MethodStatements.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(MethodTypeName!=null) MethodTypeName.traverseTopDown(visitor);
        if(FormalParameters!=null) FormalParameters.traverseTopDown(visitor);
        if(MethodVariables!=null) MethodVariables.traverseTopDown(visitor);
        if(MethodStatements!=null) MethodStatements.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(MethodTypeName!=null) MethodTypeName.traverseBottomUp(visitor);
        if(FormalParameters!=null) FormalParameters.traverseBottomUp(visitor);
        if(MethodVariables!=null) MethodVariables.traverseBottomUp(visitor);
        if(MethodStatements!=null) MethodStatements.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("OneMethodDeclaration(\n");

        if(MethodTypeName!=null)
            buffer.append(MethodTypeName.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(FormalParameters!=null)
            buffer.append(FormalParameters.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(MethodVariables!=null)
            buffer.append(MethodVariables.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(MethodStatements!=null)
            buffer.append(MethodStatements.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [OneMethodDeclaration]");
        return buffer.toString();
    }
}
