package technoshop.java1902.telegramBot;

public class ArticlePhones {
    private String nameCompany;
    private String name;
    private Integer price;
    private String link;

    public ArticlePhones() {
    }

    public ArticlePhones(String nameCompany, String name, Integer price, String link) {
        this.nameCompany = nameCompany;
        this.name = name;
        this.price = price;
        this.link = link;
    }

    public String getNameCompany() {
        return nameCompany;
    }

    public void setNameCompany(String nameCompany) {
        this.nameCompany = nameCompany;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return "Продавец:    " + nameCompany + "\n" +
                "устройство: " + name + "\n" +
                "цена:               " + price + "\n" +
                "link='" + link + "\n" +
                '}';
    }
}
