package za.ac.cput.domain.impl;

/**
 * Librarian.java
 * Class for Librarian.
 * Author: Cwenga Dlova(214310671)
 * Date: 19 March 2023
 */
public class Librarian  {

    private int id;
    private String firstName;
    private String lastName;
    private Contacts contacts;
    private String office;
    private String role;


    public Librarian() {
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Contacts getContacts() {
        return contacts;
    }

    public String getOffice() {
        return office;
    }

    public String getRole() {
        return role;
    }

    public Librarian(Builder builder) {
        this.id = builder.id;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.contacts = builder.contacts;
        this.office = builder.office;
        this.role = builder.role;
    }

    @Override
    public String toString() {
        return "Librarian{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", contacts=" + contacts +
                ", office='" + office + '\'' +
                ", role='" + role + '\'' +
                '}';
    }

    public static class Builder {
        private int id;
        private String firstName;
        private String lastName;
        private Contacts contacts;
        private String office;
        private String role;

        public Builder setId(int id) {
            this.id = id;
            return this;
        }

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder setContacts(Contacts contacts) {
            this.contacts = contacts;
            return this;
        }

        public Builder setOffice(String office) {
            this.office = office;
            return this;
        }

        public Builder setRole(String role) {
            this.role = role;
            return this;
        }

        public Builder copy(Librarian librarian) {
            this.id = librarian.id;
            this.firstName = librarian.firstName;
            this.lastName = librarian.lastName;
            this.contacts = librarian.contacts;
            this.office = librarian.office;
            this.role = librarian.role;

            return this;
        }

        public Librarian build() {

            return new Librarian(this);
        }
    }
}
