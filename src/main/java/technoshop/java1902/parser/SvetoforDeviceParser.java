package technoshop.java1902.parser;

        import org.jsoup.nodes.Document;
        import org.jsoup.nodes.Element;
        import org.jsoup.select.Elements;

        import java.io.IOException;
        import java.util.ArrayList;
        import java.util.List;

public class SvetoforDeviceParser {
    public static synchronized List getAllDeviceSvetofor(String category, String brand) throws IOException {
        List<Article> articleList = new ArrayList<>();
        List<String> nameDeviceList = new ArrayList<>();
        List<String> priceDeviceList = new ArrayList<>();
        List<String> linkDeviceList = new ArrayList<>();
        List<String> linkPictureDeviceList = new ArrayList<>();

        Document MainPage = null;//Главная страница Svetofor
        Document getAllDevicePage = null;//страница устройств

        MainPage = ParserMethod.getAllLink("https://svetofor.info/" + category + "/smartfony-" + brand + "/");
        Elements linkEnter = MainPage.select("a[class=sv_subphoneaccimg");
        List<String> deviceLinkList = new ArrayList<>();

        linkEnter.forEach(table -> {//Тут парсится ссылка на страницу телефона и картинки
            Element linkEnterElement = table;
            String linkEnter0 =linkEnterElement.attr("href");
            String str = "https://svetofor.info/" + linkEnter0;
            linkDeviceList.add(str);
            //тут находится ссылка на устройства brand

            String linkPicture = linkEnterElement.child(0).attr("src");
            linkPictureDeviceList.add(linkPicture);
        });

        for (int i = 0; i < linkDeviceList.size(); i++) {//Тут парсится имя и сумма девайса
            getAllDevicePage = ParserMethod.getAllLink(linkDeviceList.get(i));
            Element nameDevice = getAllDevicePage.select("a[class=product-title]").first();
            Element priceDevice = getAllDevicePage.select("span[class=ty-price-num]").first();
            //с одной ссылки будем брать только 1 девайс
            //тат как телефоны похожи с одной ссылки отличимо только характиристика
            String name = nameDevice.text();
            String price = priceDevice.text();

            nameDeviceList.add(name);
            priceDeviceList.add(price);
        }

        for (int i = 0; i < nameDeviceList.size(); i++) {//Это чтобы не было рекламы
            if (ParserMethod.equalsString(nameDeviceList.get(i), brand)) {
                articleList.add(new Article("Svetofor",nameDeviceList.get(i), priceDeviceList.get(i), linkDeviceList.get(i), linkPictureDeviceList.get(i)));
            }else
                continue;
        }
        return articleList;
    }
}
