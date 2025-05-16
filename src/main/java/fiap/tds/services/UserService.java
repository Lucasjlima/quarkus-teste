package fiap.tds.services;

import fiap.tds.dtos.UserDTO;
import fiap.tds.dtos.UserReponseDTO;
import fiap.tds.models.User;
import fiap.tds.repositores.UserRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
import lombok.extern.slf4j.Slf4j;


@ApplicationScoped
public class UserService {
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(UserService.class);
    @Inject
    UserRepository userRepository;


    public boolean login(String username, String password) {
        var user = userRepository.findByUsername(username);
        return user != null && user.getPassword().equals(password);
    }

    @Transactional
    // Verify if this method is functional yet after the refactor
    public void register(UserDTO userDTO){
        log.info("Iniciando processo de registro de usuario");
        var user = new User();
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setPosition(userDTO.getPosition());
        userRepository.persistUser(user);
    }

    public String searchUserName(String username){
        var user = userRepository.findByUsername(username);
        if (user != null){
            return user.getUsername();
        }
        return null;
    }

    @Transactional
    public void updateUser(Long id, UserDTO userDTO){
        var user = userRepository.findById(id);
        if(user != null){
            user.setUsername(userDTO.getUsername());
            user.setPassword(userDTO.getPassword());
            user.setPosition(userDTO.getPosition());

        }
        else{
            throw new NotFoundException("Usuário não foi encontrado!");
        }
    }

    public User findById(Long id) {
        var user = userRepository.findById(id);
        if(user == null){
            log.error("Usuario nao foi encontrado");
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
