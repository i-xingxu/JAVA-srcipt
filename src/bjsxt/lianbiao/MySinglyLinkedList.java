package bjsxt.lianbiao;

public class MySinglyLinkedList<E> implements MyList<E> {

    class Node<E> {
        private E item;  //存储元素
        private Node next; //存储下一个节点对象的地址

        Node(E item, Node next) {
            this.item=item;
            this.next=next;
        }
    }

    private Node head;
    private int size;

    @Override
    public void add(E element) {
        //创建节点
        Node<E> node = new Node<E>(element, null);
        //找到尾节点
        Node tail = getTail();
        //节点的挂载
        if (tail == null) this.head = node;
        else tail.next = node;
        //记录元素个数
        this.size++;
    }

    @Override
    public E get(int index) {
        //校验index的合法性
        this.checkIndex(index);
        //根据index获取指定节点
        Node<E> node = this.getNode(index);
        //将该节点中的元素返回
        return node.item;
    }

    /*
    校验index
     */
    private void checkIndex(int index) {

        if (!(index >= 0 && index < this.size)) {
            throw new IndexOutOfBoundsException("IndexL" + index);
        }
    }

    /**
     * 根据位置获取节点
     *
     * @return
     */
    private Node getNode(int index) {
        Node<E> node = this.head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;


    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public E remove(int index) {

        //校验index的合法性
        this.checkIndex(index);
        //根据位置找到节点
        Node<E> node = this.getNode(index);
        //获取该节点中的元素
        E item = node.item;
        //删除
        //判断当前删除的节点是否为头节点
        if (this.head == node) {
            this.head = node.next;
        } else {
            Node<E> temp = this.head;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            temp.next = node.next;
        }
        node.next = null;
        //size--
        this.size--;
        //返回
        return item;
    }

    private Node getTail() {
        if (this.head == null) {
            return null;
        }
        Node node = this.head;
        while (true) {
            if (node.next == null) {
                break;
            }
            node = node.next;//移动指针，指向下一个节点
        }
        return node;
    }

    public static void main(String[] args) {
        MySinglyLinkedList<String> mySinglyLinkedList = new MySinglyLinkedList<String>();
        mySinglyLinkedList.add("a");
        mySinglyLinkedList.add("b");
        mySinglyLinkedList.add("c");
        mySinglyLinkedList.add("d");
        System.out.println(mySinglyLinkedList.size);
        System.out.println(mySinglyLinkedList.get(1));
        System.out.println(mySinglyLinkedList.remove(1));
        System.out.println(mySinglyLinkedList.size);
    }
}
