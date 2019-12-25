package linear_structure;

public interface List {
    public int size();

    public Object get(int i);

    public boolean isEmpty();

    public boolean contains(Object e);

    public int indexOf(Object e);

    public void add(Object e);

    public void add(int i, Object e);

    //insert e before obj
    public boolean addBefore(Object obj, Object e);

    //insert e after obj
    public boolean addAfter(Object obj,Object e);

    //delete index i and return it
    public Object remove(int i);

    public boolean remove(Object e);

    //Replace the element on index i with e
    public Object replace(int i,Object e);
}
