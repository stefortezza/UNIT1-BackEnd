package dao;

import entity.Utente;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class UtenteDao {
    private EntityManager em;

    public UtenteDao(EntityManager em) {
        this.em = em;
    }

    public void save(Utente utenteDao) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(utenteDao);
        et.commit();
    }

    public void delete(int id) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        UtenteDao utenteDao = getById(id);
        if (utenteDao != null) {
            em.remove(utenteDao);
        } else {
            System.out.println("Elemento Prestato non trovato");
        }
        et.commit();
    }

    public UtenteDao getById(int id) {
        return em.find(UtenteDao.class, id);
    }

}
