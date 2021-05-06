public class MapNode<K, V> implements INode<K>{
    K key;
    V value;
    MapNode<K, V> next;

    /**
     * constructor
     * @param key
     * @param value
     */
    public MapNode(K key, V value){
        this.key = key;
        this.value = value;
        next = null ;
    }

    @Override
    public K getKey() {
        return this.key;
    }

    @Override
    public void setKey(K key) {
        this.key = key;
    }

    @Override
    public INode<K> getNext() {
        return next;
    }

    @Override
    public void setNext(INode<K> next) {
        this.next = (MapNode<K, V>) next;
    }

    public V getValue() {
        return this.value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    @Override
    public  String toString(){
        StringBuffer mapNodeString = new StringBuffer();
        mapNodeString.append("MapNode{" + "K=").append(key)
                .append("V=").append(value).append('}');
        if (next != null){
            mapNodeString.append("->").append(next);
        }
        return mapNodeString.toString();
    }

}
