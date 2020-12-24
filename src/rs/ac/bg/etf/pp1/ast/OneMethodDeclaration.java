// generated with ast extension for cup
// version 0.8
// 24/11/2020 20:56:45


package rs.ac.bg.etf.pp1.ast;

public class OneMethodDeclaration extends MethodDeclaration {

    private ReturnType ReturnType;
    private String methodIdentification;
    private FormalParameters FormalParameters;
    private MethodVariables MethodVariables;
    private MethodStatements MethodStatements;

    public OneMethodDeclaration (ReturnType ReturnType, String methodIdentification, FormalParameters FormalParameters, MethodVariables MethodVariables, MethodStatements MethodStatements) {
        this.ReturnType=ReturnType;
        if(ReturnType!=null) ReturnType.setParent(this);
        this.methodIdentification=methodIdentification;
        this.FormalParameters=FormalParameters;
        if(FormalParameters!=null) FormalParameters.setParent(this);
        this.MethodVariables=MethodVariables;
        if(MethodVariables!=null) MethodVariables.setParent(this);
        this.MethodStatements=MethodStatements;
        if(MethodStatements!=null) MethodStatements.setParent(this);
    }

    public ReturnType getReturnType() {
        return ReturnType;
    }

    public void setReturnType(ReturnType ReturnType) {
        this.ReturnType=ReturnType;
    }

    public String getMethodIdentification() {
        return methodIdentification;
    }

    public void setMethodIdentification(String methodIdentification) {
        this.methodIdentification=methodIdentification;
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
        if(ReturnType!=null) ReturnType.accept(visitor);
        if(FormalParameters!=null) FormalParameters.accept(visitor);
        if(MethodVariables!=null) MethodVariables.accept(visitor);
        if(MethodStatements!=null) MethodStatements.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ReturnType!=null) ReturnType.traverseTopDown(visitor);
        if(FormalParameters!=null) FormalParameters.traverseTopDown(visitor);
        if(MethodVariables!=null) MethodVariables.traverseTopDown(visitor);
        if(MethodStatements!=null) MethodStatements.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ReturnType!=null) ReturnType.traverseBottomUp(visitor);
        if(FormalParameters!=null) FormalParameters.traverseBottomUp(visitor);
        if(MethodVariables!=null) MethodVariables.traverseBottomUp(visitor);
        if(MethodStatements!=null) MethodStatements.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("OneMethodDeclaration(\n");

        if(ReturnType!=null)
            buffer.append(ReturnType.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(" "+tab+methodIdentification);
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
