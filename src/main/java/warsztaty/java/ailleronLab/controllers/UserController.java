package warsztaty.java.ailleronLab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import warsztaty.java.ailleronLab.exceptions.UserNotFoundException;
import warsztaty.java.ailleronLab.model.User;
import warsztaty.java.ailleronLab.model.UserList;
import warsztaty.java.ailleronLab.services.UserService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    UserService service;

    @GetMapping("/users/{name}")
    public User getSurnameByName(@PathVariable("name") String name){
        Optional<User> optionalUser = service.getUserByName(name);

        if(optionalUser.isPresent()){
            return optionalUser.get();
        }
        throw new UserNotFoundException("Brak uzytkownika o imieniu: " + name);
    }

    @GetMapping("/users")
    public UserList getAllUser(){
        return new UserList(service.getAllUsers());
    }

    @PostMapping("/users")
    public ResponseEntity addUser(@RequestBody @Valid User user){    //request body mowi zeby pobrac usera z adresu url
        return ResponseEntity.status(HttpStatus.CREATED).body( service.addUser(user));
    }

    @PutMapping("/users/{id}")
    public void updateUser(@RequestBody @Valid User user, @PathVariable() Long id){
        service.updateUser(user, id);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Long id){
        service.deleteUser(id);
    }
}
