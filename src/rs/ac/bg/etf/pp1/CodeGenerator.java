package rs.ac.bg.etf.pp1;

import rs.ac.bg.etf.pp1.ast.*;

public class Compiler extends VisitorAdaptor {
    private int mainPC;

    public int getMainPC() {
        return mainPC;
    }

    public void setMainPC(int mainPC) {
        this.mainPC = mainPC;
    }



}
