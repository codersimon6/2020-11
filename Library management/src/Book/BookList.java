package Book;

public class BookList {
    public Book[] elem = new Book[10];

    private int usedSize;
    public BookList(){
        elem[0] =new Book("三国演义","罗贯中",10,"小说");
        elem[1] =new Book("Java编程","simon",20,"学习");
        elem[2] =new Book("西游记","吴承恩",30,"小说");
        usedSize = 3;
    }

    public void setBook(int pos,Book book){
        elem[pos] = book;
    }
    public Book getBook(int pos){
        return elem[pos];
    }
    public int getUsedSize() {
        return usedSize;
    }

    public void setUsedSize(int usedSize) {
        this.usedSize = usedSize;
    }

}
