package za.ac.cput.factory;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.impl.Address;

import static org.junit.jupiter.api.Assertions.*;

class AddressFactoryTest {

    @Test
    void AddressFactoryTest(){

        AddressFactory addressFactory = new AddressFactory();
        Address address = addressFactory.createAddress("8461", "Adderlly", "Gardens", "Cape Town", 7896);
        Address newAddress = addressFactory.createAddress("923", "Ndzelelo", "Khayelitsha", "Cape Town", 8100);

        Assertions.assertNotNull(address);
        Assertions.assertNotEquals(address, newAddress);

    }

}