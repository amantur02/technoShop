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
    public static String getLinlSoftech(String brandDevice){
        String brand;
        switch (brandDevice){
            case "apple":
                brand = "apple-smartphone";
                break;
            case "xioami":
                brand = "xiaomiphones";
                break;
            case "oppo":
                brand = "oppo";
                break;
            case "oneplus":
                brand = "oneplus_phone";
                break;
            case "google":
                brand = "google_brand";
                break;
            case "infinix":
                brand = "infinix-mobile";
                break;
            case "samsung":
                brand = "smartfony-samsung";
                break;
            case "huawei":
                brand = "huawei-phones";
                break;
            case "zte":
                brand = "ztephones";
                break;
            case "asus":
                brand = "asusphones";
                break;
            case "meizu":
                brand = "meizuphones";
                break;
            case "lenovo":
                brand = "lenovophones1";
                break;
            case "dooge":
                brand = "doogeephones";
                break;
            case "ULEFONE":
                brand = "ulefone";
                break;
            case "nokia":
                brand = "nokia-ph";
                break;
            case "LEECO":
                brand = "leeco_phones";
                break;
            case "other":
                brand = "drugie";
                break;
            default:
                brand = "drugie";
        }
        return brand;
    }
    }


