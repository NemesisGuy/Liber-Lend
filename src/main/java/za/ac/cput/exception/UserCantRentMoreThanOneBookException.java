package za.ac.cput.exception;

public class UserCantRentMoreThanOneBookException extends RuntimeException {
    public UserCantRentMoreThanOneBookException(String message) {
        super(message);
    }
}
