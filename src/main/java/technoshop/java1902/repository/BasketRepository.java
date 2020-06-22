package technoshop.java1902.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import technoshop.java1902.entity.Basket;

public interface BasketRepository extends JpaRepository<Basket, Long> {
}
