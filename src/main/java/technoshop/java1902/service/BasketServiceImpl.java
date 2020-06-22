package technoshop.java1902.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import technoshop.java1902.entity.Basket;

import java.util.List;
@Service
public class BasketServiceImpl implements BasketService {
    @Autowired
    private BasketService basketService;
    @Override
    public List<Basket> getAll() {
        return basketService.getAll();
    }

    @Override
    public Basket getById(Long id) {
        return basketService.getById(id);
    }

    @Override
    public Basket create(Basket basket) {
        return basketService.create(basket);
    }

    @Override
    public Basket deleteById(Long id) {
        return basketService.deleteById(id);
    }
}
