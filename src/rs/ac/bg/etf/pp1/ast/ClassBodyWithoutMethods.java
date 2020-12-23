// generated with ast extension for cup
// version 0.8
// 23/11/2020 13:17:15


package rs.ac.bg.etf.pp1.ast;

public class ClassBodyWithoutMethods extends ClassBody {

    private FieldList FieldList;

    public ClassBodyWithoutMethods (FieldList FieldList) {
        this.FieldList=FieldList;
        if(FieldList!=null) FieldList.setParent(this);
    }

    public FieldList getFieldList() {
        return FieldList;
    }

    public void setFieldList(FieldList FieldList) {
        this.FieldList=FieldList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(FieldList!=null) FieldList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(FieldList!=null) FieldList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(FieldList!=null) FieldList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ClassBodyWithoutMethods(\n");

        if(FieldList!=null)
            buffer.append(FieldList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ClassBodyWithoutMethods]");
        return buffer.toString();
    }
}
