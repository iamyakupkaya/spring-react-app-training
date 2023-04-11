package kaya.yakup.questapp.services;

import kaya.yakup.questapp.entities.UserEntity;
import kaya.yakup.questapp.repositories.UserRepository;

import java.util.List;

public interface IUserService {
    public abstract List<UserEntity> findAllUsers();
    UserEntity findUserById(Long userID);

    UserEntity createUser(UserEntity createdUser);

    UserEntity updateUserById(UserEntity updatedUser, Long userID);

    void deleteUserById(Long userID);

}
