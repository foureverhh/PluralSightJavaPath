import java.util.Comparator;
import java.util.Objects;


public class Product
{

    public static final Comparator<Product> BY_NAME = Comparator.comparing(Product::getName);

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

    public Product() {

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return size == product.size &&
                Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, size);
    }
}


