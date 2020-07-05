package technoshop.java1902.telegramBot;

import technoshop.java1902.parser.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BotMethod {
    public static String leaveTheFirstCharacter(String str) {
        return str.substring(0, 1);//удаляет все символы кроме 1
    }
//
//public static List listPhones(String brand) throws IOException {
//        List<List<Article>> articleList = new ArrayList<>();
////        return articleList.stream().map(l->l.stream().filter(x->x.getName().contains(brand)).collect
////            ( Collectors.toList())).collect(Collectors.toList());
//
//
//        boolean isSorted = false;
//        int buf;
//        while (!isSorted){
//            isSorted = true;
//
//        }

    }
