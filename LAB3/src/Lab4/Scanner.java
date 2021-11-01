package Lab4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Scanner {
    public ArrayList<String> tokens;
    private final File tokensFile;
    private File problemFile;
    private ST identifierST;
    private ST constantST;
    private PIF pif;

    public Scanner(ST identifierST, ST constantST, PIF pif, String problem) throws FileNotFoundException, LexicalException {
        this.tokensFile = new File("/Users/silviu/Documents/ubb/LFTC/FLCD/LAB3/src/textFiles/token.in");
        this.tokens = new ArrayList<>();
        this.identifierST = identifierST;
        this.constantST = constantST;
        this.pif = pif;
        this.readFromFile();
        if(problem.equals("p1")){
            this.problemFile = new File("/Users/silviu/Documents/ubb/LFTC/FLCD/LAB3/src/textFiles/p1.boop");
            this.readProblem();
        }
    }

    public void readFromFile() throws FileNotFoundException{
        java.util.Scanner reader = new java.util.Scanner(this.tokensFile);
        while(reader.hasNextLine()){
//            System.out.println(reader.next());
            this.tokens.add(reader.nextLine());
        }
        reader.close();
    }

    public void readProblem() throws FileNotFoundException, LexicalException {
        java.util.Scanner myReader = new java.util.Scanner(this.problemFile);
        String input = "";
        while (myReader.hasNextLine()) {
            input += myReader.nextLine() + " ";
        }
        myReader.close();
        this.separate(input);

    }

    public void separate(String input) throws LexicalException {
        System.out.println(input);
        String[] separatedInput = input.split(" ");
        for (String word : separatedInput)
        {
            //System.out.println(word);
            if (!this.tokens.contains(word))
            {
                System.out.println(word + "->nonToken");
                //TODO:: regex comparison for letters and numbers
                String result = this.regexComparisson(word);
                if(result.equals("constant"))
                {
                    this.pif.addStToPIF(0,this.constantST.add(word));
                }
                else if (result.equals("identifier"))
                {
                    this.pif.addStToPIF(1,this.identifierST.add(word));
                }
                else
                {//here it means that is an lexical error because it's a number followed by letters
                    System.out.println(word + " this is an lexical error!\n");
                }
                //if number put in STconstant + pIF
                //if letter put un STidentifier +PIF
                //if letter followed by number is oke -> ST identifier
                //if number followed by letter(s) is not ok -> lexical error
            }
            else
            {//here it means that 'word' is an reserved word so it's automatically put in PIF
                this.pif.addNotSTtoPIF(word);
            }
        }
    }

    public String regexComparisson(String lexicalTokens) {
        int asciiValue = 0;
        ArrayList<Integer> structure = new ArrayList<Integer>();//0 for number 1 for letter
        for (int i = 0; i < lexicalTokens.length(); i++) {
            asciiValue = lexicalTokens.charAt(i);
            if(asciiValue >= 48 && asciiValue <= 57)
                structure.add(0);
            else
                if((asciiValue >= 65 && asciiValue <= 90) || (asciiValue >= 97 && asciiValue <= 122))
                    structure.add(1);

        }
        int type = -1;
        for(Integer number : structure){//1 - identifier and 0 - constant
            if(number == 0) {
                if (type == -1)
                    type = 0;
            }
            else if(number == 1)
                    if(type == -1)
                        type = 1;
                    else
                        if(type == 0)
                            return "lexicalError";
        }
        if(type == 1)
            return "identifier";
        else
            if(type == 0)
                return "constant";
            else
                return "lexicalError";

    }

    public void printAll(){
        System.out.println("Constant ST");
        System.out.println(this.constantST.getST());
        System.out.println("Identifier ST");
        System.out.println(this.identifierST.getST());
        System.out.println("PIF");
        System.out.println(this.pif.getPIF());
    }

}
