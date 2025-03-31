package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    User getUserById(Long id);

    List<User> showAllUsers();

    void save(User user);

    void update(User user);

    void delete(User user);
}
