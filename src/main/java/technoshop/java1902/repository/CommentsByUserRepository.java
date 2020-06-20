package technoshop.java1902.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import technoshop.java1902.controller.CommentsByUser;
import technoshop.java1902.entity.CommentByUser;

import java.util.List;

@Repository
public interface CommentsByUserRepository extends JpaRepository<CommentByUser,Long> {
    List<CommentByUser> findAllByUserId(Long userId);

}
