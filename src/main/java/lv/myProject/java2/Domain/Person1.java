package lv.myProject.java2.Domain;

import javafx.beans.property.SimpleStringProperty;

import java.util.Objects;

public class Person1 {

        String firstName;
        String lastName;
        String personCode;
        String email;
        String phoneNumber;
        Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getPersonCode() {
        return personCode;
    }

    public void setPersonCode(String personCode) {
        this.personCode = personCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person1 person1 = (Person1) o;
        return Objects.equals(firstName, person1.firstName) &&
                Objects.equals(lastName, person1.lastName) &&
                Objects.equals(personCode, person1.personCode) &&
                Objects.equals(email, person1.email) &&
                Objects.equals(phoneNumber, person1.phoneNumber);
    }

    @Override
    public int hashCode() {

        return Objects.hash(firstName, lastName, personCode, email, phoneNumber);
    }
}
