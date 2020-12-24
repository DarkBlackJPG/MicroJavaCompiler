package rs.ac.bg.etf.pp1;

import org.apache.log4j.Logger;

import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.symboltable.*;
import rs.etf.pp1.symboltable.concepts.*;

public class SemanticAnalyzer extends VisitorAdaptor {
	int printCallCount = 0;
	int varDeclCount = 0;
	int varArrayDeclCount = 0;
	int constDeclCount = 0;

	Struct currentType = Tab.noType;

	Logger log = Logger.getLogger(getClass());

	public void report_error(String message, SyntaxNode info) {
		// errorDetected = true;
		StringBuilder msg = new StringBuilder(message);
		int line = (info == null) ? 0 : info.getLine();
		if (line != 0)
			msg.append(" na liniji ").append(line);
		log.error(msg.toString());
	}

	public void report_info(String message, SyntaxNode info) {
		StringBuilder msg = new StringBuilder(message);
		int line = (info == null) ? 0 : info.getLine();
		if (line != 0)
			msg.append(" na liniji ").append(line);
		log.info(msg.toString());
	}

	// VariableDeclaration is superclass
	public void visit(NonArrayVariable vardecl) {
		varDeclCount++;
		Obj variableNode = Tab.find(vardecl.getVariableName());
		if (variableNode == Tab.noObj) {
			Tab.insert(Obj.Var, vardecl.getVariableName(), currentType);
		} else {
			report_error("Promenlijva sa imenom " + vardecl.getVariableName() + " je vec deklarisana "
					+ vardecl.getLine() + "]", vardecl);
		}
	}

	public void visit(ErrorNonArrayVariable vardecl) {
		varDeclCount++;
		Obj variableNode = Tab.find(vardecl.getVariableName());
		if (variableNode == Tab.noObj) {
			Tab.insert(Obj.Var, vardecl.getVariableName(), currentType);
		} else {
			report_error("Promenlijva sa imenom " + vardecl.getVariableName() + " je vec deklarisana "
					+ vardecl.getLine() + "!", vardecl);
		}

	}

	public void visit(ArrayVariable vardecl) {
		varArrayDeclCount++;
		Obj variableNode = Tab.find(vardecl.getVariableName());
		if (variableNode == Tab.noObj) {
			Tab.insert(Obj.Var, vardecl.getVariableName(), new Struct(Struct.Array, currentType));
		} else {
			report_error("Promenlijva sa imenom " + vardecl.getVariableName() + " je vec deklarisana"
					+ vardecl.getLine() + "!", vardecl);
		}

	}

	public void visit(ErrorArrayVariable vardecl) {
		varArrayDeclCount++;
		Obj variableNode = Tab.find(vardecl.getVariableName());
		if (variableNode == Tab.noObj) {
			Tab.insert(Obj.Var, vardecl.getVariableName(), new Struct(Struct.Array, currentType));
		} else {
			report_error("Promenlijva sa imenom " + vardecl.getVariableName() + " je vec deklarisana "
					+ vardecl.getLine() + "!", vardecl);
		}

	}

	public void visit(NumericLiteral num) {
		num.obj = new Obj(Obj.Con, "", Tab.intType, num.getNumValue(), 0);
	}

	public void visit(CharLiteral num) {
		num.obj = new Obj(Obj.Con, "", Tab.charType, num.getCharValue(), 0);
	}

	public void visit(BooleanLiteral num) {
		String value = num.getBooleanValue();
		boolean isTrue = value.equals("true");
		num.obj = new Obj(Obj.Con, "", new Struct(Struct.Bool), isTrue? 1 : 0,
				0);
	}

	public void visit(ConstDefinition vardecl) {
		constDeclCount++;
		Obj variableNode = Tab.find(vardecl.getIdentification());
		if (variableNode == Tab.noObj) {
			variableNode = Tab.insert(Obj.Con, vardecl.getIdentification(), currentType);
			Obj literalObj = vardecl.getLiterals().obj;
			Struct literalType = literalObj.getType();
			if (literalType.equals(currentType)) {
				variableNode.setAdr(vardecl.getLiterals().obj.getAdr());
			} else {
				report_error("Ne moze da se dodeljuje " + literalType.toString() + " konstanti sa tipom "
						+ currentType.toString() + "!", null);
			}
		} else {
			report_error("Promenlijva sa imenom " + vardecl.getIdentification() + " je vec deklarisana "
					+ vardecl.getLine() + "!", vardecl);
		}
	}

	public void visit(PrintStmt print) {
		printCallCount++;
	}

	public void visit(Type type) {
		Obj typeNode = Tab.find(type.getType());
		if (typeNode == Tab.noObj) {
			report_error("Tip " + type.getType() + " ne postoji. [Line: " + type.getLine() + "]", null);
			type.struct = Tab.noType;

		} else {
			if (Obj.Type == typeNode.getKind()) {
				type.struct = typeNode.getType();
				currentType = typeNode.getType();
			} else {
				report_error(
						"GRESKA! Ime " + type.getType() + " nije naziv tipa u jeziku [Line " + type.getLine() + "]",
						type);
				type.struct = Tab.noType;
			}
		}
	}

	public void visit(ProgramName programName) {
		programName.obj = Tab.insert(Obj.Prog, programName.getProgramName(), Tab.noType);
		Tab.openScope();
	}

	public void visit(Program program) {
		Tab.chainLocalSymbols(program.getProgName().obj);
		Tab.closeScope();
	}
}
