import java.util.HashMap;
import java.util.Map;

public class Scanner {
    private Map<String, Integer> reservedWords = new HashMap<>();
    private Map<String, Integer> operators = new HashMap<>();
    private Map<String, Integer> separators = new HashMap<>();

    public Scanner() {
        //reserved words
        reservedWords.put("identifier",0);
        reservedWords.put("constant",1);
        reservedWords.put("break",34);
        reservedWords.put("case",35);
        reservedWords.put("char",36);
        reservedWords.put("const",37);
        reservedWords.put("continue",38);
        reservedWords.put("default",39);
        reservedWords.put("do",40);
        reservedWords.put("double",41);
        reservedWords.put("else",42);
        reservedWords.put("float",45);
        reservedWords.put("for",46);
        reservedWords.put("print",47);
        reservedWords.put("if",48);
        reservedWords.put("int",49);
        reservedWords.put("long",50);
        reservedWords.put("return",51);
        reservedWords.put("short",52);
        reservedWords.put("sizeof",54);
        reservedWords.put("static",55);
        reservedWords.put("switch",57);
        reservedWords.put("typedef",58);
        reservedWords.put("void",60);
        reservedWords.put("while",61);
        reservedWords.put("inline",62);

        //separators
        separators.put("[",2);
        separators.put("]",3);
        separators.put("{",4);
        separators.put("}",5);
        separators.put("(",63);
        separators.put(")",64);
        separators.put(";",6);
        separators.put(",",9);

        //operators

        operators.put("",);
        operators.put("",);
        operators.put("",);
        operators.put("",);
        operators.put("",);
        operators.put("",);
        operators.put("",);
        operators.put("",);
        operators.put("",);
        operators.put("",);
        operators.put("",);
        operators.put("",);
        operators.put("",);
        operators.put("",);
        operators.put("",);
        operators.put("",);
        operators.put("",);
        operators.put("",);
        operators.put("",);
        operators.put("",);
        operators.put("",);
        operators.put("",);
        operators.put("",);
        operators.put("",);
    }
}
