package operation;

import Book.Book;
import Book.BookList;

public class BorrowOperation implements IOperation{
    @Override
    public void work(BookList bookList) {
        System.out.println("输入要借的图书名字：");
        String name = scan.next();
        int Size = bookList.getUsedSize();
        for (int i = 0; i < Size; i++) {
            Book book = bookList.getBook(i);
            if(book.getName().equals(name) && book.isBorrowed() == false) {
                System.out.println("租借成功");
                book.setBorrowed(true);
                break;
            }else if(book.isBorrowed() == true){
                System.out.println("已被借走");
            }
        }
    }
}
