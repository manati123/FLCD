import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HashTable<T> {
    private final int size = 107;

    private HashMap<Integer,ArrayList<T>> buckets = new HashMap<>();
//    private final ArrayList<ArrayList<T>> buckets = new ArrayList<>(size);

    public HashTable() {

    }

    public T findByPair(int positionInBucket, int positionInList) throws Exception {
        if(positionInBucket<0 || positionInBucket>this.size)
            throw new Exception("Invalid position!");
        if(positionInList < 0 || positionInList > buckets.get(positionInBucket).size())
            throw new Exception("Invalid position!");
        return buckets.get(positionInBucket).get(positionInList);
    }

    public boolean contains(T element){
        var bucketPos = element.hashCode()% size;
        if(buckets.get(bucketPos) == null)
            return false;
        for( var bucketElement : buckets.get(bucketPos)){
            if(bucketElement == element)
                return true;
        }
        return false;
    }

    public Pair<Integer, Integer> add(T element) throws Exception{
        var posInBucket = element.hashCode() % size;
        int posInList;
        if(this.buckets.get(posInBucket) == null) {
            this.buckets.put(posInBucket, new ArrayList<>());
            posInList = 0;
        }
        else
            posInList = this.buckets.get(posInBucket).size();
        if(this.contains(element))
            return new Pair<>(posInBucket,posInList);//return position!




        this.buckets.get(posInBucket).add(posInList,element);
        return new Pair<Integer,Integer>(posInBucket,posInList);
    }

}
