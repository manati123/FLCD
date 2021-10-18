import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class HashTable<T> {
    private final int size = 107;

    private final ArrayList<ArrayList<T>> buckets = new ArrayList<>(size);

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
        for( var bucketElement : buckets.get(bucketPos)){
            if(bucketElement == element)
                return true;
        }
        return false;
    }

    public Pair<Integer, Integer> add(T element) throws Exception{
        if(this.contains(element))
            throw new Exception("Element already exists!");//return position!
        var posInBucket = element.hashCode() % size;
        var posInList = this.buckets.get(posInBucket).size();
        this.buckets.get(posInBucket).add(posInList,element);
        return new Pair<Integer,Integer>(posInBucket,posInList);
    }

}
