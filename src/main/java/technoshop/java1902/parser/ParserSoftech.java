package technoshop.java1902.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ParserSoftech {
    public static synchronized List getAllPageDeviceSoftech(String link) throws IOException {
        Document getPage = Jsoup.connect("https://softech.kg/phones/" + link + "/").get();
        Elements h1Table = getPage.select("div[class=row]");

        List<Article> articlesList = new ArrayList<>();
        List<String> nameList = new ArrayList<>();
        List<String> linkList = new ArrayList<>();
        List<String> priceList = new ArrayList<>();
        List<String> linkPictureLst = new ArrayList<>();


        Elements getNameAndLink = h1Table.select("div[class=name]");
        Elements getLink = getNameAndLink.select("a[href]");
        Elements getPrise = h1Table.select("div[class=price]");
        Elements getPicture = h1Table.select("img[class=img-responsive]");


        getNameAndLink.forEach(table ->{
            Element nameAndLinkElement = table;
            String name0 = nameAndLinkElement.text();
            nameList.add(name0);
        });
        getLink.forEach(table ->{
            Element linkElement = table;
            String link0 = linkElement.attr("href");
            linkList.add(link0);
        });
        getPrise.forEach(table ->{
            Element priceElement = table;
            String price0 = priceElement.text();
            priceList.add(price0);
        });
        getPicture.forEach(table ->{
            Element pictureElement = table;
            String picture0 = pictureElement.attr("data-src");
            linkPictureLst.add(picture0);
        });

        for (int i = 0; i < nameList.size(); i++)
            articlesList.add(new Article("Softech" ,nameList.get(i),priceList.get(i), linkList.get(i),linkPictureLst.get(i+1)));
        return articlesList;
    }
}
