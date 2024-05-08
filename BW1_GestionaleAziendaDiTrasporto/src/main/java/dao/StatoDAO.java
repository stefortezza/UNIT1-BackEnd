package dao;

import entity.mezzo.StatoMezzo;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class StatoDAO {
    private EntityManager em;

    public StatoDAO(EntityManager em) {
        this.em = em;
    }

    public void save(StatoMezzo statoMezzo) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(statoMezzo);
        et.commit();
    }

    public StatoMezzo getById(Integer id) {
        return em.find(StatoMezzo.class, id);
    }

    public void update(StatoMezzo statoMezzo) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(statoMezzo);
        et.commit();
    }

    public List<StatoMezzo> findAll() {
        return em.createQuery("SELECT sm FROM StatoMezzo sm", StatoMezzo.class).getResultList();
    }

    public void delete(StatoMezzo statoMezzo) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(statoMezzo);
        et.commit();
    }
}
