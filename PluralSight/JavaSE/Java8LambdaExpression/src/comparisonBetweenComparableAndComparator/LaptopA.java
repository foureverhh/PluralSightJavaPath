package comparisonBetweenComparableAndComparator;

public class LaptopA implements Comparable<LaptopA>{
    private String brand;
    private int ram;
    private int price;

    public LaptopA() {
    }

    public LaptopA(String brand, int ram, int price) {
        this.brand = brand;
        this.ram = ram;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public int compareTo(LaptopA laptopA2) {
        //return Integer.compare(this.price,o.price);
        //return this.getBrand().compareTo(o.getBrand());
        return -(this.ram - laptopA2.getRam());
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "brand='" + brand + '\'' +
                ", ram=" + ram +
                ", price=" + price +
                '}';
    }
}
