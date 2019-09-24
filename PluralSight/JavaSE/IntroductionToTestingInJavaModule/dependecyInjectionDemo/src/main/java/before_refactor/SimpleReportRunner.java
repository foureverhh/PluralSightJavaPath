package before_refactor;

public class SimpleReportRunner {
    public static void main(String[] args) {

        if(args.length<1){
            System.err.println("You must provide a commandline argument specifying the file to analyse");
            System.exit(-1);
        }
        CsvSalesRepository repo = new CsvSalesRepository(args[0]);
        repo.setError(System.err);

        final SalesAnalysisService analyser = new SalesAnalysisService(repo);
        SalesReport report = new SalesReport(System.out, analyser);
        report.report();
    }
}
