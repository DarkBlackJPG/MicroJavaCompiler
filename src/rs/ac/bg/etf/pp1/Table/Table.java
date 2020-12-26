package rs.ac.bg.etf.pp1.Table;

import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Scope;
import rs.etf.pp1.symboltable.concepts.Struct;
import rs.etf.pp1.symboltable.visitors.DumpSymbolTableVisitor;
import rs.etf.pp1.symboltable.visitors.SymbolTableVisitor;

public class Table extends Tab {


    // standardni tipovi
    public static final Struct noType = new Struct(Struct.None);
    public static final Struct intType = new Struct(Struct.Int);
    public static final Struct charType = new Struct(Struct.Char);
    public static final Struct nullType = new Struct(Struct.Class);
    public static final Struct boolType = new Struct(Struct.Bool);
    /*
        static SymbolDataStructure loc = new HashTableDataStructure();
        static {
            loc.insertKey(new Obj(Obj.Fld, "x", intType, 0, -1), false);
            loc.insertKey(new Obj(Obj.Fld, "y", intType, 1, -1), false);
            nullType = new Struct(Struct.Class, null, loc);
        }
        */
    public static final Obj noObj = new Obj(Obj.Var, "noObj", noType);
    public static Obj chrObj, ordObj, lenObj;

    public static Scope currentScope; // tekuci opseg
    private static int currentLevel; // nivo ugnezdavanja tekuceg opsega

    /**
     * Inicijalizacija universe opsega, tj. njegovo popunjavanje Obj cvorovima,
     * kao sto je izlozeno na vezbama i predavanjima. Razlika je sto se Obj
     * cvorovu umecu u hes tabelu.
     */
    public static void init() {
        Scope universe = currentScope = new Scope(null);

        universe.addToLocals(new Obj(Obj.Type, "int", intType));
        universe.addToLocals(new Obj(Obj.Type, "char", charType));
        universe.addToLocals(new Obj(Obj.Type, "bool", boolType));
        universe.addToLocals(new Obj(Obj.Con, "eol", charType, 10, 0));
        universe.addToLocals(new Obj(Obj.Con, "null", nullType, 0, 0));

        universe.addToLocals(chrObj = new Obj(Obj.Meth, "chr", charType, 0, 1));
        {
            openScope();
            currentScope.addToLocals(new Obj(Obj.Var, "i", intType, 0, 1));
            chrObj.setLocals(currentScope.getLocals());
            closeScope();
        }

        universe.addToLocals(ordObj = new Obj(Obj.Meth, "ord", intType, 0, 1));
        {
            openScope();
            currentScope.addToLocals(new Obj(Obj.Var, "ch", charType, 0, 1));
            ordObj.setLocals(currentScope.getLocals());
            closeScope();
        }


        universe.addToLocals(lenObj = new Obj(Obj.Meth, "len", intType, 0, 1));
        {
            openScope();
            currentScope.addToLocals(new Obj(Obj.Var, "arr", new Struct(Struct.Array, noType), 0, 1));
            lenObj.setLocals(currentScope.getLocals());
            closeScope();
        }

        currentLevel = -1;
    }

    public static void chainLocalSymbols(Obj outerScopeObj) {
        outerScopeObj.setLocals(currentScope.getLocals());
    }

    public static void chainLocalSymbols(Struct innerClass) {
        innerClass.setMembers(currentScope.getLocals());
    }

    /**
     * Otvaranje novog opsega
     */
    public static void openScope() {
        currentScope = new Scope(currentScope);
        currentLevel++;
    }

    /**
     * Zatvaranje opsega
     */
    public static void closeScope() {
        currentScope = currentScope.getOuter();
        currentLevel--;
    }

    /**
     * Pravi se novi Obj cvor sa prosledjenim atributima kind, name i type, pa se
     * zatim ubacuje u tabelu simbola. Povratna vrednost: - novostvoreni cvor, ako
     * cvor sa tim imenom nije vec postojao u tabeli simbola. - postojeci cvor iz
     * tabele simbola, ako je doslo do greske jer smo pokusali da u tabelu simbola
     * za opseg ubacimo cvor sa imenom koje vec postoji.
     */
    public static Obj insert(int kind, String name, Struct type) {
        // create a new Object node with kind, name, type
        Obj newObj = new Obj(kind, name, type, 0, ((currentLevel != 0) ? 1 : 0));

        // append the node to the end of the symbol list
        if (!currentScope.addToLocals(newObj)) {
            Obj res = currentScope.findSymbol(name);
            return (res != null) ? res : noObj;
        } else
            return newObj;
    }

    /**
     * U hes tabeli opsega trazi Obj cvor sa imenom name, pocevsi od
     * najugnezdenijeg opsega, pa redom kroz opsege na nizim nivoima. Povratna
     * vrednost: - pronadjeni Obj cvor, ako je pretrazivanje bilo uspesno. -
     * Tab.noObj objekat, ako je pretrazivanje bilo neuspesno.
     */
    public static Obj find(String name) {
        Obj resultObj = null;
        for (Scope s = currentScope; s != null; s = s.getOuter()) {
            if (s.getLocals() != null) {
                resultObj = s.getLocals().searchKey(name);
                if (resultObj != null) break;
            }
        }
        return (resultObj != null) ? resultObj : noObj;
    }

    public static Scope currentScope() {
        return currentScope;
    }

    public static void dump(SymbolTableVisitor stv) {
        System.out.println("=====================SYMBOL TABLE DUMP=========================");
        if (stv == null)
            stv = new TableRider();
        for (Scope s = currentScope; s != null; s = s.getOuter()) {
            s.accept(stv);
        }
        System.out.println(stv.getOutput());
    }

    /**
     * Stampa sadrzaj tabele simbola.
     */
    public static void dump() {
        dump(null);
    }
}

class TableRider extends DumpSymbolTableVisitor {

    protected StringBuilder output = new StringBuilder();
    protected final String indent = "   ";
    protected StringBuilder currentIndent = new StringBuilder();

    protected void nextIndentationLevel() {
        currentIndent.append(indent);
    }

    protected void previousIndentationLevel() {
        if (currentIndent.length() > 0)
            currentIndent.setLength(currentIndent.length()-indent.length());
    }


    /* (non-Javadoc)
     * @see rs.etf.pp1.symboltable.test.SymbolTableVisitor#visitObjNode(symboltable.Obj)
     */
    @Override
    public void visitObjNode(Obj objToVisit) {
        //output.append("[");
        switch (objToVisit.getKind()) {
            case Obj.Con:  output.append("Constant "); break;
            case Obj.Var:  output.append("Variable "); break;
            case Obj.Type: output.append("Type "); break;
            case Obj.Meth: output.append("Method "); break;
            case Obj.Fld:  output.append("Field "); break;
            case Obj.Prog: output.append("Program "); break;
        }

        output.append(objToVisit.getName());
        output.append(": ");

        if ((Obj.Var == objToVisit.getKind()) && "this".equalsIgnoreCase(objToVisit.getName()))
            output.append("");
        else
            objToVisit.getType().accept(this);

        output.append(", ");
        output.append(objToVisit.getAdr());
        output.append(", ");
        output.append(objToVisit.getLevel() + " ");

        if (objToVisit.getKind() == Obj.Prog || objToVisit.getKind() == Obj.Meth) {
            output.append("\n");
            nextIndentationLevel();
        }


        for (Obj o : objToVisit.getLocalSymbols()) {
            output.append(currentIndent.toString());
            o.accept(this);
            output.append("\n");
        }

        if (objToVisit.getKind() == Obj.Prog || objToVisit.getKind() == Obj.Meth)
            previousIndentationLevel();

        //output.append("]");

    }

    /* (non-Javadoc)
     * @see rs.etf.pp1.symboltable.test.SymbolTableVisitor#visitScopeNode(symboltable.Scope)
     */
    @Override
    public void visitScopeNode(Scope scope) {
        for (Obj o : scope.values()) {
            o.accept(this);
            output.append("\n");
        }
    }

    /* (non-Javadoc)
     * @see rs.etf.pp1.symboltable.test.SymbolTableVisitor#visitStructNode(symboltable.Struct)
     */
    @Override
    public void visitStructNode(Struct structToVisit) {
        switch (structToVisit.getKind()) {
            case Struct.None:
                output.append("notype");
                break;
            case Struct.Int:
                output.append("int");
                break;
            case Struct.Char:
                output.append("char");
                break;
            case Struct.Bool:
                output.append("bool");
                break;
            case Struct.Array:
                output.append("Array of ");

                switch (structToVisit.getElemType().getKind()) {
                    case Struct.None:
                        output.append("notype");
                        break;
                    case Struct.Int:
                        output.append("int");
                        break;
                    case Struct.Char:
                        output.append("char");
                        break;
                    case Struct.Bool:
                        output.append("bool");
                        break;
                    case Struct.Class:
                        output.append("Class");
                        break;
                }
                break;
            case Struct.Class:
                output.append("Class [");
                for (Obj obj : structToVisit.getMembers()) {
                    obj.accept(this);
                }
                output.append("]");
                break;
        }

    }

    public String getOutput() {
        return output.toString();
    }


}

