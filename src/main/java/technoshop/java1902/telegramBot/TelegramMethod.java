package technoshop.java1902.telegramBot;

import technoshop.java1902.parser.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TelegramMethod {
    public static String removeChars(String str,Integer number){
        return str.substring(0,number);//не удалять символы от 0(вклч) до number(не вклч)
    }
    public static String deleteFirstCharacter(String str){
        return str.substring(2, str.length());
    }
    public static List<Article> getAllDevice(String name) throws IOException {
        List<Article> allPhones= new ArrayList<>();
        List<Article> oStore = ParserOStore.getAllDevice("phones",name);
        List<Article> MP = MPParser.getAllDevice(name);
        List<Article> Softech = ParserSoftech.getAllPageDeviceSoftech(ParserMethod.getLinlSoftech(name));

        allPhones.addAll(oStore);
        allPhones.addAll(MP);
        allPhones.addAll(Softech);

        allPhones.sort((o1, o2) -> o1.getPrice()-o2.getPrice());

        return allPhones;
    }
    public static List<String> splitString(String str, String regex){
        List<String> list = new ArrayList<>();
        for (String retval : str.split(regex)){
            list.add(retval);
        }
//        list.remove(0);
        return list;
    }
    public static List<Article> searchByName(String link, String name) throws IOException {
        List<Article> allPhones = new ArrayList<>();
        List<Article> oStore = ParserOStore.getAllDevice("phones", link);
        List<Article> MP = MPParser.getAllDevice(link);
        List<Article> Softech = ParserSoftech.getAllPageDeviceSoftech(ParserMethod.getLinlSoftech(link));

        for (int i = 0; i < oStore.size(); i++)
            if (equalsString(oStore.get(i).getName(), name)) {
                allPhones.add(oStore.get(i));
            } else
                continue;
        for (int i = 0; i < MP.size(); i++)
            if (equalsString(MP.get(i).getName(), name)) {
                allPhones.add(MP.get(i));
            } else
                continue;

        for (int i = 0; i < Softech.size(); i++)
            if (equalsString(Softech.get(i).getName(), name)) {
                allPhones.add(Softech.get(i));
            } else
                continue;


//        allPhones.sort((o1, o2) -> o1.getPrice()-o2.getPrice());
        return allPhones;
    }
    public static List<Article> searchByPrice(String name, Integer from, Integer before) throws IOException {
        List<Article> allPhones= new ArrayList<>();
        List<Article> oStore = ParserOStore.getAllDevice("phones",name);
        List<Article> MP = MPParser.getAllDevice(name);
        List<Article> Softech = ParserSoftech.getAllPageDeviceSoftech(ParserMethod.getLinlSoftech(name));

        for (int i = 0; i < oStore.size(); i++)
            if (from < oStore.get(i).getPrice() && oStore.get(i).getPrice() < before){
                allPhones.add(oStore.get(i));
            }else
                continue;
        for (int i = 0; i < MP.size(); i++)
            if (from < MP.get(i).getPrice() && MP.get(i).getPrice() < before){
                allPhones.add(MP.get(i));
            }else
                continue;
        for (int i = 0; i < Softech.size(); i++)
            if (from < Softech.get(i).getPrice() && Softech.get(i).getPrice() < before){
                allPhones.add(Softech.get(i));
            }else
                continue;

        allPhones.sort((o1, o2) -> o1.getPrice()-o2.getPrice());

        return allPhones;
    }
    public static Boolean equalsString(String str, String strInquiry){
        String example = str.toUpperCase();
        String example2 = strInquiry.toUpperCase();
        return example.contains(example2);
    }

}
