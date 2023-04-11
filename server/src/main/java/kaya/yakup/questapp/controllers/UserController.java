package kaya.yakup.questapp.controllers;

import kaya.yakup.questapp.entities.UserEntity;
import kaya.yakup.questapp.repositories.UserRepository;
import kaya.yakup.questapp.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/users")
public class UserController {
    private IUserService userService;

    public UserController() {
    }

    @Autowired
    public UserController(IUserService userRepository) {
        this.userService = userRepository;
    }

    public IUserService getUserService() {
        return userService;
    }

    public void setUserService(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserEntity> findAllUsers(){
        return userService.findAllUsers();
    }
    @GetMapping("/{userID}")
    public UserEntity findUserById(@PathVariable Long userID){

        return userService.findUserById(userID);
    }
    @PostMapping
    public UserEntity createUsers(@RequestBody UserEntity createdUser){
        return userService.createUser(createdUser);

    }
    @PutMapping("/{userID}")
    public UserEntity updateUserById(@RequestBody UserEntity updatedUser, @PathVariable Long userID){
        return userService.updateUserById(updatedUser,userID);
    }

    @DeleteMapping("/{userID}")
    public void deleteUserById(@PathVariable Long userID){
        userService.deleteUserById(userID);
    }
}
