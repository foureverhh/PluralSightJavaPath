package Queue;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.function.Predicate;

import static Queue.Category.PRINTER;

public class CategorisedHelpDesk {
    private Queue<Enquiry> enquiries = new ArrayDeque<>();
    final String MESSAGE = "Have you tried turning off and on again?";

    public boolean enquire(Customer customer, Category category){
        return enquiries.offer(new Enquiry(customer,category));
    }

    public void processAllEnquiries(){
        Enquiry enquiry;
        while ((enquiry = enquiries.poll())!=null){
            enquiry.getCustomer().reply(MESSAGE);
        }
    }

    public void processEnquiry(Predicate predicate, String message){
        Enquiry enquiry = enquiries.peek();
        if(enquiry != null && predicate.test(enquiry)){
            enquiries.remove();
            System.out.println(message);
        }else {
            System.out.println("No work to do, let's have some coffee!");
        }
    }

    public void processPrinterEnquiry(){
       Predicate<Enquiry> predicate = enquiry -> enquiry.getCategory() == PRINTER;
       final String MESSAGE = "Is it out of paper?" ;
       //Enquiry enquiry = enquiries.peek();
       //if(enquiry != null && enquiry.getCategory() == PRINTER)
       /* if(enquiry !=null && predicate.test(enquiry))
       {
           enquiries.remove();
           enquiry.getCustomer().reply("Is it out of Paper?");
       }else {
           System.out.println("No work to do, let's have some coffee!");
       }
        */
       processEnquiry(predicate,MESSAGE);
    }

    public void processGeneralEnquiry(){
        Predicate<Enquiry> predicate = enquiry -> enquiry.getCategory() != PRINTER;
        Enquiry enquiry = enquiries.peek();
        processEnquiry(predicate,MESSAGE);
        //if(enquiry != null && enquiry.getCategory() != PRINTER)
        /*
        if(enquiry !=null && predicate.test(enquiry))
        {
            enquiries.remove();
            enquiry.getCustomer().reply("Have you tried turning off and on again?");
        }else {
            System.out.println("No work to do, let's have some coffee!");
        }
        */
    }

}
