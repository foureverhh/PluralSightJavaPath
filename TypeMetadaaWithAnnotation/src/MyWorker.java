//@SuppressWarnings("deprecation")
public class MyWorker {

    @SuppressWarnings("deprecation")
    void doSomeWork(){
        Doer doer = new Doer("doer");
        doer.doItThisWay();
    }

    @SuppressWarnings("deprecation")
    void  doDoubleWork(){
        Doer d1 = new Doer("d1");
        Doer d2 = new Doer("d2");
        d1.doItThisWay();
        d2.doItThisWay();
    }
}
