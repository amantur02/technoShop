package technoshop.java1902.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import technoshop.java1902.entity.Basket;
@Repository
public interface BasketRepository extends JpaRepository<Basket, Long> {
}
