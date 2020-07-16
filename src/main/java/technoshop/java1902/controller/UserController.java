package technoshop.java1902.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import technoshop.java1902.entity.User;
import technoshop.java1902.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping
    public User create (@RequestBody User user){
        return userService.create(user);
    }
    @DeleteMapping
    public User deleteById(@RequestParam(name = "id") Long id){
        return userService.deleteById(id);
    }
    @GetMapping
    public List<User> getAll(){
        return userService.getAll();
    }
    @GetMapping("/{id}")
    public User getById(@PathVariable Long id){
        return userService.getById(id);
    }

}
