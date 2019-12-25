package linear_structure;

public class TestArrayList {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        System.out.println("Size: " + list.size());
        list.add(2,"Element3");
        //System.out.println(list.get(8));
 /*       list.add(1,"Element 6");
        System.out.println(list.size());*/
        System.out.println(list);



/*        String[] arr1 = new String[2];
        arr1[0] = "0";
        arr1[1] = "1";
        String[] arr2 = Arrays.copyOf(arr1,arr1.length * 2);
        arr2[0] = "arr2_0";
        System.out.println(arr1[0] + " " + arr2[0]);
        String[] arr3 = new String[6];
        System.arraycopy(arr1,0,arr3,0,arr1.length);
        arr3[0] = "arr3";
        System.out.println(arr1[0] + " " + arr3[0]);*/

    }
}
