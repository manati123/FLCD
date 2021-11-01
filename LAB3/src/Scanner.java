import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

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

        operators.put("<",10);
        operators.put("<=",11);
        operators.put(">",12);
        operators.put(">=",13);
        operators.put("&&",20);
        operators.put("+",29);
        operators.put("-",30);
        operators.put("/",33);
        operators.put("*",31);
        operators.put("&",25);
        operators.put("|",26);
        operators.put("%",32);
        operators.put("=",28);
        operators.put("^",27);
        operators.put("~",24);
        operators.put("<<",22);
        operators.put(">>",23);
        operators.put("!",19);
        operators.put("!=",17);
        operators.put("||",21);
        operators.put("++",14);
        operators.put("--",15);
        operators.put("?:",18);
    }

    boolean isIdentifier(String token){
        return isIdentifier(token);
    }

    boolean isNumber(String token){
        return token.length() >=1 && (isNumber(token) && String.valueOf(Integer.parseInt(token)) == token);
    }

    boolean isChar(String token){
        return token.length() == 3 && token.charAt(0) == '"'  && token.charAt(2) == '"';
    }

    boolean isString(String token){
        return token.length() >= 2 && token.charAt(0) == '"' && token.charAt(token.length()) == '"';
    }

    boolean isBool(String token){
        return Objects.equals(token, "true") || Objects.equals(token, "false");
    }

    boolean isConstant(String token){
        return isNumber(token) || isChar(token) || isString(token) || isBool(token);
    }

    String detect(String token) throws LexicalException {
        if(Objects.equals(token, ""))
            return "none";
        if(reservedWords.containsValue(token) || this.operators.containsValue(token) || this.separators.containsValue(token))
            return token;
        if(isIdentifier(token))
            return "identifier";
        if(isConstant(token))
            return "constant";
        throw new LexicalException("Token " + token + " is not a reserved word or a valid identifier or constant.");
    }

    void scanner(String filename) throws FileNotFoundException {
        File myFile = new File(filename);
        java.util.Scanner reader = new java.util.Scanner(myFile);
//        while(reader.hasNext())
    }
}
