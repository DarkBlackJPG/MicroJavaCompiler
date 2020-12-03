
//----------------------------------------------------
// The following code was generated by CUP v0.10k
// Thu Dec 03 20:50:55 CET 2020
//----------------------------------------------------

package rs.ac.bg.etf.pp1;

import java_cup.runtime.*;
import org.apache.log4j.*;
import rs.ac.bg.etf.pp1.ast.*;

/** CUP v0.10k generated parser.
  * @version Thu Dec 03 20:50:55 CET 2020
  */
public class MJParser extends java_cup.runtime.lr_parser {

  /** Default constructor. */
  public MJParser() {super();}

  /** Constructor which sets the default scanner. */
  public MJParser(java_cup.runtime.Scanner s) {super(s);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\027\000\002\003\010\000\002\002\004\000\002\010" +
    "\003\000\002\010\002\000\002\012\006\000\002\014\003" +
    "\000\002\014\005\000\002\015\005\000\002\016\003\000" +
    "\002\016\003\000\002\016\003\000\002\005\003\000\002" +
    "\005\003\000\002\005\003\000\002\005\003\000\002\005" +
    "\003\000\002\005\003\000\002\006\003\000\002\007\003" +
    "\000\002\007\003\000\002\004\003\000\002\004\003\000" +
    "\002\004\003" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\027\000\004\011\005\001\002\000\004\002\031\001" +
    "\002\000\004\004\006\001\002\000\006\026\ufffe\030\007" +
    "\001\002\000\002\001\002\000\004\026\012\001\002\000" +
    "\004\026\uffff\001\002\000\002\001\002\000\004\027\014" +
    "\001\002\000\004\002\001\001\002\000\004\004\017\001" +
    "\002\000\006\010\ufffc\031\ufffc\001\002\000\004\025\024" +
    "\001\002\000\006\010\021\031\022\001\002\000\004\004" +
    "\017\001\002\000\004\026\ufffd\001\002\000\006\010\ufffb" +
    "\031\ufffb\001\002\000\010\005\026\006\030\007\025\001" +
    "\002\000\006\010\ufff8\031\ufff8\001\002\000\006\010\ufff9" +
    "\031\ufff9\001\002\000\006\010\ufffa\031\ufffa\001\002\000" +
    "\006\010\ufff7\031\ufff7\001\002\000\004\002\000\001\002" +
    "" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\027\000\004\003\003\001\001\000\002\001\001\000" +
    "\002\001\001\000\006\010\007\012\010\001\001\000\004" +
    "\013\014\001\001\000\002\001\001\000\002\001\001\000" +
    "\004\011\012\001\001\000\002\001\001\000\002\001\001" +
    "\000\006\014\017\015\015\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\004\015\022\001\001" +
    "\000\002\001\001\000\002\001\001\000\004\016\026\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$MJParser$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$MJParser$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$MJParser$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 1;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}


  /** Scan to get the next Symbol. */
  public java_cup.runtime.Symbol scan()
    throws java.lang.Exception
    {

	Symbol s = this.getScanner().next_token();
	if (s != null && s.value != null) 
		log.info(s.toString() + " " + s.value.toString());
	return s;

    }



	Logger log = Logger.getLogger(getClass());
   
   
    // slede redefinisani metodi za prijavu gresaka radi izmene teksta poruke
     
    public void report_fatal_error(String message, Object info) throws java.lang.Exception {
      done_parsing();
      report_error(message, info);
    }
  
    public void syntax_error(Symbol cur_token) {
        report_error("\nSintaksna greska", cur_token);
    }
  
    public void unrecovered_syntax_error(Symbol cur_token) throws java.lang.Exception {
        report_fatal_error("Fatalna greska, parsiranje se ne moze nastaviti", cur_token);
    }

    public void report_error(String message, Object info) {
    	StringBuilder msg = new StringBuilder(message); 
    	if (info instanceof Symbol)
            msg.append (" na liniji ").append(((Symbol)info).left);
        log.error(msg.toString());
    }



}

/** Cup generated class to encapsulate user supplied action code.*/
class CUP$MJParser$actions {
  private final MJParser parser;

  /** Constructor */
  CUP$MJParser$actions(MJParser parser) {
    this.parser = parser;
  }

  /** Method with the actual generated action code. */
  public final java_cup.runtime.Symbol CUP$MJParser$do_action(
    int                        CUP$MJParser$act_num,
    java_cup.runtime.lr_parser CUP$MJParser$parser,
    java.util.Stack            CUP$MJParser$stack,
    int                        CUP$MJParser$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$MJParser$result;

      /* select the action based on the action number */
      switch (CUP$MJParser$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 22: // MulOp ::= MODULO 
            {
              MulOp RESULT = null;
		 RESULT=new MulopModulo(); 
              CUP$MJParser$result = new java_cup.runtime.Symbol(2/*MulOp*/, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).left, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).right, RESULT);
            }
          return CUP$MJParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 21: // MulOp ::= DIVIDE 
            {
              MulOp RESULT = null;
		 RESULT=new MulopDivide(); 
              CUP$MJParser$result = new java_cup.runtime.Symbol(2/*MulOp*/, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).left, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).right, RESULT);
            }
          return CUP$MJParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 20: // MulOp ::= TIMES 
            {
              MulOp RESULT = null;
		 RESULT=new MulopTimes(); 
              CUP$MJParser$result = new java_cup.runtime.Symbol(2/*MulOp*/, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).left, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).right, RESULT);
            }
          return CUP$MJParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 19: // AddOp ::= MINUS 
            {
              AddOp RESULT = null;
		 RESULT=new AddopMinus(); 
              CUP$MJParser$result = new java_cup.runtime.Symbol(5/*AddOp*/, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).left, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).right, RESULT);
            }
          return CUP$MJParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 18: // AddOp ::= PLUS 
            {
              AddOp RESULT = null;
		 RESULT=new AddopPlus(); 
              CUP$MJParser$result = new java_cup.runtime.Symbol(5/*AddOp*/, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).left, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).right, RESULT);
            }
          return CUP$MJParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 17: // AssignOp ::= ASSIGN 
            {
              AssignOp RESULT = null;
		 RESULT=new AssignOp(); 
              CUP$MJParser$result = new java_cup.runtime.Symbol(4/*AssignOp*/, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).left, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).right, RESULT);
            }
          return CUP$MJParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 16: // RelOp ::= LESS_EQUAL 
            {
              RelOp RESULT = null;
		 RESULT=new RelopLessEqual(); 
              CUP$MJParser$result = new java_cup.runtime.Symbol(3/*RelOp*/, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).left, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).right, RESULT);
            }
          return CUP$MJParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 15: // RelOp ::= LESS_THAN 
            {
              RelOp RESULT = null;
		 RESULT=new RelopLessThan(); 
              CUP$MJParser$result = new java_cup.runtime.Symbol(3/*RelOp*/, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).left, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).right, RESULT);
            }
          return CUP$MJParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 14: // RelOp ::= LARGER_EQUAL 
            {
              RelOp RESULT = null;
		 RESULT=new RelopLargerEqual(); 
              CUP$MJParser$result = new java_cup.runtime.Symbol(3/*RelOp*/, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).left, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).right, RESULT);
            }
          return CUP$MJParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // RelOp ::= LARGER_THAN 
            {
              RelOp RESULT = null;
		 RESULT=new RelopLargerThan(); 
              CUP$MJParser$result = new java_cup.runtime.Symbol(3/*RelOp*/, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).left, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).right, RESULT);
            }
          return CUP$MJParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // RelOp ::= NOT_EQUAL 
            {
              RelOp RESULT = null;
		 RESULT=new RelopNotEqual(); 
              CUP$MJParser$result = new java_cup.runtime.Symbol(3/*RelOp*/, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).left, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).right, RESULT);
            }
          return CUP$MJParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // RelOp ::= EQUALS 
            {
              RelOp RESULT = null;
		 RESULT=new RelopEquals(); 
              CUP$MJParser$result = new java_cup.runtime.Symbol(3/*RelOp*/, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).left, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).right, RESULT);
            }
          return CUP$MJParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // Literals ::= CHAR_CONST 
            {
              Literals RESULT = null;
		int valueleft = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).left;
		int valueright = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).right;
		Character value = (Character)((java_cup.runtime.Symbol) CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).value;
		 RESULT=new CharLiteral(value); RESULT.setLine(valueleft); 
              CUP$MJParser$result = new java_cup.runtime.Symbol(12/*Literals*/, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).left, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).right, RESULT);
            }
          return CUP$MJParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // Literals ::= BOOL_CONST 
            {
              Literals RESULT = null;
		int valueleft = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).left;
		int valueright = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).right;
		Boolean value = (Boolean)((java_cup.runtime.Symbol) CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).value;
		 RESULT=new BooleanLiteral(value); RESULT.setLine(valueleft); 
              CUP$MJParser$result = new java_cup.runtime.Symbol(12/*Literals*/, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).left, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).right, RESULT);
            }
          return CUP$MJParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // Literals ::= NUM_CONST 
            {
              Literals RESULT = null;
		int valueleft = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).left;
		int valueright = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).right;
		Integer value = (Integer)((java_cup.runtime.Symbol) CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).value;
		 RESULT=new NumericLiteral(value); RESULT.setLine(valueleft); 
              CUP$MJParser$result = new java_cup.runtime.Symbol(12/*Literals*/, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).left, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).right, RESULT);
            }
          return CUP$MJParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // Const ::= IDENT ASSIGN Literals 
            {
              Const RESULT = null;
		int identificationleft = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-2)).left;
		int identificationright = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-2)).right;
		String identification = (String)((java_cup.runtime.Symbol) CUP$MJParser$stack.elementAt(CUP$MJParser$top-2)).value;
		int L1left = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).left;
		int L1right = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).right;
		Literals L1 = (Literals)((java_cup.runtime.Symbol) CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).value;
		 RESULT=new ConstDefinition(identification, L1); RESULT.setLine(identificationleft); 
              CUP$MJParser$result = new java_cup.runtime.Symbol(11/*Const*/, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-2)).left, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).right, RESULT);
            }
          return CUP$MJParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // ConstList ::= ConstList COMMA Const 
            {
              ConstList RESULT = null;
		int C1left = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-2)).left;
		int C1right = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-2)).right;
		ConstList C1 = (ConstList)((java_cup.runtime.Symbol) CUP$MJParser$stack.elementAt(CUP$MJParser$top-2)).value;
		int C2left = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).left;
		int C2right = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).right;
		Const C2 = (Const)((java_cup.runtime.Symbol) CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).value;
		 RESULT=new MoreConsts(C1, C2); RESULT.setLine(C1left); 
              CUP$MJParser$result = new java_cup.runtime.Symbol(10/*ConstList*/, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-2)).left, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).right, RESULT);
            }
          return CUP$MJParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // ConstList ::= Const 
            {
              ConstList RESULT = null;
		int C1left = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).left;
		int C1right = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).right;
		Const C1 = (Const)((java_cup.runtime.Symbol) CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).value;
		 RESULT=new SingleConst(C1); RESULT.setLine(C1left); 
              CUP$MJParser$result = new java_cup.runtime.Symbol(10/*ConstList*/, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).left, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).right, RESULT);
            }
          return CUP$MJParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // Decls ::= CONST Type ConstList SEMI 
            {
              Decls RESULT = null;
		int T1left = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-2)).left;
		int T1right = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-2)).right;
		Type T1 = (Type)((java_cup.runtime.Symbol) CUP$MJParser$stack.elementAt(CUP$MJParser$top-2)).value;
		int C2left = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-1)).left;
		int C2right = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-1)).right;
		ConstList C2 = (ConstList)((java_cup.runtime.Symbol) CUP$MJParser$stack.elementAt(CUP$MJParser$top-1)).value;
		 RESULT=new ConstDeclarations(T1, C2); RESULT.setLine(T1left); 
              CUP$MJParser$result = new java_cup.runtime.Symbol(8/*Decls*/, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-3)).left, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).right, RESULT);
            }
          return CUP$MJParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // Declarations ::= 
            {
              Declarations RESULT = null;
		 RESULT=new NoDecls(); 
              CUP$MJParser$result = new java_cup.runtime.Symbol(6/*Declarations*/, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).right, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).right, RESULT);
            }
          return CUP$MJParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // Declarations ::= Decls 
            {
              Declarations RESULT = null;
		int D1left = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).left;
		int D1right = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).right;
		Decls D1 = (Decls)((java_cup.runtime.Symbol) CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).value;
		 RESULT=new DeclarationList(D1); RESULT.setLine(D1left); 
              CUP$MJParser$result = new java_cup.runtime.Symbol(6/*Declarations*/, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).left, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).right, RESULT);
            }
          return CUP$MJParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // $START ::= Program EOF 
            {
              SyntaxNode RESULT = null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-1)).right;
		Program start_val = (Program)((java_cup.runtime.Symbol) CUP$MJParser$stack.elementAt(CUP$MJParser$top-1)).value;
		RESULT = start_val;
              CUP$MJParser$result = new java_cup.runtime.Symbol(0/*$START*/, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-1)).left, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).right, RESULT);
            }
          /* ACCEPT */
          CUP$MJParser$parser.done_parsing();
          return CUP$MJParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // Program ::= PROG IDENT Declarations BRACES_BEGIN MethodDeclarations BRACES_END 
            {
              Program RESULT = null;
		int programNameleft = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-4)).left;
		int programNameright = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-4)).right;
		String programName = (String)((java_cup.runtime.Symbol) CUP$MJParser$stack.elementAt(CUP$MJParser$top-4)).value;
		int D1left = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-3)).left;
		int D1right = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-3)).right;
		Declarations D1 = (Declarations)((java_cup.runtime.Symbol) CUP$MJParser$stack.elementAt(CUP$MJParser$top-3)).value;
		int M2left = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-1)).left;
		int M2right = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-1)).right;
		MethodDeclarations M2 = (MethodDeclarations)((java_cup.runtime.Symbol) CUP$MJParser$stack.elementAt(CUP$MJParser$top-1)).value;
		 RESULT=new Program(programName, D1, M2); RESULT.setLine(programNameleft); 
              CUP$MJParser$result = new java_cup.runtime.Symbol(1/*Program*/, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-5)).left, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).right, RESULT);
            }
          return CUP$MJParser$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number found in internal parse table");

        }
    }
}

