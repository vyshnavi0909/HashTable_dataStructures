import java.util.ArrayList;

public class NewLinkedHashMap<K, V> {
    private final int numBuckets;
    ArrayList<NewLinkedList<K>> bucketArray;

    public NewLinkedHashMap(){
        this.numBuckets = 10;
        this.bucketArray = new ArrayList<>(numBuckets);
        //create empty LinkedLists
        for (int i = 0; i < numBuckets; i++){
            this.bucketArray.add(null);
        }
    }

    /**
     * method to implement hash function to
     * find index for a key
     * @param key
     * @return
     */
    private int getBucketIndex(K key){
        int hashCode = Math.abs(key.hashCode());
        int index = hashCode % numBuckets;
        return index;
    }

    /**
     * method to get a particular key
     * @param key
     * @return
     */
    public V get(K key){
        int index = this.getBucketIndex(key);
        NewLinkedList<K> linkedList = this.bucketArray.get(index);
        if(linkedList == null){
            return null;
        }
        MapNode<K, V> mapNode = (MapNode<K, V>) linkedList.search(key);
        return (mapNode == null) ? null : mapNode.getValue();
    }

    /**
     *
     * @param key
     * @param value
     */
    public void add(K key, V value){
        int index = this.getBucketIndex(key);
        NewLinkedList<K> linkedList = this.bucketArray.get(index);
        if(linkedList == null){
            linkedList = new NewLinkedList<K>();
            this.bucketArray.set(index, linkedList);
        }
        MapNode<K, V> mapNode = (MapNode<K, V>) linkedList.search(key);
        if (mapNode == null){
            mapNode = new MapNode<>(key, value);
            linkedList.append(mapNode);
        }else {
            mapNode.setValue(value);
        }
    }

    public String toString(){
        return  "LinkedHashMap List{" + bucketArray + "}";
    }
}

