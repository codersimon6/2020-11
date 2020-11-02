package Book;


public class Book {
    private String Name;
    private String author;
    private int price;
    private String type;
    private boolean isBorrowed;

    @Override
    public String toString() {
        return "图书列表{" +
                "书名='" + Name + '\'' +
                ", 作者='" + author + '\'' +
                ", 价格=" + price +
                ", 类型='" + type + '\'' +",目前状态："+
                ( isBorrowed == true ? "已借出" :"未借出" )+
                '}';
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }

    public Book(String name, String author, int price, String type) {
        Name = name;
        this.author = author;
        this.price = price;
        this.type = type;
    }
}
