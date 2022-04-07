package bjsxt.lianbiao;

/**
 * 基于链表结构存取元素的接口
 * @param <E>
 */
public interface MyList <E>{
    void add(E element);
    E get(int index);
    int size();
    E remove(int index);
}
