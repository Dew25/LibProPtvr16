/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import entity.Book;
import java.util.Scanner;

/**
 *
 * @author Melnikov
 */
public class BookCreator {
    
    public Book add(){
        Book book = new Book();
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- Добавление книги ----");
        System.out.println("Название книги:");
        book.setName(scanner.nextLine());
        System.out.println("Автор: ");
        book.setAuthor(scanner.nextLine());
        System.out.println("ISBN:");
        book.setIsbn(scanner.nextLine());
        System.out.println(book.toString());
        System.out.println("Для добавления книги нажмите 1");
        int n=scanner.nextInt();
        if(n==1){
            return book;
        }else{
            return null;
        }
        
    }
    
}
