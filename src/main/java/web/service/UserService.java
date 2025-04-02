package web.service;

import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import java.util.List;

public interface UserService {
    User getUserById(Long id);

    List<User> showAllUsers();

    void save(User user);

    void update(Long id, String name, String lastname, Integer age);

    void delete(Long id);
}
