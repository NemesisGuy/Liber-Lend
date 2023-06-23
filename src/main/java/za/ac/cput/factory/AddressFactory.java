package za.ac.cput.factory;

import za.ac.cput.domain.impl.Address;

import java.util.List;
import java.util.Random;

public class AddressFactory implements IFactory<Address>{


    @Override
    public Address create() {
        return new Address.Builder().build();
    }


    @Override
    public Address getById(long id) {
        return null;
    }

    @Override
    public Address update(Address entity) {
        return null;
    }

    @Override
    public boolean delete(Address entity) {
        return false;
    }

    @Override
    public List<Address> getAll() {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public Class<Address> getType() {
        return null;
    }

    public Address createAddress(String strNo, String strName, String suburb, String city, long postalCode){

        return new Address.Builder()
                .setId(new Random().nextInt())
                .setStrNo(strNo)
                .setStrName(strName)
                .setSuburb(suburb)
                .setCity(city)
                .setPostalCode(postalCode)
                .build();
    }
}
