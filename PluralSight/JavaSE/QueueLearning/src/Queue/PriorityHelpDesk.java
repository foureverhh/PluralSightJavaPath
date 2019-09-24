package Queue;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityHelpDesk {

    //To make the queue as the order of Category
    public static final Comparator<Enquiry> BY_CATEGORY_ALSO = Comparator.comparing(Enquiry::getCategory) ;
    public static final Comparator<Enquiry> BY_CATEGORY = new Comparator<Enquiry>() {

        @Override
        public int compare(Enquiry o1, Enquiry o2) {
            return o1.getCategory().compareTo(o2.getCategory());
        }
    };
    private Queue<Enquiry> enquiries = new PriorityQueue<>(BY_CATEGORY_ALSO);
    //private Queue<Enquiry> enquiries = new ArrayDeque<>();

    public void enquire(Customer customer, Category category){
        enquiries.offer(new Enquiry(customer,category));
    }

    public void processAllEnquires(){
        Enquiry enquiry;
        while((enquiry =enquiries.poll()) != null){
            enquiry.getCustomer().reply("Have you tried turning it off and on again?");
        }
    }


}
