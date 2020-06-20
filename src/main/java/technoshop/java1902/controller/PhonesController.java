package technoshop.java1902.controller;

import org.springframework.web.bind.annotation.*;
import technoshop.java1902.parser.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/phones")
public class PhonesController {
    @GetMapping("/{brand}")
    public List getAllPhones(@PathVariable String brand) throws IOException {
        List<List> listList = new ArrayList<>();
        List<Article> oStore = ParserOStore.getAllDevice("phones",brand);
        List<Article> MP = MPParser.getAllDevice(brand);
        List<Article> Sulpak = ParserSulpak.getAllDevice(3,brand);
//        List Svetofor = SvetoforDeviceParser.getAllDeviceSvetofor("sotovye-telefony-i-aksessuary", brand);
        listList.add(oStore);
        listList.add(MP);
        listList.add(Sulpak);
//        listList.add(Svetofor);
        return listList;
    }

    @GetMapping("/{brand}/{example}")
    public List getAllPhoneModels(@PathVariable String brand, @PathVariable String example) throws IOException {
        List<Article> phones = ParserOStore.getAllDevice("phones", brand);
        return phones.stream().filter(x->x.getName().contains(example)).collect( Collectors.toList());
    }

}
