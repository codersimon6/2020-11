package operation;

import Book.Book;
import Book.BookList;

public class AddOperation implements IOperation{
    @Override
    public void work(BookList bookList) {
        System.out.println("新增图书！");
        System.out.println("请输入书名：");
        String name = scan.next();
        System.out.println("请输入作者：");
        String author = scan.next();
        System.out.println("请输入价格：");
        int price = scan.nextInt();
        System.out.println("请输入类型：");
        String type = scan.next();
        Book book = new Book(name,author,price,type);
        int Size = bookList.getUsedSize();
        bookList.setBook(Size,book);
        bookList.setUsedSize(Size+1);
    }
}
