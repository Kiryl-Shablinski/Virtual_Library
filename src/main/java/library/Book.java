package library;
//    Всего в библиотеке 100 книг
//    Человек может брать только 3 книги на руки
//    В читальном зале место только для семи человек
//    Пришло 60 человек. Использовать java.util.concurrent
public class Book {
    private static int countBooks = 100;
    private int booksInHand;

    public Book(int booksInHand) {
        this.booksInHand = booksInHand;    }

    public int getCountBooks() {
        return countBooks;
    }

    public static void setCountBooks(int countBooks) {
        Book.countBooks = countBooks;
    }

    public int getBooksInHand() {
        return booksInHand;
    }
}
