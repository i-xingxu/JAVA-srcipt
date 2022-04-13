package bjsxt.lianbiao;

public class MyDoublyLinkedList<E> implements MyList<E> {


    /**
     * 定义双节点对象
     */
    class Node<E> {
        E item;
        Node<E> prev;
        Node<E> next;

        Node(Node<E> prev, E item, Node<E> next) {
            this.prev = prev;
            this.next = next;
            this.item = item;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    @Override
    public void add(E element) {
        this.linkLast(element);
    }

    //将节点对象添加到双向链表的尾部
    private void linkLast(E element) {
        Node t = this.tail;
        Node<E> node = new Node<>(t, element, null);
        this.tail = node;//将新节点定义为尾节点
        if (t == null) {
            this.head = node;
        } else {
            t.next = node;
        }
        this.size++;
    }

    @Override
    public E get(int index) {
        this.checkIndex(index);
        Node<E> node = this.getNode(index);

        return node.item;
    }

    //校验index
    private void checkIndex(int index) {
        if (!((index >= 0) && (index < this.size))) {
            throw new IndexOutOfBoundsException("Index:" + index);
        }
    }

    //获取指定节点对象
    private Node getNode(int index) {
        if (index < (this.size >> 1)) {
            Node node = this.head;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            return node;
        } else {
            Node node = this.tail;
            for (int i = 0; i < this.size - index - 1; i++) {
                node = node.prev;
            }
            return node;
        }
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public E remove(int index) {
        this.checkIndex(index);
        Node<E> node = this.getNode(index);
        E item = node.item;
        if (node.prev == null) {
            this.head = node.next;
        } else {
            node.prev.next = node.next;
        }
        if (node.next == null) {
            this.tail = node.prev;
        } else {
            node.next.prev = node.prev;
        }
        node.prev = null;
        node.next = null;
        node.item = null;
        this.size--;
        return item;
    }

    //在双链表头添加元素
    public void addFirst(E element) {
        this.linkFirst(element);
    }

    private void linkFirst(E element) {
        Node head = this.head;
        Node node = new Node(null, element, head);
        if (head == null) {
            this.tail = null;
        } else {
            head.prev = node;
        }
        this.head = node;
        this.size++;
    }

    public void addLast(E element) {
        this.linkLast(element);
    }

    public static void main(String[] args) {
        MySinglyLinkedList<String> mySinglyLinkedList= new MySinglyLinkedList<>();
        mySinglyLinkedList.add("a");
        mySinglyLinkedList.add("b");
        mySinglyLinkedList.add("c");
        System.out.println(mySinglyLinkedList.remove(1));

        MyDoublyLinkedList<String> myDoublyLinkedList = new MyDoublyLinkedList<>();
        myDoublyLinkedList.add("a");
        myDoublyLinkedList.addFirst("1");
        myDoublyLinkedList.addLast("2");
        for (int i = 0; i < myDoublyLinkedList.size(); i++) {
            System.out.println(myDoublyLinkedList.get(i));

        }

    }
}
