package za.ac.cput.service;

import za.ac.cput.domain.impl.Branch;
import za.ac.cput.domain.impl.Librarian;

import java.util.List;

public interface IBranchService {

    Branch create(Branch branch);

    Branch update(Branch branch);
    boolean delete(Integer id);
    List<Branch> getAll();
}
