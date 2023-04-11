package kaya.yakup.questapp.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="users")
public class UserEntity {
    @Id
    private Long id;
    private String name;
    private String surname;
    private String userName;
    private String password;

    public UserEntity() {
    }

    public UserEntity(String name, String surname, String userName, String password) {
        this.name = name;
        this.surname = surname;
        this.userName = userName;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
