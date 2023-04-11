package kaya.yakup.questapp.services.Implementations;

import kaya.yakup.questapp.entities.UserEntity;
import kaya.yakup.questapp.repositories.UserRepository;
import kaya.yakup.questapp.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {

    private UserRepository userRepository;

    public UserServiceImpl() {
    }

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserEntity> findAllUsers() {
        return userRepository.findAll();

    }

    @Override
    public UserEntity findUserById(Long userID) {
        return userRepository.findById(userID).orElse(null);
    }

    @Override
    public UserEntity createUser(UserEntity createdUser) {
        return userRepository.save(createdUser);
    }

    @Override
    public UserEntity updateUserById(UserEntity updatedUser, Long userID) {
        Optional<UserEntity> user = userRepository.findById(userID);
        if(user.isPresent()){
            // if user is found
            UserEntity foundUser = user.get();
            foundUser.setUserName(updatedUser.getUserName());
            foundUser.setName(updatedUser.getName());
            foundUser.setSurname(updatedUser.getSurname());
            foundUser.setPassword(updatedUser.getPassword());
            userRepository.save(foundUser);
            return foundUser;
        }
        else {
            return null;
        }

    }

    @Override
    public void deleteUserById(Long userID) {
        userRepository.deleteById(userID);
    }

    // GETTERs and SETTERs


    public UserRepository getUserRepository() {
        return userRepository;
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
