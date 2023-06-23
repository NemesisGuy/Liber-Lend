package za.ac.cput.factory;

import za.ac.cput.domain.impl.Address;
import za.ac.cput.domain.impl.Branch;
import za.ac.cput.domain.impl.Contacts;

import java.util.List;
import java.util.Random;

public class BranchFactory implements IFactory<Branch>{
    @Override
    public Branch create() {
        return new Branch.Builder().build();
    }

    @Override
    public Branch getById(long id) {
        return null;
    }

    @Override
    public Branch update(Branch entity) {
        return null;
    }

    @Override
    public boolean delete(Branch entity) {
        return false;
    }

    @Override
    public List<Branch> getAll() {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public Class<Branch> getType() {
        return null;
    }

    public static Branch createBranch(String name, Contacts contacts, Address address, String availableItems){
        return new Branch.Builder()
                .setId(new Random().nextInt())
                .setName(name)
                .setContacts(contacts)
                .setAddress(address)
                .setAvailableItems(availableItems)
                .build();
    }
}
