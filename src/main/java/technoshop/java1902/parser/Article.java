package technoshop.java1902.parser;

public class Article {
    private String name;
    private String price;
    private String link;
    private String linkPicture;

    public Article() {
    }

    public Article(String name, String price, String link, String linkPicture) {
        this.name = name;
        this.price = price;
        this.link = link;
        this.linkPicture = linkPicture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getLinkPicture() {
        return linkPicture;
    }

    public void setLinkPicture(String linkPicture) {
        this.linkPicture = linkPicture;
    }

    @Override
    public String toString() {
        return "Article{" +
                "name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", link='" + link + '\'' +
                ", linkPicture='" + linkPicture + '\'' +
                '}';
    }
}
