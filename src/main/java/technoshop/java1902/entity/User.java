package technoshop.java1902.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


//@AllArgsConstructor
//@NoArgsConstructor
@Data

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "login",nullable = false,unique = true)
    private String login;
    @Column(name = "password", nullable = false)
    private String password;

    public User() {
    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }
    //    @OneToMany
//    @JoinColumn(name = "comment_by_user")
//    private List<CommentByUser> commentsByUser;
}
