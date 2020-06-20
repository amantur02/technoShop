package technoshop.java1902.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import technoshop.java1902.entity.CommentByUser;
import technoshop.java1902.service.CommentByUserService;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentsByUser {
    @Autowired
    private CommentByUserService commentByUserService;

    @GetMapping
    public List<CommentByUser> getAll() {
        return commentByUserService.getAll();
    }

    @GetMapping("/{id}")
    public CommentByUser getById(@PathVariable Long id) {
        return commentByUserService.getById(id);
    }
    @PostMapping
    public CommentByUser create (CommentByUser commentByUser){
        return commentByUserService.create(commentByUser);
    }
    @DeleteMapping
    public CommentByUser deleteById(@RequestParam(name = "id") Long id){
        return commentByUserService.deleteById(id);
    }
}
