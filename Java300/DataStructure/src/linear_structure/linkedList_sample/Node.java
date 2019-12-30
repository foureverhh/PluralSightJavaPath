package linear_structure.linkedList_sample;

/*
 * 单链表节点
 *
 * */
public class Node {
    //private Object data;//the data stored in this node
    //private  Node next; //the node after this node

    Object data;//the data stored in this node
    Node next; //the node after this node

    public Node() {
    }

    public Node(Object data) {
        super();
        this.data = data;
    }

    public Node(Node next,Object data) {
        this.data = data;
        this.next = next;
    }

    public Node(Object data, Node next) {
        this.data = data;
        this.next = next;
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
