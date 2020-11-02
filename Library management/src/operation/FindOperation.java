package operation;

import Book.Book;
import Book.BookList;

public class FindOperation implements IOperation{
    @Override
    public void work(BookList bookList) {
        System.out.println("查询图书！");
        String name = scan.next();
        int Size = bookList.getUsedSize();
        for (int i = 0; i < Size; i++) {
            Book book = bookList.getBook(i);
            if(book.getName().equals(name)) {
                System.out.println(book);
                break;
            }
        }
    }
}
