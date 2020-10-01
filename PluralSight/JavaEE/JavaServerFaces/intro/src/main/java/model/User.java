package model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    @Pattern(regexp="[A-Za-z0-9]{2,20}", message = "Please enter your username consist of only letters" )
    private String username;
    @Size(min = 8, message = "Your password must consist of at least ")
    private String password;
    @Size(min = 1, max = 30, message = "Please enter a first name between 1 and 30 characters long.")
    private String firstName;
    @Size(min = 1, max = 30, message = "Please enter a last name between 1 and 30 characters long.")
    private String lastName;
    //@ValidEmailAddress
    private String emailAddress;
    //@ValidPhoneNumber
    private PhoneNumber phoneNumber;
    @Past(message = "Yout birth date must be in the past")
    private Date birthDate;
    @NotNull (message = "Please indicate if you want to subscribe to the newsletter or not.")
    private boolean subscribedToNewsletter;

    public User() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(PhoneNumber phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isSubscribedToNewsletter() {
        return subscribedToNewsletter;
    }

    public void setSubscribedToNewsletter(boolean subscribedToNewsletter) {
        this.subscribedToNewsletter = subscribedToNewsletter;
    }
}
