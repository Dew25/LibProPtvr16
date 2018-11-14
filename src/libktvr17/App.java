/*
 * Class run application in do loop.
 * App worked while var repeat="r"
 */
package libktvr17;

import entity.Book;
import entity.History;
import entity.Reader;
import interfaces.Insertable;
import interfaces.Saveble;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Melnikov
 */
public class App {
    public List<Book> books = new ArrayList<>();
    public List<Reader> readers = new ArrayList<>();
    public List<History> histories = new ArrayList<>();
    public Insertable inserter = new ConsoleInserter();
    //SaverToFile необходимо реализовать через интерфейс Saveble
    //что то типа public Saveble saver = new SaverToFile();
    // и далее в коде использовать saver вместо saverToFile
    public Saveble saver;

    public App() {
        //this.saver = new SaverToFile();
        this.saver = new SaverToBase();
        this.books=saver.loadBooks();
        this.readers = saver.loadReaders();
        this.histories = saver.loadHistories();
    }
    

    public void run(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("--------Наша библиотека----------");
        String repeat = "r";
        do{
            System.out.println("Выберите нужное действие:");
            System.out.println("0 - для выхода из программы");
            System.out.println("1 - для добавления книги");
            System.out.println("2 - для добавления читателя");
            System.out.println("3 - для выдачи книги пользовтелю");
            System.out.println("4 - возвращение книги");
            String action = scanner.next();

            switch (action) {
                case "0":
                    repeat = "n";
                    break;
                case "1":
                    this.books.add(inserter.addBook());
                    saver.saveBooks(books);
                    System.out.println("Книга добавлена!");
                    break;
                case "2":
                    this.readers.add(inserter.addReader());
                    saver.saveReaders(readers);
                    System.out.println("Читатель добавлен!");
                    break; 
                case "3":
                    this.histories.add(inserter.takeBook(books,readers));
                    saver.saveHistories(histories);
                    System.out.println("Книга выдана пользователю!");
                    break;
                case "4":
                    this.histories.add(inserter.backBook(histories));
                    saver.saveHistories(histories);
                    System.out.println("Книга возвращена в библиотеку!");
                    break;

                default:
                    System.out.println("Выберите действие из списка!");
                    System.out.println("----------------------------");
                    repeat="r";
            }
        
        }while("r".equals(repeat));
    }
    
}
