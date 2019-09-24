package product.pack;

public class ProductFixtures {
    public static Product door = new Product(20,"Window Door",35);
    public static Product floorPanel = new Product(25,"Floor Panel");
    public static Product window = new Product(11,"Glass Window",10);

    public static Supplier bobs = new Supplier("Bob's HouseHold Supplies");
    public static Supplier kates = new Supplier("Kate's Home goods");

    /*
    static {
        bobs.products().add(door);
        bobs.products().add(floorPanel);

        kates.products().add(floorPanel);
        kates.products().add(new Product("Wooden Door",35));
        // new Product
    }
     */

}
