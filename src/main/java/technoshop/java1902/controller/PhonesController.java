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
//        List<Article> Sulpak = ParserSulpak.getAllDeviceSulpak(brand);
        List<Article> Softech = ParserSoftech.getAllPageDeviceSoftech(ParserMethod.getLinlSoftech(brand));
//        List Svetofor = SvetoforDeviceP
        listList.add(MP);
        listList.add(oStore);
//        listList.add(Sulpak);
        listList.add(Softech);
//        listList.add(Svetofor);
        return MP;
    }

    @GetMapping("/{brand}/{example}")
    public List getAllPhoneModels(@PathVariable String brand, @PathVariable String example) throws IOException {

        List<List<Article>> listList = new ArrayList<>();
        List<Article> oStore = ParserOStore.getAllDevice("phones",brand);
        List<Article> MP = MPParser.getAllDevice(brand);
//        List<Article> Sulpak = ParserSulpak.getAllDevice(3,brand);
        List<Article> Softech = ParserSoftech.getAllPageDeviceSoftech(ParserMethod.getLinlSoftech(brand));
//        List Svetofor = SvetoforDeviceP
        listList.add(MP);
//        listList.add(Sulpak);

        return listList.stream().map(l->l.stream().filter(x->x.getName().contains(example)).collect( Collectors.toList())).collect(Collectors.toList());

    }

}
