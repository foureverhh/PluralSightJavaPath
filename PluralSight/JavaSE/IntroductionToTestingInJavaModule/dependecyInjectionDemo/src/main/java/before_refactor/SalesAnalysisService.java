package before_refactor;

import java.util.Map;
import java.util.function.Function;

public class SalesAnalysisService {
    //private final String fileLocation;
    private final SalesRepository repo;

    public SalesAnalysisService(SalesRepository repo){//(String fileLocation){
        //this.fileLocation = fileLocation;
        this.repo = repo;
    }

    public Map<String,Integer> tallyProductSales(){
        return tallySalesBy(Sale::getProduct);
    }

    public Map<String,Integer> tallyStoreSales(){
        return tallySalesBy(Sale::getStore);
    }

    private Map<String,Integer> tallySalesBy(Function<Sale, String> classifier){
        //CsvSalesRepository repo = new CsvSalesRepository(fileLocation);
        return repo.loadSales()
                .stream()
                .collect(groupingBy(classifier,
                        summingInt(Sale::getValue)));
    }
}
