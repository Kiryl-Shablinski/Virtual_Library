package library;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//   Всего в библиотеке 100 книг
//   Человек может брать только 3 книги на руки
//   В читальном зале место только для семи человек
//   Пришло 60 человек. Использовать java.util.concurrent
public class Library {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(7);
        //создаем читателей
        for (int i = 1; i <= 60; i++) {
            es.execute(new LibraryVisitor(i));
        }
        Thread.sleep(1000);
        es.shutdown();
    }
}
