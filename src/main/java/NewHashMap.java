import java.nio.channels.FileChannel;

public class NewHashMap<K, V> {
    NewLinkedList<K> linkedList;

    public NewHashMap() {
        this.linkedList = new NewLinkedList<>();
    }

    public V get(K key) {
        MapNode<K, V> mapNode = (MapNode<K, V>) this.linkedList.search(key);
        return (mapNode == null) ? null : mapNode.getValue();
    }

    public void add(K key, V value) {
        MapNode<K, V> mapNode = (MapNode<K, V>) this.linkedList.search(key);
        if (mapNode == null){
            mapNode = new MapNode<>(key, value);
            this.linkedList.append(mapNode);
        }else {
            mapNode.setValue(value);
        }
    }
}
