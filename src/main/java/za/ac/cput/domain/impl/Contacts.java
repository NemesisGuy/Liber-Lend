package za.ac.cput.domain.impl;

/**
 * Contacts.java
 * Class for Contacts.
 * Author: Cwenga Dlova(214310671)
 * Date: 19 March 2023
 */

import java.util.Objects;

public class Contacts {

    private int id;
    private long homePhoneNumber;
    private long workPhoneNumber;
    private String emailAddress;

    public Contacts() {
    }

    public int getId() {
        return id;
    }

    public long getHomePhoneNumber() {
        return homePhoneNumber;
    }

    public long getWorkPhoneNumber() {
        return workPhoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public Contacts(Contacts.Builder builder) {

        this.id = builder.id;
        this.homePhoneNumber = builder.homePhoneNumber;
        this.workPhoneNumber = builder.workPhoneNumber;
        this.emailAddress = builder.emailAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contacts contacts = (Contacts) o;
        return id == contacts.id && homePhoneNumber == contacts.homePhoneNumber && workPhoneNumber == contacts.workPhoneNumber && Objects.equals(emailAddress, contacts.emailAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, homePhoneNumber, workPhoneNumber, emailAddress);
    }

    @Override
    public String toString() {
        return "Contacts{" +
                "id=" + id +
                ", homePhoneNumber=" + homePhoneNumber +
                ", workPhoneNumber=" + workPhoneNumber +
                ", emailAddress='" + emailAddress + '\'' +
                '}';
    }

    public static class Builder {
        private int id;
        private long homePhoneNumber;
        private long workPhoneNumber;
        private String emailAddress;


    public Builder setId(int id) {
        this.id = id;
        return this;
    }

    public Builder setHomePhoneNumber(long homePhoneNumber) {
        this.homePhoneNumber = homePhoneNumber;
        return this;
    }

    public Builder setWorkPhoneNumber(long workPhoneNumber) {
        this.workPhoneNumber = workPhoneNumber;
        return this;
    }

    public Builder setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
        return this;
    }

        public Contacts.Builder copy(Contacts contacts) {

            this.id = contacts.id;
            this.homePhoneNumber = contacts.homePhoneNumber;
            this.workPhoneNumber = contacts.workPhoneNumber;
            this.emailAddress = contacts.emailAddress;

            return this;
        }
        public Contacts build() {
            return new Contacts(this);
        }
    }
}
