package before_refactor;

import com.opencsv.CSVReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;




public class CsvSalesRepository implements SalesRepository {
    private final String fileLocation;
    private PrintStream error;
    private List<Sale> sales;

    public CsvSalesRepository(String fileLocation){
        this.fileLocation = fileLocation;
        error = System.out;
    }

    public void setError(PrintStream error){
        this.error = error;
    }

    public List<Sale> loadSales(){
        if(sales == null){
            sales = new ArrayList<>();
            try(CSVReader reader = new CSVReader(new FileReader(fileLocation))) {
                String[] nextLine;
                while(((nextLine = reader.readNext()) != null)){
                    String product = nextLine[0].trim();
                    String store = nextLine[1].trim();
                    int number = Integer.parseInt(nextLine[2].trim());
                    int productNumber = Integer.parseInt(nextLine[3].trim());
                    Sale sale = new Sale(product,store,number, productNumber);
                    sales.add(sale);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return sales;
    }
}
