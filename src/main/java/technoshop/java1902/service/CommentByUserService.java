package technoshop.java1902.service;

import technoshop.java1902.entity.CommentByUser;
import technoshop.java1902.entity.User;

import java.util.List;

public interface CommentByUserService {
    List<CommentByUser> getAll();
    CommentByUser getById(Long id);
    CommentByUser create(CommentByUser commentByUser);
//    CommentByUser update(CommentByUser commentByUser);
    CommentByUser deleteById(Long id);
}
