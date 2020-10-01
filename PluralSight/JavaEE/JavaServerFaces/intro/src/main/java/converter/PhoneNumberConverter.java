package converter;

import model.PhoneNumber;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import java.util.regex.Pattern;

@FacesConverter(value = "phoneNumberConverter")
//@FacesConverter(forClass = PhoneNumber.class)
public class PhoneNumberConverter implements Converter {
    private static final Pattern PHONE_NUMBER_PATTERN = Pattern.compile("[0-9]{3}-[0-9]{3}-[0-9]{4}");

    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        if( s  == null || s.equals("")){
            return null;
        }
        if( !PHONE_NUMBER_PATTERN.matcher(s).matches()){
            throw new ConverterException(new FacesMessage("Please enter a valid phone number" +
                    "of the form:800-555-1234"));
        }

        PhoneNumber phoneNumber = new PhoneNumber();
        phoneNumber.setAreaCode(s.substring(0,3));
        phoneNumber.setOfficeCode(s.substring(4,7));
        phoneNumber.setSubscriberNumber(s.substring(8));
        return phoneNumber;
    }

    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        PhoneNumber phoneNumber = (PhoneNumber) o;
        return phoneNumber.getAreaCode() +
                "-" +
                phoneNumber.getOfficeCode() +
                "-" +
                phoneNumber.getSubscriberNumber();
    }
}
