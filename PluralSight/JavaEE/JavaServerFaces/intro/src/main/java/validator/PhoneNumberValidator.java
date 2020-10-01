package validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.util.regex.Pattern;

@FacesValidator(value = "validator.phoneNumberValidator")
public class PhoneNumberValidator implements Validator {
    private static final Pattern PHONE_NUMBER_PATTERN = Pattern.compile("[0-9]{3}-[0-9]{3}-[0-9]{4}");
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
        String number = (String) o;
        if(number != null && !number.equals("")){
            checkPattern(number);
            checkAreaCode(number.substring(0,3));
            checkOfficeCode(number.substring(4,7));
        }
    }

    private void checkPattern(String number) {
        if(!PHONE_NUMBER_PATTERN.matcher(number).matches()){
            throw new ValidatorException(new FacesMessage("Please enter a valid phone number"));
        }
    }

    private void checkAreaCode(String substring) {
        if(!PHONE_NUMBER_PATTERN.matcher(substring).matches()){
            throw new ValidatorException(new FacesMessage("Please enter a valid phone number"));
        }
    }


    private void checkOfficeCode(String number){
        if(!PHONE_NUMBER_PATTERN.matcher(number).matches()){
            throw new ValidatorException(new FacesMessage("Please enter a valid phone number"));
        }
    }
}
