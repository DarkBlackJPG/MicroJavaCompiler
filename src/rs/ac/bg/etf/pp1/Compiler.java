package rs.ac.bg.etf.pp1;

import java_cup.runtime.Symbol;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;
import org.apache.log4j.xml.DOMConfigurator;
import rs.ac.bg.etf.pp1.ast.Program;
import rs.ac.bg.etf.pp1.util.Log4JUtils;
import rs.etf.pp1.mj.runtime.Code;
import rs.etf.pp1.symboltable.concepts.Scope;

import java.io.*;
import java.nio.channels.FileChannel;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        boolean errorDetected = false;
        String logFilename = null;
        try {
            if (args.length < 2) {
                System.err.println("\u001b[0;31m Mora da se definise putanja do programa za kompajliranje i putanja do izlaznog fajla! \u001b[m");
                System.exit(-99);
            }
            String program = args[0];
            Pattern p = Pattern.compile(".*/(.+).mj$");
            Matcher m = p.matcher(program);
            String name = "";
            if (m.find()) {
                name = m.group(1);
            } else {
                System.err.println("\u001b[0;31m Putanja mora da bude sa '/' i da se zavrsava sa .mj ! \u001b[m");
                System.exit(-99);
            }
            File sourceCode = new File(program);
            if (!sourceCode.exists()) {
                System.err.println("\u001b[0;31m Trazeni fajl ne postoji! \u001b[m");
                System.exit(-99);
            }

            logFilename = "test/"+name;

            report_info("|-----------------------------------------------------------------|");
            report_info("|                         LEKSICKA OBRADA                         |");
            report_info("|-----------------------------------------------------------------|");
            log.info("Compiling source file: " + sourceCode.getAbsolutePath());
            br = new BufferedReader(new FileReader(sourceCode));

            Yylex lexer = new Yylex(br);
            MJParser parser = new MJParser(lexer);
            Symbol s = parser.parse();

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
                errorDetected = true;
                report_error("Main metoda nije definisana u programu!!!");
                semanticAnalyzer.errorDetected = true;
            }
            report_info("|-------------------------------------------------------------------|");
            report_info("|                STATISTIKA KORISCENJA PROMENLJIVIH                 |");
            report_info("|-------------------------------------------------------------------|");
            log.info("\n" + semanticAnalyzer.syntaxAnalysisWatcher.toString());

            tsdump();
            if (parser.errorDetected || lexer.error_exists) {
                report_error("Detektovana je greska! Proveriti log za vise informacija!");
                errorDetected = true;
                //System.exit(0);
            }
            if (semanticAnalyzer.errorDetected) {
                errorDetected = true;
                report_error("Semanticka analiza je detektovala neku gresku. Objektni generisanje koda se nece" +
                        "izvrsiti!");
            } else {
                if (!parser.errorDetected) {
                    report_success("Uspesno izvrsena semanticka analiza! Nastavlja se sa generisanjem koda");
                    continueCodeGen = true;
                } else {
                    errorDetected = true;
                    report_error("Leksicka analiza je detektovala neku gresku. Objektni generisanje koda se nece" +
                            "izvrsiti!");
                }
            }

            if (continueCodeGen) {
                report_info("|-------------------------------------------------------------------|");
                report_info("|                          GENERISANJE KODA                         |");
                report_info("|-------------------------------------------------------------------|");
                String out_file = args[1];
                File file = new File(out_file);
                if (file.exists()) {
                    file.delete();
                }
                CodeGenerator codeGenerator = new CodeGenerator();
                prog.traverseBottomUp(codeGenerator);
                Code.dataSize = semanticAnalyzer.syntaxAnalysisWatcher.
                        getCountForType(SyntaxAnalysisWatcher.Types.GLOBAL_VAR)
                        + semanticAnalyzer.syntaxAnalysisWatcher.
                        getCountForType(SyntaxAnalysisWatcher.Types.GLOBAL_ARRAY)
                        + semanticAnalyzer.syntaxAnalysisWatcher.
                        getCountForType(SyntaxAnalysisWatcher.Types.GLOBAL_CONST);
                Code.mainPc = codeGenerator.getMainPC();
                if (!Code.greska) {
                    Code.write(new FileOutputStream(file));
                    report_success("Kompajliranje uspesno izvrseno!");
                } else {
                    errorDetected = true;
                    report_error("Doslo je do greske! Objektni fajl nije izgenerisan!");
                    //Code.write(new FileOutputStream(file));
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
            if (errorDetected) {
                File logIn = new File("logs/mj-test.log");
                File logOut = new File(logFilename + ".err");
                if (logOut.exists())
                    logOut.delete();
                boolean ok = false;
                try (FileChannel src = new FileInputStream(logIn).getChannel();
                     FileChannel dest = new FileOutputStream(logOut).getChannel()){
                    dest.transferFrom(src, 0, src.size());
                    ok = true;
                } finally {

                }


            } else {
                File logIn = new File("logs/mj-test.log");
                File logOut = new File(logFilename + ".out");
                if (logOut.exists())
                    logOut.delete();
                boolean ok = false;
                try (FileChannel src = new FileInputStream(logIn).getChannel();
                     FileChannel dest = new FileOutputStream(logOut).getChannel()){
                    dest.transferFrom(src, 0, src.size());
                    ok = true;
                } finally {

                }

            }

        }

    }
}
