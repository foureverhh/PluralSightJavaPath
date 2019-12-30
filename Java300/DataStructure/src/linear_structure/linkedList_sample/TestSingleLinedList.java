package linear_structure.linkedList_sample;

import linear_structure.List;

public class TestSingleLinedList {
    public static void main(String[] args) {

        List list = new SingleLinkedList();
        list.add(123);
        list.add(321);
        list.add(456);
        list.add(678);
        list.add(789);
        list.add(111);
        list.add(222);

        list.add(5,666);
        System.out.println(list.size());
        System.out.println(list.isEmpty());
        System.out.println(list.get(3));
        System.out.println(list);
        System.out.println(list.remove(1));
        System.out.println(list);
    }
}
