import java.util.Comparator;

public class Product
{

    //public static final Comparator<Product> BY_SIZE = Comparator.comparing(Product::getSize);
    public static final Comparator<Product> BY_SIZE = new Comparator<Product>() {
        @Override
        public int compare(Product o1, Product o2) {
            return Integer.compare(o1.getSize(), o1.getSize());
        }
    };



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
