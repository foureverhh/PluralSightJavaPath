@SuppressWarnings("deprecation")
public class MyWorker {

    void doSomeWork(){
        Doer doer = new Doer("doer");
        doer.doItThisWay();
    }

    void  doDoubleWork(){
        Doer d1 = new Doer("d1");
        Doer d2 = new Doer("d2");
        d1.doItThisWay();
        d2.doItThisWay();
    }
}
