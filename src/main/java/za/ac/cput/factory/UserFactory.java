package za.ac.cput.factory;

import org.springframework.stereotype.Component;
import za.ac.cput.domain.impl.User;
@Component
public class UserFactory {
    public User createUser(int id, String userName, String email, String pictureUrl, String firstName, String lastName, String phoneNumber, String password, String role) {
        return User.builder()
                .id(id)
                .userName(userName)
                .email(email)
                .pictureUrl(pictureUrl)
                .firstName(firstName)
                .lastName(lastName)
                .phoneNumber(phoneNumber)
                .password(password)
                .role(role)
                .build();
    }
    public User create() {
        return User.builder().build();
    }
    public User create(User user) {
        return User.builder()
                .copy(user)
                .build();
    }
}
