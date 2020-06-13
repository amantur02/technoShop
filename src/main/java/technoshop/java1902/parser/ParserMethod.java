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

}
