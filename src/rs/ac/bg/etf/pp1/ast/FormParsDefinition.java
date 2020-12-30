// generated with ast extension for cup
// version 0.8
// 29/11/2020 14:25:28


package rs.ac.bg.etf.pp1.ast;

public class FormParsDefinition extends FormPars {

    private Type Type;
    private String formParamName;
    private FormParamsBrackets FormParamsBrackets;

    public FormParsDefinition (Type Type, String formParamName, FormParamsBrackets FormParamsBrackets) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.formParamName=formParamName;
        this.FormParamsBrackets=FormParamsBrackets;
        if(FormParamsBrackets!=null) FormParamsBrackets.setParent(this);
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
    }

    public String getFormParamName() {
        return formParamName;
    }

    public void setFormParamName(String formParamName) {
        this.formParamName=formParamName;
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
        if(Type!=null) Type.accept(visitor);
        if(FormParamsBrackets!=null) FormParamsBrackets.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(FormParamsBrackets!=null) FormParamsBrackets.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(FormParamsBrackets!=null) FormParamsBrackets.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FormParsDefinition(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(" "+tab+formParamName);
        buffer.append("\n");

        if(FormParamsBrackets!=null)
            buffer.append(FormParamsBrackets.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FormParsDefinition]");
        return buffer.toString();
    }
}
