package technoshop.java1902.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MPParser {
    public static synchronized List<Article> getAllDevice(String device) throws IOException {
        List<Article> articleList = new ArrayList<>();
        List<String> nameList = new ArrayList<>();
        List<String> priceList = new ArrayList<>();
        List<String> linkList = new ArrayList<>();
        List<String> linkPictureList = new ArrayList<>();

        Document document = Jsoup.connect("https://www.myphone.kg/ru/" + device).get();
        Elements element = document.select("img[src]");
        Elements price = document.select("span[class=price_sp]");
        Elements nameAndLinkDevice = document.select("div[class=title]");
        Elements example = nameAndLinkDevice.select("a[href]");

        element.forEach(table ->{//парсинг фото
            Element name = table;
            String exaple = name.attr("src");
            String example0 = "https://www.myphone.kg" + exaple;
            linkPictureList.add(example0);
        });
        price.forEach(table ->{//парсинг суммы девайса
            Element name = table;
            String str = name.text();
            String example0 = str + "c";
            priceList.add(example0);
        });
        example.forEach(table ->{//парсинг ссылки и имени дувайса
            Element name = table;
            String name0 = name.attr("href");//ссылка
            String namewf = name.text();//наименования
            String e = "https://www.myphone.kg" + name0;
            linkList.add(e);
            nameList.add(namewf);
        });
        for (int i = 0; i < nameList.size(); i++) {
            articleList.add(new Article(nameList.get(i),priceList.get(i),linkList.get(i),linkPictureList.get(i + 7)));
        }
        return articleList;
    }
}
