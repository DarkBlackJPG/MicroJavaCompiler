package rs.ac.bg.etf.pp1;

import java.util.HashMap;

public class SyntaxAnalysisWatcher {
    public enum Types{
        CLASS,
        METHODS,
        GLOBAL_VAR,
        GLOBAL_CONST,
        GLOBAL_ARRAY,
        LOCAL_IN_MAIN,
        STMTS_MAIN,
        FUNC_CALL_MAIN
    }

    private HashMap<Types, Integer> typesIntegerHashMap = new HashMap<>();

    public SyntaxAnalysisWatcher() {
        typesIntegerHashMap.put(Types.CLASS, 0);
        typesIntegerHashMap.put(Types.METHODS, 0);
        typesIntegerHashMap.put(Types.GLOBAL_ARRAY, 0);
        typesIntegerHashMap.put(Types.GLOBAL_CONST, 0);
        typesIntegerHashMap.put(Types.GLOBAL_VAR, 0);
        typesIntegerHashMap.put(Types.LOCAL_IN_MAIN, 0);
        typesIntegerHashMap.put(Types.STMTS_MAIN, 0);
        typesIntegerHashMap.put(Types.FUNC_CALL_MAIN, 0);
    }

    public void classDetected() {
        Integer i = typesIntegerHashMap.get(Types.CLASS);
        typesIntegerHashMap.put(Types.CLASS, i+1);
    }
    public void methodDetected() {
        Integer i = typesIntegerHashMap.get(Types.METHODS);
        typesIntegerHashMap.put(Types.METHODS, i+1);
    }
    public void globalArrayDetected() {
        Integer i = typesIntegerHashMap.get(Types.GLOBAL_ARRAY);
        typesIntegerHashMap.put(Types.GLOBAL_ARRAY, i+1);
    }
    public void globalConstantDetected() {
        Integer i = typesIntegerHashMap.get(Types.GLOBAL_CONST);
        typesIntegerHashMap.put(Types.GLOBAL_CONST, i+1);
    }
    public void globalVariableDetected() {
        Integer i = typesIntegerHashMap.get(Types.GLOBAL_VAR);
        typesIntegerHashMap.put(Types.GLOBAL_VAR, i+1);
    }
    public void localVariableInMainDetected() {
        Integer i = typesIntegerHashMap.get(Types.LOCAL_IN_MAIN);
        typesIntegerHashMap.put(Types.LOCAL_IN_MAIN, i+1);
    }
    public void mainStatementDetected() {
        Integer i = typesIntegerHashMap.get(Types.STMTS_MAIN);
        typesIntegerHashMap.put(Types.STMTS_MAIN, i+1);
    }
    public void functionCallDetected() {
        Integer i = typesIntegerHashMap.get(Types.FUNC_CALL_MAIN);
        typesIntegerHashMap.put(Types.FUNC_CALL_MAIN, i+1);
    }

    @Override
    public String toString() {
        StringBuilder builderDetected = new StringBuilder();
        builderDetected.append("Broj definisanih klasa: \t\t\t......................................................");
        builderDetected.append(typesIntegerHashMap.get(Types.CLASS));
        builderDetected.append("\n");

        builderDetected.append("Broj definisanih metoda: \t\t\t......................................................");
        builderDetected.append(typesIntegerHashMap.get(Types.METHODS));
        builderDetected.append("\n");

        builderDetected.append("Broj globalnih nizova: \t\t\t..........................................................");
        builderDetected.append(typesIntegerHashMap.get(Types.GLOBAL_ARRAY));
        builderDetected.append("\n");

        builderDetected.append("Broj globalnih promenljivih: \t\t\t..................................................");
        builderDetected.append(typesIntegerHashMap.get(Types.GLOBAL_VAR));
        builderDetected.append("\n");

        builderDetected.append("Broj globalnih konstanti: \t\t\t......................................................");
        builderDetected.append(typesIntegerHashMap.get(Types.GLOBAL_CONST));
        builderDetected.append("\n");

        builderDetected.append("Broj lokalnih promenljivih u [main()]: \t\t\t..........................................");
        builderDetected.append(typesIntegerHashMap.get(Types.LOCAL_IN_MAIN));
        builderDetected.append("\n");

        builderDetected.append("Broj izraza u [main()]: \t\t\t......................................................");
        builderDetected.append(typesIntegerHashMap.get(Types.STMTS_MAIN));
        builderDetected.append("\n");

        builderDetected.append("Broj poziva metoda u [main()]: \t\t\t..................................................");
        builderDetected.append(typesIntegerHashMap.get(Types.FUNC_CALL_MAIN));
        builderDetected.append("\n");
       return builderDetected.toString();
    }
}
