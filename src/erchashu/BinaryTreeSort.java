package erchashu;

//二叉树排序
public class BinaryTreeSort<E extends Integer> {

    //定义节点类
    class Node<E extends Integer> {
        private E item;//存放元素
        private Node left;
        private Node right;

        Node(E item) {
            this.item = item;
        }

        //添加节点
        public void addNode(Node node) {
            //判断新节点的元素与当前节点元素的判断
            //如果新节点元素小于当前节点元素，那么放在当前节点左子树
            if (node.item.intValue() < this.item.intValue()) {
                if (this.left == null) this.left = node;
                else this.left.addNode(node);
            } else {
                if (this.right == null) this.right = node;
                else this.right.addNode(node);
            }
        }

        //使用中序遍历
        public void inorderTraversal() {

            //找到最左侧节点
            if (this.left != null) this.left.inorderTraversal();
            System.out.println(this.item);
            if (this.right != null) this.right.inorderTraversal();

        }
    }

    private Node root;//存放树的根节点地址


    //将元素添加到排序器中
    public void add(E element) {
        Node<E> node = new Node<>(element);
        //判断当前二叉树是否有根节点
        if (this.root == null) {
            this.root = node;
        } else {
            this.root.addNode(node);
        }
    }

    //对元素排序
    public void sort() {
        //判断根节点是否为空
        if (this.root == null) return;
        this.root.inorderTraversal();
    }

    public static void main(String[] args) {
        BinaryTreeSort<Integer> sort = new BinaryTreeSort<>();
        sort.add(1);
        sort.add(3);
        sort.add(2);
        sort.add(10);
        sort.add(7);
        sort.sort();
    }
}
