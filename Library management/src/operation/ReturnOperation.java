package operation;

import Book.Book;
import Book.BookList;

public class ReturnOperation implements IOperation{
    @Override
    public void work(BookList bookList) {
        System.out.println("输入要归还的图书名字：");
        String name = scan.next();
        int Size = bookList.getUsedSize();
        for (int i = 0; i < Size; i++) {
            Book book = bookList.getBook(i);
            if(book.getName().equals(name) && book.isBorrowed() == false) {
                System.out.println("未被租借！");
            }else if(book.isBorrowed() == true){
                book.setBorrowed(false);
                System.out.println("归还成功");
                break;
            }
        }
    }
}