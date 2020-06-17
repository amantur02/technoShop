package technoshop.java1902.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ParserSulpak {
    public static synchronized List getNumberPage() throws IOException {
        Document getPage = Jsoup.connect("https://www.sulpak.kg/f/smartfoniy").get();
        List<String> numberList = new ArrayList<>();
        Elements getNumberPage = getPage.select("div[class=pages-list]");

        getNumberPage.forEach(table ->{
            Element numberElement = table;
            String number0 = numberElement.child(13).text();
            numberList.add(number0);
        });
        return numberList;
    }

    public static synchronized List getAllDevice(List list) throws IOException {
        Document getPage = Jsoup.connect("https://www.sulpak.kg/f/smartfoniy?page=" + list.get(0)).get();
        Elements getAllTable = getPage.select("div[class=goods-tiles]");
        List<String> nameList = new ArrayList<>();
        List<String> linkList = new ArrayList<>();
        List<String> priceList = new ArrayList<>();
        List<String> pictureList = new ArrayList<>();

        Elements getName = getAllTable.select("a[class=title]");
        Elements getPrice = getAllTable.select("div[class=price]");
        Elements getPicture = getAllTable.select("div[class=goods-photo]");
        Elements getAllPicture = getPicture.select("img[src]");

        getName.forEach(table -> {
            Element nameElement = table;
            String name0 = nameElement.text();
            nameList.add(name0);
        });
        getName.forEach(table ->{
            Element linkElement = table;
            String link0 = linkElement.attr("href");
            String example = "https://www.sulpak.kg/" + link0;
            linkList.add(example);
        });
        getPrice.forEach(table ->{
            Element priceElement = table;
            String link0 = priceElement.child(0).text();
            priceList.add(link0);
        });
        getAllPicture.forEach(table ->{
            Element pictureElement = table;
            String picture0 = pictureElement.attr("src");

            pictureList.add(picture0);
        });

        return pictureList;
    }
}
