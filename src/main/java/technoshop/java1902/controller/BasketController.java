package technoshop.java1902.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import technoshop.java1902.entity.Basket;
import technoshop.java1902.entity.CommentByUser;
import technoshop.java1902.service.BasketService;
import technoshop.java1902.service.CommentByUserService;

import java.util.List;

public class BasketController {
    @Autowired
    private BasketService basketService;

    @GetMapping
    public List<Basket> getAll() {
        return basketService.getAll();
    }

    @GetMapping("/{id}")
    public Basket getById(@PathVariable Long id) {
        return basketService.getById(id);
    }
    @PostMapping
    public Basket create (Basket basket){
        return basketService.create(basket);
    }
    @DeleteMapping
    public Basket deleteById(@RequestParam(name = "id") Long id){
        return basketService.deleteById(id);
    }
}
