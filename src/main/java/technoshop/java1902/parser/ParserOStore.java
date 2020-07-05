package technoshop.java1902.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ParserOStore {
    public static synchronized List<Article> getAllDevice(String categoryLink, String brand) throws IOException {
        Document document = Jsoup.connect("https://ostore.kg/" + categoryLink + "/" + brand + "/").get();
        List<Article> articleList = new LinkedList<>();
        List<String> nameList = new ArrayList<>();
        List<Integer> priceList = new ArrayList<>();
        List<String> linkList = new ArrayList<>();
        List<String> linkPictureList = new ArrayList<>();

        Elements getAllTable = document.select("div[class=tabloid]");

        Elements name = getAllTable.select("a[class=name]");
        Elements price = getAllTable.select("a[class=price]");
        Elements linkPicture1 = getAllTable.select("a[class=picture]");
        Elements linkPicture2 = linkPicture1.select("img[src]");

        name.forEach(table -> {
            Element nameElement = table;
            String name0 = nameElement.child(0).text();
            nameList.add(name0);

            Element linkElement = table;
            String link0 = linkElement.attr("href");
            linkList.add(ParserMethod.addString("https://ostore.kg", link0));
        });
        price.forEach(table -> {
            Element priceElement = table;
            String price0 = priceElement.text();
            Integer num = Integer.parseInt(price0);
            priceList.add(num);
        });
        linkPicture2.forEach(table -> {
            Element linkPictureElement = table;
            String linkPicture0 = linkPictureElement.attr("src");
            linkPictureList.add(ParserMethod.addString("http://ostore.kg", linkPicture0));
        });


        for (int i = 0; i < nameList.size(); i++) {//это что-бы не было рекламы
            if (ParserMethod.equalsString(nameList.get(i), brand)) {
                articleList.add(new Article("O Store",nameList.get(i), priceList.get(i), linkList.get(i), linkPictureList.get(i)));
            }else if (brand.equalsIgnoreCase("apple")){
                if (ParserMethod.equalsString(nameList.get(i), "iphone")){
                    articleList.add(new Article("O Store",nameList.get(i), priceList.get(i), linkList.get(i), linkPictureList.get(i)));
                }else
                    continue;
            }else
                continue;

        }
        return articleList;
    }
}
