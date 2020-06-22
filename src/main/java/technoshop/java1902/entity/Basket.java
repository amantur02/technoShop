package technoshop.java1902.entity;

import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;

@Entity
@Table(name = "basket")
public class Basket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name_company", nullable = false)
    private String nameCompany;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "price", nullable = false)
    private String price;
    @Column(name = "link",nullable = false, unique = true)
    private String link;
    @Column(name = "link_picture", nullable = false)
    private String linkPicture;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

}
