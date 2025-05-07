package fiap.tds.services;

import fiap.tds.models.User;
import fiap.tds.repositores.UserRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class UserService {

    @Inject
    UserRepository userRepository;


    public boolean login(String username, String password) {
        User user = userRepository.findByUsername(username);
        return user != null && user.password.equals(password);
    }
}
