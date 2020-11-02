package operation;

import Book.BookList;

public class DelOperation implements IOperation{
    @Override
    public void work(BookList bookList) {
        System.out.println("输入要删除的图书ID(从1依次增大)：");
        int id = scan.nextInt();
        int Size = bookList.getUsedSize();
        for (int i = id - 1; i < Size; i++) {
            bookList.elem[i] = bookList.elem[i+1];
        }
        bookList.setUsedSize(Size - 1);
    }
}
