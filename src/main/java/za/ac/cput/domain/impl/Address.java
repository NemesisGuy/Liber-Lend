package za.ac.cput.domain.impl;
/**
 * Address.java
 * Class for Address.
 * Author: Cwenga Dlova(214310671)
 * Date: 19 March 2023
 */

import java.util.Objects;

public class Address {

    private int id;
    private String strNo;
    private String strName;
    private String suburb;
    private String city;
    private long postalCode;

    public Address() {
    }

    public int getId() {
        return id;
    }

    public String getStrNo() {
        return strNo;
    }

    public String getStrName() {
        return strName;
    }

    public String getSuburb() {
        return suburb;
    }

    public String getCity() {
        return city;
    }

    public long getPostalCode() {
        return postalCode;
    }

    public Address(Address.Builder builder) {

        this.id = builder.id;
        this.strNo = builder.strNo;
        this.strName = builder.strName;
        this.suburb = builder.suburb;
        this.city = builder.city;
        this.postalCode = builder.postalCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return id == address.id && postalCode == address.postalCode && Objects.equals(strNo, address.strNo) && Objects.equals(strName, address.strName) && Objects.equals(suburb, address.suburb) && Objects.equals(city, address.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, strNo, strName, suburb, city, postalCode);
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", strNo='" + strNo + '\'' +
                ", strName='" + strName + '\'' +
                ", suburb='" + suburb + '\'' +
                ", city='" + city + '\'' +
                ", postalCode=" + postalCode +
                '}';
    }

    public static class Builder {
        private int id;
        private String strNo;
        private String strName;
        private String suburb;
        private String city;
        private long postalCode;

        public Builder setId(int id) {
            this.id = id;
            return this;
        }

        public Builder setStrNo(String strNo) {
            this.strNo = strNo;
            return this;
        }

        public Builder setStrName(String strName) {
            this.strName = strName;
            return this;
        }

        public Builder setSuburb(String suburb) {
            this.suburb = suburb;
            return this;
        }

        public Builder setCity(String city) {
            this.city = city;
            return this;
        }

        public Builder setPostalCode(long postalCode) {
            this.postalCode = postalCode;
            return this;
        }

        public Address.Builder copy(Address address) {

            this.id = address.id;
            this.strNo = address.strNo;
            this.strName = address.strName;
            this.suburb = address.suburb;
            this.city = address.city;
            this.postalCode = address.postalCode;

            return this;
        }
        public Address build() {
            return new Address(this);
        }
    }

}
