package technoshop.java1902.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import technoshop.java1902.entity.Seller;
import technoshop.java1902.parser.ParserOStore;
import technoshop.java1902.service.SellerService;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/phones")
public class PhonesController {
    @GetMapping("/{brand}")
    public List getAllPhones(@PathVariable String brand) throws IOException {
        return ParserOStore.getAllDevice("phones", brand);
    }

}
