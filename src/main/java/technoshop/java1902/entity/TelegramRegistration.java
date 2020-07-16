package technoshop.java1902.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
//
//@AllArgsConstructor
//@NoArgsConstructor
//@Data
@Entity
@Table(name = "telegram_registration")
public class TelegramRegistration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "users_id", nullable = false, unique = true)
    private User user;
    @Column(name = "telegram_id", nullable = false, unique = true)
    private Long telegramId;

    public TelegramRegistration() {
    }

    public TelegramRegistration(User user, Long telegramId) {
        this.user = user;
        this.telegramId = telegramId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getTelegramId() {
        return telegramId;
    }

    public void setTelegramId(Long telegramId) {
        this.telegramId = telegramId;
    }
}
