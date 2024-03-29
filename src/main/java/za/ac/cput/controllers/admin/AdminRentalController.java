package za.ac.cput.controllers.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.impl.Rental;
import za.ac.cput.service.impl.RentalServiceImpl;


import java.util.ArrayList;

@RestController
@RequestMapping("/api/admin/rentals")
public class AdminRentalController {
    @Autowired
    private RentalServiceImpl rentalService; // Adjust the service interface accordingly

    @GetMapping("/list/all")
    public ArrayList<Rental> getAllRentals() {
        ArrayList<Rental> rentals = new ArrayList<>(rentalService.getAll()); // Adjust the service method accordingly
        return rentals;
    }

    @PostMapping("/create")
    public Rental createRental(@RequestBody Rental rental) {
        return rentalService.create(rental);
    }

    @GetMapping("/read/{rentalId}")
    public Rental readRental(@PathVariable Integer rentalId) {

        Rental readRental = rentalService.read(rentalId);
        return readRental;
    }
    ///`http://localhost:8080/api/rentals/${rentalId}`);

    @PutMapping("/update/{rentalId}")
    public Rental updateRental(@PathVariable int rentalId, @RequestBody Rental rental) {
        Rental updated = rentalService.update(rental);
        System.out.println("updated rental: " + updated);
        return updated;
    }

    @DeleteMapping("/delete/{rentalId}")
    public boolean deleteRental(@PathVariable Integer rentalId) {
        return rentalService.delete(rentalId);
    }
}
