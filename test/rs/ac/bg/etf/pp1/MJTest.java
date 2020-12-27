package rs.ac.bg.etf.pp1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import java_cup.runtime.Symbol;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import rs.ac.bg.etf.pp1.ast.Program;
import rs.ac.bg.etf.pp1.util.Log4JUtils;

public class MJTest {

	static {
		DOMConfigurator.configure(Log4JUtils.instance().findLoggerConfigFile());
		Log4JUtils.instance().prepareLogFile(Logger.getRootLogger());
	}
	
	public static void main(String[] args) throws Exception {
		Logger log = Logger.getLogger(MJTest.class);
		Reader br = null;
		try {
			
			File sourceCode = new File("test/program.mj");	
			log.info("Compiling source file: " + sourceCode.getAbsolutePath());
			
			br = new BufferedReader(new FileReader(sourceCode));
			
			
			Yylex lexer = new Yylex(br);
			MJParser parser = new MJParser(lexer);
			Symbol s = parser.parse();
			Table.init();
			Program prog = (Program)(s.value);
			
			log.info("========================");
			log.info(prog.toString(""));
			log.info("========================");
			
			
			SemanticAnalyzer semanticAnalyzer = new SemanticAnalyzer();
			prog.traverseBottomUp(semanticAnalyzer);
			
			log.info(" Print count calls = " + semanticAnalyzer.printCallCount);
			log.info(" Deklarisanih promenljivih ima = " + semanticAnalyzer.varDeclCount);
			log.info(" Deklarisanih nizova ima = " + semanticAnalyzer.varArrayDeclCount);
			log.info("===================================");
			Table.dump();
			
			
//			while ((currToken = lexer.next_token()).sym != sym.EOF) {
//				if (currToken != null && currToken.value != null)
//					log.info(currToken.toString() + " " + currToken.value.toString());
//			}
		} 
		finally {
			if (br != null) try { br.close(); } catch (IOException e1) { log.error(e1.getMessage(), e1); }
		}
	}
	
}
