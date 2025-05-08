package fiap.tds.services;

import fiap.tds.dtos.UserDTO;
import fiap.tds.dtos.UserReponseDTO;
import fiap.tds.models.User;
import fiap.tds.repositores.UserRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class UserService {

    @Inject
    UserRepository userRepository;


    public boolean login(String username, String password) {
        var user = userRepository.findByUsername(username);
        return user != null && user.password.equals(password);
    }
    @Transactional
    public void register(UserDTO userDTO){
        var user = new User();
        user.username = userDTO.username;
        user.password = userDTO.password;
        user.position = userDTO.position;
        user.persist();
    }

    public String searchUserName(String username){
        var user = userRepository.findByUsername(username);
        if (user != null){
            return user.username;
        }
        return null;
    }

    @Transactional
    public void updateUser(Long id, UserDTO userDTO){
        var user = userRepository.findById(id);
        if(user != null){
            user.username = userDTO.username;
            user.password = userDTO.password;
            user.position = userDTO.position;

        }
        else{
            throw new NotFoundException("Usuário não foi encontrado!");
        }
    }

    public User findById(Long id) {
        var user = userRepository.findById(id);
        if(user == null){
            throw new NotFoundException("Usuário não foi encontrado!");
        }
        return user;
    }

    @Transactional
    public User deleteById(Long id){
        var user = userRepository.findById(id);
        if(user != null){
            userRepository.delete(user);
            return user;
        }
        else{
            throw new NotFoundException("Usuário não foi encontrado!");
        }

    }
}
