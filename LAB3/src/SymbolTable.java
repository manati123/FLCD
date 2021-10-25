

public class SymbolTable {
    private HashTable<String> identifierHashTable = new HashTable<String>();
    private HashTable<Integer> intConstantsHashTable = new HashTable<Integer>();
    private HashTable<String> stringConstantsHashTable = new HashTable<String>();

    public Pair<Integer, String> addIdentifier(String name) throws Exception {
        this.identifierHashTable.add(name);
        return new Pair<>(name.hashCode(), name);
    }

    public Pair <Integer, Integer> addIntConstant(Integer constant) throws Exception {
       return this.intConstantsHashTable.add(constant);
    }

    public Pair<Integer,Integer> addStringConstant(String string) throws Exception {
        return this.stringConstantsHashTable.add(string);
    }

    public boolean hasIdentifier(String name){
        return identifierHashTable.contains(name);
    }

    public boolean hasIntegerConstant(Integer constant){
        return intConstantsHashTable.contains(constant);
    }

    public boolean hasStringConstant(String string){
        return stringConstantsHashTable.contains(string);
    }

    public String getIdentifier(Integer posInBucket, Integer posInList) throws Exception {
        return identifierHashTable.findByPair(posInBucket,posInList);
    }

    public Integer getIntConstant(Integer posInBucket, Integer posInList) throws Exception {
        return intConstantsHashTable.findByPair(posInBucket,posInList);
    }

    public String getStringConstant(Integer posInBucket, Integer posInList) throws Exception {
        return stringConstantsHashTable.findByPair(posInBucket,posInList);
    }

}
