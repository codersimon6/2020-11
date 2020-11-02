package operation;

import Book.BookList;

import java.util.Scanner;

public interface IOperation {
    void work(BookList bookList);
    Scanner scan = new Scanner(System.in);
}
