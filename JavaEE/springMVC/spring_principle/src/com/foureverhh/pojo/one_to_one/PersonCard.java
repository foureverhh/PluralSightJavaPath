package com.foureverhh.pojo.one_to_one;

import java.io.Serializable;
import java.util.Objects;

public class PersonCard implements Serializable {
    private static final long serialVersionUId = 2L;
    private int id;
    private String name;
    private String cardNo;
    private String address;
    //关系属性，一个身份证属于一个人
    private Person person;
    private int personId;

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PersonCard)) return false;
        PersonCard that = (PersonCard) o;
        return getId() == that.getId() &&
                Objects.equals(getName(), that.getName()) &&
                Objects.equals(getCardNo(), that.getCardNo()) &&
                Objects.equals(getAddress(), that.getAddress()) &&
                Objects.equals(getPerson(), that.getPerson());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getCardNo(), getAddress(), getPerson());
    }

    @Override
    public String toString() {
        return "PersonCard{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cardNo='" + cardNo + '\'' +
                ", address='" + address +
                '}';
    }
}
