package pl.coderslab.charity.services;

import pl.coderslab.charity.entity.User;

public interface UserService {
    User findByUserName(String name);
    void saveUser(User user);
    void saveAdmin(User user);
}