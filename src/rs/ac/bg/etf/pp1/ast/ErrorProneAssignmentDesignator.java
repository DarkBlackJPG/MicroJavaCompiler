// generated with ast extension for cup
// version 0.8
// 11/0/2021 14:23:46


package rs.ac.bg.etf.pp1.ast;

public class ErrorProneAssignmentDesignator extends DesignatorStatement {

    private ErrorProneAssignment ErrorProneAssignment;

    public ErrorProneAssignmentDesignator (ErrorProneAssignment ErrorProneAssignment) {
        this.ErrorProneAssignment=ErrorProneAssignment;
        if(ErrorProneAssignment!=null) ErrorProneAssignment.setParent(this);
    }

    public ErrorProneAssignment getErrorProneAssignment() {
        return ErrorProneAssignment;
    }

    public void setErrorProneAssignment(ErrorProneAssignment ErrorProneAssignment) {
        this.ErrorProneAssignment=ErrorProneAssignment;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ErrorProneAssignment!=null) ErrorProneAssignment.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ErrorProneAssignment!=null) ErrorProneAssignment.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ErrorProneAssignment!=null) ErrorProneAssignment.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ErrorProneAssignmentDesignator(\n");

        if(ErrorProneAssignment!=null)
            buffer.append(ErrorProneAssignment.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ErrorProneAssignmentDesignator]");
        return buffer.toString();
    }
}
