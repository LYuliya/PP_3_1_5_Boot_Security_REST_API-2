package ru.kata.spring.boot_security.demo.services;


import ru.kata.spring.boot_security.demo.models.User;
import java.util.List;

public interface UserService {
    List<User> findAll();

    User findOne();

    User findOneId(int id);

    void save(User user);

    void delete(int id);




}
