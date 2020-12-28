// generated with ast extension for cup
// version 0.8
// 28/11/2020 15:22:6


package rs.ac.bg.etf.pp1.ast;

public class FormParsDefinitionList extends FormPars {

    private FormPars FormPars;
    private Type Type;
    private String paramName;
    private FormParamsBrackets FormParamsBrackets;

    public FormParsDefinitionList (FormPars FormPars, Type Type, String paramName, FormParamsBrackets FormParamsBrackets) {
        this.FormPars=FormPars;
        if(FormPars!=null) FormPars.setParent(this);
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.paramName=paramName;
        this.FormParamsBrackets=FormParamsBrackets;
        if(FormParamsBrackets!=null) FormParamsBrackets.setParent(this);
    }

    public FormPars getFormPars() {
        return FormPars;
    }

    public void setFormPars(FormPars FormPars) {
        this.FormPars=FormPars;
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
    }

    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName=paramName;
    }

    public FormParamsBrackets getFormParamsBrackets() {
        return FormParamsBrackets;
    }

    public void setFormParamsBrackets(FormParamsBrackets FormParamsBrackets) {
        this.FormParamsBrackets=FormParamsBrackets;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(FormPars!=null) FormPars.accept(visitor);
        if(Type!=null) Type.accept(visitor);
        if(FormParamsBrackets!=null) FormParamsBrackets.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(FormPars!=null) FormPars.traverseTopDown(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(FormParamsBrackets!=null) FormParamsBrackets.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(FormPars!=null) FormPars.traverseBottomUp(visitor);
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(FormParamsBrackets!=null) FormParamsBrackets.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FormParsDefinitionList(\n");

        if(FormPars!=null)
            buffer.append(FormPars.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(" "+tab+paramName);
        buffer.append("\n");

        if(FormParamsBrackets!=null)
            buffer.append(FormParamsBrackets.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FormParsDefinitionList]");
        return buffer.toString();
    }
}
