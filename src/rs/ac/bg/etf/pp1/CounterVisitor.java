package rs.ac.bg.etf.pp1;

import rs.ac.bg.etf.pp1.ast.*;

public class CounterVisitor extends VisitorAdaptor {
    protected int count;

    public int getCount() {
        return count;
    }

    public static class FormalParamCounter extends CounterVisitor {
        public void visit(FormParsDefinition formParsDefinition) {
            count++;
        }
        public void visit(FormParsDefinitionList formParsDefinitionList) {
            count++;
        }
    }

    public static class MethodVariablesCounter extends CounterVisitor {
        public void visit(HasMethodVariables hasMethodVariables) {
            count++;
        }
    }
}
