package dao;

import entity.ElementoPrestato;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;


public class ElementoPrestatoDao {
    private EntityManager em;

    public ElementoPrestatoDao(EntityManager em) {
        this.em = em;
    }

    public void save(ElementoPrestato ElementoPrestato) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(ElementoPrestato);
        et.commit();
    }

    public void delete(int id) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        ElementoPrestato elementoPrestato = getById(id);
        if (elementoPrestato != null) {
            em.remove(elementoPrestato);
        } else {
            System.out.println("Elemento Prestato non trovato");
        }
        et.commit();
    }

    public ElementoPrestato getById(int id) {
        return em.find(ElementoPrestato.class, id);
    }

}
