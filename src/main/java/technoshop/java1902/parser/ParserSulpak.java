//package technoshop.java1902.parser;
//
//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
//import org.jsoup.nodes.Element;
//import org.jsoup.select.Elements;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//public class ParserSulpak {
//    public static synchronized List getNumberPage() throws IOException {
//        Document getPage = Jsoup.connect("https://www.sulpak.kg/f/smartfoniy").get();
//        List<String> numberList = new ArrayList<>();
//        Elements getNumberPage = getPage.select("div[class=pages-list]");
//
//        getNumberPage.forEach(table ->{
//            Element numberElement = table;
//            String number0 = numberElement.child(13).text();
//            numberList.add(number0);
//        });
//        return numberList;
//    }
//
//    public static synchronized List<Article> getAllDevice(Integer i, String brand) throws IOException {
//        Document getPage = Jsoup.connect("https://www.sulpak.kg/f/smartfoniy?page=" + i).get();
//        Elements getAllTable = getPage.select("div[class=goods-tiles]");
//        List<Article> articleList = new ArrayList<>();
//        List<String> nameList = new ArrayList<>();
//        List<String> linkList = new ArrayList<>();
//        List<Integer> priceList = new ArrayList<>();
//        List<String> pictureList = new ArrayList<>();
//
//        Elements getName = getAllTable.select("a[class=title]");
//        Elements getPrice = getAllTable.select("div[class=price]");
//        Elements getPicture = getAllTable.select("div[class=goods-photo]");
//            Elements getAllPicture = getPicture.select("img[src]");
//
//        getName.forEach(table -> {
//            Element nameElement = table;
//            String name0 = nameElement.text();
//            nameList.add(name0);
//        });
//        getName.forEach(table ->{
//            Element linkElement = table;
//            String link0 = linkElement.attr("href");
//            String example = "https://www.sulpak.kg/" + link0;
//            linkList.add(example);
//        });
//        getPrice.forEach(table ->{
//            Element priceElement = table;
//            String link0 = priceElement.child(0).text();
//            Integer num = Integer.parseInt(link0);
//            priceList.add(num);
//        });
//        getAllPicture.forEach(table ->{
//            Element pictureElement = table;
//            String picture0 = pictureElement.attr("src");
//            pictureList.add(picture0);
//        });
//        for (int j = 0; j < nameList.size(); j++) {
//            if (ParserMethod.equalsString(nameList.get(j), brand)){
//                articleList.add(new Article("Sulpak", nameList.get(j),priceList.get(j), linkList.get(j), pictureList.get(j)));
//            }else
//                continue;
//        }
//        return articleList;
//    }
//    public static List getAllDeviceSulpak (String brand) throws IOException {
//        Integer number = (Integer) getNumberPage().get(0);
//        List<Article> list = null;
//        for (int i = 0; i < number; i++)
//             list = getAllDevice(i,brand);
//        return list;//Тут будет ошибка нужно еще раз проверить
//    }
//}
