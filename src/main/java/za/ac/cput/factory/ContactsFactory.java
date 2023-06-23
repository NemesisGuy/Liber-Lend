package za.ac.cput.factory;

import za.ac.cput.domain.impl.Contacts;

import java.util.List;
import java.util.Random;

public class ContactsFactory implements IFactory<Contacts>{


    @Override
    public Contacts create() {
        return new Contacts.Builder().build();
    }

    public Contacts createContacts( long homePhoneNumber, long workPhoneNumber, String emailAddress) {
        return new Contacts.Builder()
                .setId(new Random().nextInt())
                .setHomePhoneNumber(homePhoneNumber)
                .setWorkPhoneNumber(workPhoneNumber)
                .setEmailAddress(emailAddress)
                .build();
    }

    @Override
    public Contacts getById(long id) {
        return null;
    }

    @Override
    public Contacts update(Contacts entity) {
        return null;
    }

    @Override
    public boolean delete(Contacts entity) {
        return false;
    }

    @Override
    public List<Contacts> getAll() {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public Class<Contacts> getType() {
        return null;
    }
}
