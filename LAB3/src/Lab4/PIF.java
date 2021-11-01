package Lab4;

import java.util.Hashtable;

public class PIF {
    private Hashtable<Integer,String> programIdentifierForm;

    public PIF(){
        this.programIdentifierForm = new Hashtable<Integer,String>();
    }

    public void addNotSTtoPIF(String token){
        this.programIdentifierForm.put(0,token);
    }

    public void addStToPIF(int token, Integer positionInST){
        if(token == 0)
            this.programIdentifierForm.put(positionInST,"0");// 0 for constant
        else
            if(token == 1)
                this.programIdentifierForm.put(positionInST,"1");
    }

    public String getPIF(){
        return this.programIdentifierForm.toString();
    }
}
