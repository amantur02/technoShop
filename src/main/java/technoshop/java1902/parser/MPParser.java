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

        Document document = ParserMethod.getAllLink("https://www.myphone.kg/ru/" + ParserMethod.getLinkMP(device), 8000);
        Elements price = document.select("span[class=price_sp]");

        Elements nameAndLinkDevice1 = document.select("div[class=title]");
        Elements nameAndLink = nameAndLinkDevice1.select("a[href]");

        Elements linkPicture1 = document.select("div[style=display: block]");
        Elements linkPicture2 = linkPicture1.select("img[src]");

        linkPicture2.forEach(table ->{//парсинг фото
            Element name = table;
            String exaple = name.attr("src");
            String example0 = "https://www.myphone.kg" + exaple;
            linkPictureList.add(example0);
        });
        price.forEach(table ->{//парсинг суммы девайса
            Element name = table;
            String str = name.text();
            priceList.add(str);
        });
        nameAndLink.forEach(table ->{//парсинг ссылки и имени дtвайса
            Element name = table;
            String name0 = name.attr("href");//ссылка
            String namewf = name.text();//наименования
            String e = "https://www.myphone.kg" + name0;
            linkList.add(e);
            nameList.add(namewf);
        });
        for (int i = 0; i < nameList.size(); i++) {
            if (ParserMethod.equalsString(nameList.get(i),device)){
                String example = priceList.get(i);
                Integer integerPrice = Integer.parseInt(ParserMethod.removeChar(example));
                articleList.add(new Article("My Phone",nameList.get(i),integerPrice,linkList.get(i),linkPictureList.get(i)));
            }else
                continue;
        }
        return articleList;
    }
}
