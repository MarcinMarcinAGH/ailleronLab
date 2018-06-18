package warsztaty.java.ailleronLab.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import warsztaty.java.ailleronLab.exceptions.UserNotFoundException;
import warsztaty.java.ailleronLab.exceptions.handler.UserExistException;
import warsztaty.java.ailleronLab.model.User;
import warsztaty.java.ailleronLab.repositories.UserRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
/*    static List<User> users;

    public UserService() {
        if(users == null){
            users = new ArrayList<>();
            users.add(new User(1L, "Mateusz", "Mnich", 28));
            users.add(new User(2L, "Domino", "Katszer", 16));
            users.add(new User(3L, "Andrzej", "Duda", 50));
        }
    }*/

    private UserRepository repository;

    @Autowired
    public UserService(UserRepository repository){
        this.repository = repository;
    }

    public Optional<User> getUserByName(final String name) {
        return repository.getUserByName(name);
    }

    public Long addUser(User user){
        Optional<User> optionalUser = getUserByName(user.getName());
        if(optionalUser.isPresent()){
            throw new UserExistException("Taki uzytkownik juz istnieje w systemie");
        }
        user = repository.save(user);
        return user.getId();
    }

    public List<User> getAllUsers(){
        return repository.findAll();
    }

    public Optional<User> getUserById(final Long id) {
        return repository.findById(id);
    }

    public void updateUser(final User user, final Long id){

        user.setId(id);
        repository.save(user);

    }

    public void deleteUser(final Long id){

        repository.deleteById(id);

        /*Optional<User> optionalUser = getUserById(id);

        if(!optionalUser.isPresent()){
            throw new UserNotFoundException("Uzytkownik o id: " + id + " nie istnieje.");
        }

        users.remove(optionalUser.get());*/

    }
}
