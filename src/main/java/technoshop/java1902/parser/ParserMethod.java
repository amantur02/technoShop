package technoshop.java1902.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.URL;
import java.util.List;

public class ParserMethod {
    public  static Document getAllLink(String link) throws IOException {
        Document document = null;
        document = Jsoup.parse(new URL(link), 60000);
        return document;
    }
    public static String addString(String add, String str){
        String example = add + str;
        return example;
    }
    public static Boolean equalsString(String str, String strInquiry){
        String example = str.toUpperCase();
        String example2 = strInquiry.toUpperCase();
        return example.contains(example2);
    }
    public static String getLinkMP(String device){
        if (equalsString("samsung",device)){
            device = "catalog/cell?brn[]=21";
        }else if (equalsString("xiaomi",device)){
            device = "catalog/cell?brn[]=77";
        }else if (equalsString("apple", device)){
            device = "catalog/cell?brn[]=5";
        }else
            device = "catalog/cell?sort%5Bby%5D=price&sort%5Bord%5D=desc&price%5Bmin%5D=&price%5Bmax%5D=";
        return device;
        }
    }


