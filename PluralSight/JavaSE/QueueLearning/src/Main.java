import Queue.*;

public class Main {

    public static void main(String[] args) {
        /*
        HelpDesk helpDesk = new HelpDesk();

        helpDesk.enquire(Customer.JACK, Category.PHONE);
        helpDesk.enquire(Customer.JILL, Category.PRINTER);

        helpDesk.processAllEnquiries();
        */

        /*
        CategorisedHelpDesk categorisedHelpDesk = new CategorisedHelpDesk();
        categorisedHelpDesk.enquire(Customer.JACK, Category.PHONE);
        categorisedHelpDesk.enquire(Customer.JILL, Category.PRINTER);

        categorisedHelpDesk.processPrinterEnquiry();
        categorisedHelpDesk.processGeneralEnquiry();
        categorisedHelpDesk.processPrinterEnquiry();
        */

        PriorityHelpDesk priorityHelpDesk = new PriorityHelpDesk();
        priorityHelpDesk.enquire(Customer.JACK,Category.PHONE);
        priorityHelpDesk.enquire(Customer.JILL,Category.PRINTER);
        priorityHelpDesk.enquire(Customer.MARY,Category.COMPUTER);

        priorityHelpDesk.processAllEnquires();
    }


}
