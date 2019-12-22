package comparisonBetweenComparableAndComparator;

public class LaptopB implements Comparable<LaptopB>{
    private String brand;
    private int ram;
    private int price;

    public LaptopB() {
    }

    public LaptopB(String brand, int ram, int price) {
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
    public String toString() {
        return "Laptop{" +
                "brand='" + brand + '\'' +
                ", ram=" + ram +
                ", price=" + price +
                '}';
    }

    @Override
    public int compareTo(LaptopB laptopB2) {

        //return Integer.compare(this.price,laptopB2.price);
        //return this.getBrand().compareTo(laptopB2.getBrand());
        return -(this.ram - laptopB2.getRam());
    }
}
