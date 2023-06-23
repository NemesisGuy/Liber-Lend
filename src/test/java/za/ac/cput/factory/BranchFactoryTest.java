package za.ac.cput.factory;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.impl.Branch;

import static org.junit.jupiter.api.Assertions.*;

class BranchFactoryTest {

    @Test
    void testBranchFactory() {

        BranchFactory branchFactory= new BranchFactory();
        Branch branch = branchFactory.create();

        Assertions.assertNotNull(branch);
        Assertions.assertNotNull(branch.getId());
    }

}