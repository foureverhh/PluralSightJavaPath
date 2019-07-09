public class Product
{
    private String name;
    private int size;

    public Product(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "Product{"+"name='"+name+"\'"+", size='"+size+"\'}";
    }
}
