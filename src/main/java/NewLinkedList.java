public class NewLinkedList<K> {
    public INode head;
    public INode tail;

    NewLinkedList() {
        this.head = null;
        this.tail = null;
    }

    /**
     * method to add element at front
     * @param node
     */
    public void add(INode<K> node) {
        if( this.tail == null){
            this.tail = node;
        }if ( this.head == null){
            this.head = node;
        }else {
            INode<K> tempNode = this.head;
            this.head = node;
            this.head.setNext(tempNode);
        }
    }

    /**
     * method to add element at last
     * @param node
     */
    public void append(INode<K> node){
        if( this.head == null){
            this.head = node;
        }if( this.tail == null){
            this.tail = node;
        }else {
            this.tail.setNext(node);
            this.tail = node;
        }
    }

    /**
     * method to insert element between two elements
     * @param node
     * @param newNode
     */
    public void insert(INode<K> node, INode<K> newNode){
        INode<K> tempNode = node.getNext();
        node.setNext(newNode);
        newNode.setNext(tempNode);
    }

    /**
     * method to remove first element
     * @return
     */
    public INode<K> pop(){
        INode<K> tempNode = this.head;
        this.head = head.getNext();
        return tempNode;
    }

    /**
     * method to remove last element
     * @return
     */
    public INode<K> popLast() {
        INode<K> tempNode = head;
        while (!tempNode.getNext().equals(tail)){
            tempNode = tempNode.getNext();
        }
        this.tail = tempNode;
        tempNode = tempNode.getNext();
        return tempNode;
    }

    /**
     * method to search an element
     * @param key
     * @return
     */
    public INode<K> search(K key) {
        INode<K> tempNode = head;
        while (tempNode != null ) {
            if (tempNode.getKey().equals(key)) {
                return tempNode;
            }else {
                return null;
            }
        } return null;
    }

    /**
     * method to search an element a insert new element after it
     * @param node
     * @param newNode
     */
    public void searchAndInsert(int node, INode<K> newNode) {
        INode<K> tempNode = head;
        while (tempNode.getNext() != null){
            if(tempNode.getKey().equals(node)){
                INode<K> temp = tempNode.getNext();
                tempNode.setNext(newNode);
                newNode.setNext(temp);
            }
            tempNode = tempNode.getNext();
        }
    }

    /**
     * method to search an element to delete it
     * @param node
     */
    public void searchAndDelete(int node) {
        INode<K> tempNode = head;
        while (tempNode.getNext() != null){
            if(tempNode.getNext().getKey().equals(node)){
                INode<K> temp = tempNode.getNext().getNext();
                tempNode.setNext(temp);
            }
            tempNode = tempNode.getNext();
        }
    }

    /**
     * method to count number of elements
     * @return
     */
    public int size(){
        INode<K> temp = head;
        int count = 0;
        while (temp != null)
        {
            count++;
            temp = temp.getNext();
        }
        return count;
    }

    /**
     * method to print the elements
     */
    public void printNodes(){
        StringBuffer nodes = new StringBuffer("Nodes: ");
        INode<K> tempNode = head;
        while (tempNode.getNext() != null){
            nodes.append(tempNode.getKey());
            if (!tempNode.equals(tail)){
                nodes.append("->");
            }
            tempNode = tempNode.getNext();
        }
        nodes.append(tempNode.getKey());
        System.out.println(nodes);
    }

    @Override
    public String toString(){
        return "LinkedListNodes{" + head + "}";
    }
}