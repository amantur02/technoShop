package technoshop.java1902.controller;

import org.springframework.web.bind.annotation.*;
import technoshop.java1902.parser.*;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/phones")
public class PhonesController {
    @GetMapping("/{brand}")
    public List<Article> getAllPhones(@PathVariable String brand) throws IOException {
        List<Article> allPhones= new ArrayList<>();
        List<Article> oStore = ParserOStore.getAllDevice("phones",brand);
        List<Article> MP = MPParser.getAllDevice(brand);
        List<Article> Softech = ParserSoftech.getAllPageDeviceSoftech(ParserMethod.getLinlSoftech(brand));

        allPhones.addAll(oStore);
        allPhones.addAll(MP);
        allPhones.addAll(Softech);

        allPhones.sort((o1, o2) -> o1.getPrice()-o2.getPrice());
        return allPhones;
    }

    @GetMapping("/{brand}/{model}")
    public List getAllPhoneModels(@PathVariable String brand, @PathVariable String model) throws IOException {
        List<List<Article>> listList = new ArrayList<>();
        List<Article> oStore = ParserOStore.getAllDevice("phones",brand);
        List<Article> MP = MPParser.getAllDevice(brand);
        List<Article> Softech = ParserSoftech.getAllPageDeviceSoftech(ParserMethod.getLinlSoftech(brand));

        listList.add(oStore);
        listList.add(MP);
        listList.add(Softech);

        return listList.stream().map(l->l.stream().filter(x->x.getName().contains(model)).collect( Collectors.toList())).collect(Collectors.toList());

    }

}
