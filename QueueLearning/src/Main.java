import Queue.Category;
import Queue.Customer;
import Queue.HelpDesk;

public class Main {

    public static void main(String[] args) {
        HelpDesk helpDesk = new HelpDesk();

        helpDesk.enquire(Customer.JACK, Category.PHONE);
        helpDesk.enquire(Customer.JILL, Category.PRINTER);

        helpDesk.processAllEnquiries();
    }
}
