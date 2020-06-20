package technoshop.java1902.service;

import technoshop.java1902.entity.User;

import java.util.List;

public interface UserService {
    User create (User user);
    User deleteById (Long id);
    List<User> getAll ();
    User getById (Long id);
}
