package technoshop.java1902.service;

import technoshop.java1902.entity.Basket;

import java.util.List;

public interface BasketService {
    List<Basket> getAll();
    Basket getById(Long id);
    Basket create(Basket basket);
    Basket deleteById(Long id);
}
