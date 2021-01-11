package rs.ac.bg.etf.pp1;

import java_cup.runtime.Symbol;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import rs.ac.bg.etf.pp1.ast.Program;
import rs.ac.bg.etf.pp1.util.Log4JUtils;
import rs.etf.pp1.mj.runtime.Code;
import rs.etf.pp1.symboltable.concepts.Scope;

import java.io.*;

public class Compiler {
    static Logger log = Logger.getLogger(Compiler.class);
    private static boolean continueCodeGen = false;

    static {
        DOMConfigurator.configure(Log4JUtils.instance().findLoggerConfigFile());
        Log4JUtils.instance().prepareLogFile(Logger.getRootLogger());
    }

    public static void report_error(String message) {
        log.error("\u001b[0;31m" + message + "\u001b[m");
    }

    public static void report_info(String message) {
        log.info("\u001b[0;36m" + message + "\u001b[m");
    }

    public static void report_success(String message) {
        log.info("\u001B[0;32m" + message + "\u001b[m");
    }

    public static void tsdump() {
        report_info("============================= SADRZAJ TABELE SIMBOLA =============================");
        TableRider stv = new TableRider();
        for (Scope s = Table.currentScope(); s != null; s = s.getOuter()) {
            s.accept(stv);
        }
        System.out.println(stv.getOutput());
    }

    public static void main(String[] args) throws Exception {
        Reader br = null;

        try {
            if (args.length < 2){
                report_error("Mora da se definise putanja do programa za kompajliranje i putanja do izlaznog fajla!");
                System.exit(-99);
            }
            String program = args[0];
            File sourceCode = new File(program);
            //File sourceCode = new File("test/program.mj");
            report_info("|-----------------------------------------------------------------|");
            report_info("|                         LEKSICKA OBRADA                         |");
            report_info("|-----------------------------------------------------------------|");
            log.info("Compiling source file: " + sourceCode.getAbsolutePath());
            br = new BufferedReader(new FileReader(sourceCode));

            Yylex lexer = new Yylex(br);
            MJParser parser = new MJParser(lexer);
            Symbol s = parser.parse();
            if (parser.errorDetected || lexer.error_exists) {
                report_error("Detektovana leksicka greska, obustavlja se proces kompajliranja.");
                System.exit(0);
            }
            Table.init();
            Program prog = (Program) (s.value);
            report_info("|-------------------------------------------------------------------|");
            report_info("|                         APSTRAKTNO STABLO                         |");
            report_info("|-------------------------------------------------------------------|");
            log.info(prog.toString(""));

            SemanticAnalyzer semanticAnalyzer = new SemanticAnalyzer();
            report_info("|-------------------------------------------------------------------|");
            report_info("|                         SEMANTICKA OBRADA                         |");
            report_info("|-------------------------------------------------------------------|");
            prog.traverseBottomUp(semanticAnalyzer);
            if (!semanticAnalyzer.mainMethodDetected) {
                report_error("Main metoda nije definisana u programu!!!");
                semanticAnalyzer.errorDetected = true;
            }
            log.info("\n" + semanticAnalyzer.syntaxAnalysisWatcher.toString());

            tsdump();

            if (semanticAnalyzer.errorDetected) {
                report_error("Semanticka analiza je detektovala neku gresku. Objektni generisanje koda se nece" +
                        "izvrsiti!");
            } else {
                if (!parser.errorDetected) {
                    report_success("Uspesno izvrsena semanticka analiza! Nastavlja se sa generisanjem koda");
                    continueCodeGen = true;
                } else {
                    report_error("Leksicka analiza je detektovala neku gresku. Objektni generisanje koda se nece" +
                            "izvrsiti!");
                }
            }

            if (continueCodeGen) {
                report_info("|-------------------------------------------------------------------|");
                report_info("|                          GENERISANJE KODA                         |");
                report_info("|-------------------------------------------------------------------|");
                String name = args[1];
                name = "program.obj" ;
                File file = new File("test/"+name);
                if (file.exists()) {
                    file.delete();
                }
                CodeGenerator codeGenerator = new CodeGenerator();
                prog.traverseBottomUp(codeGenerator);
                Code.dataSize = semanticAnalyzer.syntaxAnalysisWatcher.
                        getCountForType(SyntaxAnalysisWatcher.Types.GLOBAL_VAR)
                        + semanticAnalyzer.syntaxAnalysisWatcher.
                        getCountForType(SyntaxAnalysisWatcher.Types.GLOBAL_VAR);
                Code.mainPc = codeGenerator.getMainPC();
                if (!Code.greska) {
                    Code.write(new FileOutputStream(file));
                    report_success("Kompajliranje uspesno izvrseno!");
                } else {
                    report_error("Doslo je do greske! Objektni fajl nije izgenerisan!");
                    Code.write(new FileOutputStream(file));
                }
            }
        } finally {
            if (br != null) try {
                br.close();
            } catch (IOException e1) {
                log.error(e1.getMessage(), e1);
            }

            report_info("|-------------------------------------------------------------------|");
            report_info("|                              KRAJ RADA                            |");
            report_info("|-------------------------------------------------------------------|");
        }
    }
}
