package technoshop.java1902.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "comments")
public class CommentByUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "text", nullable = false)
    private String text;//текст (комментарий)
    @Column(name = "likes", nullable = false)
    private Integer likes;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
