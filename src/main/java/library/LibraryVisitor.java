package library;

import java.util.Random;

public class LibraryVisitor  implements Runnable{

    private Book book;
    private String name;
    public LibraryVisitor(int i) {
        this.book = takeBook();
        this.name = String.format("%d-й читатель", i);
    }

    @Override
    public void run() {
        int countBook = book.getBooksInHand();
        if (countBook == 1) {
            ConsoleHelper.print(String.format("%s взял %d книгу", name, countBook));
        } else {
            ConsoleHelper.print(String.format("%s взял %d книги", name, countBook));
        }
        Book.setCountBooks(book.getCountBooks() - countBook);
        ConsoleHelper.print("Количество оставшихся книг в библиотеке  - " + book.getCountBooks());

        ConsoleHelper.print(String.format("%s читает", name));
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
       ConsoleHelper.print(String.format("%s возвращает книги", name));
        Book.setCountBooks(book.getCountBooks() + countBook);
        ConsoleHelper.print("Количество оставшихся книг в библиотеке  - " + book.getCountBooks());
    }

    private Book takeBook(){
      //количество взятых книг
       int countBooks = new Random().nextInt(2) + 1;

       return new Book(countBooks);
    }

    public Book getBook() {
        return book;
    }

    public String getName() {
        return name;
    }
}
