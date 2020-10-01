package checkoutFlow;

import javax.faces.flow.FlowScoped;
import javax.inject.Named;
import javax.validation.constraints.Size;
import java.io.Serializable;
/*properties for all pages on checkout flow*/
@Named
@FlowScoped("checkout")
public class Checkout implements Serializable {
    private static final long serialVersionUID = 1L;
    @Size(min = 1, max = 30, message = "Please enter a name")
    private String shippingName;
    private boolean paymentSuccess;

    public void fulfillOrder(){

    }

    public boolean isPaymentSuccess() {
        return paymentSuccess;
    }

    public void setPaymentSuccess(boolean paymentSuccess) {
        this.paymentSuccess = paymentSuccess;
    }

    public String getShippingName() {
        return shippingName;
    }

    public void setShippingName(String shippingName) {
        this.shippingName = shippingName;
    }
}
