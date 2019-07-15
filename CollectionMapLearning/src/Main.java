public class Main {

    public static void main(String[] args) {
        LookupTableComparison comparison = new LookupTableComparison();
        comparison.runLookups(new NaiveProductLookupTable());
        comparison.runLookups(new MapProductLookupTable());
    }
}
