package operation;

import Book.Book;
import Book.BookList;

public class DisplayOperation implements IOperation {
    @Override
    public void work(BookList bookList) {
        System.out.println("显示图书！");
        int Size = bookList.getUsedSize();
        for (int i = 0; i < Size; i++) {
            Book book = bookList.getBook(i);
            System.out.println(book);
        }
    }
}
