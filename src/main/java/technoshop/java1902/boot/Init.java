package technoshop.java1902.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import technoshop.java1902.entity.User;
import technoshop.java1902.service.UserService;

@Component
public class Init implements CommandLineRunner {
    @Autowired
    private UserService userService;

    @Override
    public void run(String... args) throws Exception {
        userService.create(new User("login", "123"));
        userService.create(new User("login2", "102"));
    }
}
