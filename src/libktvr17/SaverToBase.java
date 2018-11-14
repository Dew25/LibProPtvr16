/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libktvr17;

import entity.Book;
import entity.History;
import entity.Reader;
import interfaces.Saveble;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author Melnikov
 */
public class SaverToBase implements Saveble{
    private EntityManager em;
    private EntityTransaction tx;

    public SaverToBase() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("LibProPtvr16PU");
        this.em = emf.createEntityManager();
        this.tx = em.getTransaction();
    }
    
    @Override
    public void saveHistories(List<History> histories) {
        int n = histories.size();
        this.tx.begin();
        for(int i=0;i<n;i++){
            if(histories.get(i).getId() == null){
               em.persist(histories.get(i)); 
            }else{
               em.merge(histories.get(i));
            }
        }
        this.tx.commit();
    }

    @Override
    public void saveReaders(List<Reader> readers) {
        int n = readers.size();
        this.tx.begin();
        for(int i=0;i<n;i++){
            if(readers.get(i).getId() == null){
               em.persist(readers.get(i)); 
            }else{
               em.merge(readers.get(i));
            }
        }
        this.tx.commit();
    }

    @Override
    public void saveBooks(List<Book> books) {
        int n = books.size();
        this.tx.begin();
        for(int i=0;i<n;i++){
            if(books.get(i).getId() == null){
               em.persist(books.get(i)); 
            }else{
               em.merge(books.get(i));
            }
            
        }
        this.tx.commit();
    }

    @Override
    public List<History> loadHistories() {
        List<History> listHistory = em.createQuery("SELECT h FROM History h").getResultList();
        return listHistory;
    }
    @Override
    public List<Reader> loadReaders() {
        List<Reader> listReader = em.createQuery("SELECT r FROM Reader r").getResultList();
        return listReader;
    }

    @Override
    public List<Book> loadBooks() {
        List<Book> listBook = em.createQuery("SELECT b FROM Book b").getResultList();
        return listBook;
    }
    
}
