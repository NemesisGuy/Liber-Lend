package za.ac.cput.domain.impl;

/**
 * Branch.java
 * Class for Branch
 * Author: Cwenga Dlova(214310671)
 * Date: 19 March 2023
 */

import java.util.Objects;

public class Branch {

    private int id;
    private String name;
    private Contacts contacts;
    private Address address;
    private String availableItems;

    public Branch() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Contacts getContacts() {
        return contacts;
    }

    public Address getAddress() {
        return address;
    }

    public String getAvailableItems() {
        return availableItems;
    }

    public Branch(Builder builder) {

        this.id = builder.id;
        this.name = builder.name;
        this.contacts = builder.contacts;
        this.address = builder.address;
        this.availableItems = builder.availableItems;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Branch branch = (Branch) o;
        return id == branch.id && Objects.equals(name, branch.name) && Objects.equals(contacts, branch.contacts) && Objects.equals(address, branch.address) && Objects.equals(availableItems, branch.availableItems);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, contacts, address, availableItems);
    }

    @Override
    public String toString() {
        return "Branch{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", contacts=" + contacts +
                ", address=" + address +
                ", availableItems='" + availableItems + '\'' +
                '}';
    }

    public static class Builder {
        private int id;
        private String name;
        private Contacts contacts;
        private Address address;
        private String availableItems;

        public Builder setId(int id) {
            this.id = id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setContacts(Contacts contacts) {
            this.contacts = contacts;
            return this;
        }
        public Builder setAddress(Address address) {
            this.address = address;
            return this;
        }

        public Builder setAvailableItems(String availableItems) {
            this.availableItems = availableItems;
            return this;
        }
        public Builder copy(Branch branch) {

            this.id = branch.id;
            this.name = branch.name;
             this.contacts = branch.contacts;
             this.address = branch.address;
            this.availableItems = branch.availableItems;

            return this;
        }
        public Branch build() {
            return new Branch(this);
        }
    }
}
