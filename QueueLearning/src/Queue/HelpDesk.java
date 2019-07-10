package Queue;

import Queue.Customer;

import java.util.ArrayDeque;
import java.util.Queue;

public class HelpDesk {

    private Queue<Enquiry> enquiries = new ArrayDeque<>();

    public void enquire(Customer customer, Category category){
        enquiries.offer(new Enquiry(customer,category));
    }

    public void processAllEnquiries(){
        Enquiry enquiry = enquiries.remove();
        enquiry.getCustomer().reply("Have you tried turning it off and on again?");
    }
}
