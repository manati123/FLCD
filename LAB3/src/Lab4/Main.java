package Lab4;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws LexicalException, FileNotFoundException {
        ST identifierST = new ST();
        ST constantST = new ST();
        PIF pif = new PIF();
        Scanner scanner = new Scanner(identifierST,constantST,pif,"p1");
        scanner.printAll();
    }
}
