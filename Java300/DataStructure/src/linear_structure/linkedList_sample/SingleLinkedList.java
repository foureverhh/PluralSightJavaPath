package linear_structure.linkedList_sample;

import linear_structure.List;

public class SingleLinkedList implements List {

    private Node head = new Node(); //Head node, not for storing data, but for convenience
    private int size; //counter of nodes

    @Override
    public int size() {
        return size;
    }

    @Override
    public Object get(int i) {
        if(size == 0)
            return null;
        Node node = head.next;
        int j = 0;
        while (j++ < i){
            node = node.next;
        }
        return node.data;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object e) {
        return false;
    }

    @Override
    public int indexOf(Object e) {
        return 0;
    }

    @Override
    public void add(Object e) {
        this.add(size,e);
    }

    @Override
    public void add(int i, Object e) {
        //Find the last node to i, that is i-1 node
        Node currentNode = head;
        for (int j = 0; j < i ; j++) {
            currentNode = currentNode.next;
        }
        //a new node
        Node newNode = new Node(e);

        //node.next
        newNode.next = currentNode.next;

        //node.last
        currentNode.next = newNode ;

        //Size++
        size++;
    }

    @Override
    public boolean addBefore(Object obj, Object e) {
        return false;
    }

    @Override
    public boolean addAfter(Object obj, Object e) {
        return false;
    }

    @Override
    public Object remove(int i) {
        if(size == 0)
            return null;
        Node p = head;
        Node target = null;
        int j = 0;
        while (j++ < i) {
            System.out.println("j->" + j);
            p = p.next;
        }

        target = p.next;
        p.next = p.next.next;
        size--;
        return target;
    }

    @Override
    public boolean remove(Object e) {
        return false;
    }

    @Override
    public Object replace(int i, Object e) {
        return null;
    }

    @Override
    public String toString() {
        if(size == 0)
            return "[]";
        StringBuilder sb = new StringBuilder("[ ");
        Node node = head;
        for (int i = 0; i < size; i++) {
            node = node.next;
            if(i != size -1)
                sb.append(node.data + " , ");
            else
                sb.append(node.data);
        }
        sb.append(" ]");
        return sb.toString();
    }
}
