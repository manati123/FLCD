package Lab4;

import java.util.Hashtable;

public class ST {
    private Hashtable<Integer, String> symbolTable;

    public ST(){
        this.symbolTable = new Hashtable<Integer,String>();
    }

    public Integer getPosition(String token){
        for (int index = 1 ; index <= this.symbolTable.size(); index++)
        {
            if (this.symbolTable.get(index) == token )
            {
                return index;
            }
        }
        return 0;
    }

    public boolean exists(String token){
        return this.symbolTable.containsValue(token);
    }

    public static int getASCII(String token){
        int asciiValue = 0;
//        System.out.println(token + "----------------");
        for (int i = 0; i < token.length(); i++) {
            asciiValue += token.charAt(i);
        }
        return asciiValue;
    }

    public void hashTheTable(int asciiToken, String token)
    {
        //System.out.println(this.getSymbolTable());
        //System.out.println(this.getSymbolTable());
        int currentPosition = this.symbolTable.size();
        for (int index = this.symbolTable.size(); index > 0; index--)
        {
//            System.out.println(this.symbolTable.get(index));
            int currentASCII = getASCII(this.symbolTable.get(index));
            if (currentASCII > asciiToken)
            {
                String oldToken = this.symbolTable.get(index);
                this.symbolTable.replace(index,oldToken,token);
                this.symbolTable.replace(currentPosition,token,oldToken);
                currentPosition = index;
            }
        }
    }

    public int add(String token){
//        System.out.println(token);
        if(!this.exists(token)){
            this.symbolTable.put(symbolTable.size()+1,token);
            if(symbolTable.size() != 1){
                hashTheTable(getASCII(token),token);
            }
            return this.getPosition(token);
        }
        else
            return this.getPosition(token);
    }

    public String getST(){
        return this.symbolTable.toString();
    }
}
