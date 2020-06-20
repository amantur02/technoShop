package technoshop.java1902.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import technoshop.java1902.entity.CommentByUser;
import technoshop.java1902.entity.User;
import technoshop.java1902.repository.CommentsByUserRepository;

import java.util.List;
@Service
public class CommentByUserServiceImpl implements CommentByUserService {
    @Autowired
    private CommentsByUserRepository commentsByUserRepository;
    @Override
    public List<CommentByUser> getAll() {
        return commentsByUserRepository.findAll();
    }

    @Override
    public CommentByUser getById(Long id) {
        return commentsByUserRepository.findById(id).orElse(null);
    }

    @Override
    public CommentByUser create(CommentByUser commentByUser) {
        return commentsByUserRepository.save(commentByUser);
    }

//    @Override
//    public CommentByUser update(CommentByUser commentByUser) {
//        return null;
//    }

    @Override
    public CommentByUser deleteById(Long id) {
        CommentByUser commentByUser = getById(id);
        if (commentByUser != null) {
            commentsByUserRepository.deleteById(id);
        }
        return commentByUser;
    }
}
