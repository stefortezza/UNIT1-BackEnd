package dao;

import entity.mezzo.Mezzo;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class MezzoDAO {
    private EntityManager em;

    public MezzoDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Mezzo mezzo) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(mezzo);
        et.commit();
    }

    public Mezzo getById(Integer id) {
        return em.find(Mezzo.class, id);
    }

    public void update(Mezzo mezzo) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(mezzo);
        et.commit();
    }

    public List<Mezzo> findAll() {
        return em.createQuery("SELECT m FROM Mezzo m", Mezzo.class).getResultList();
    }

    public void delete(Mezzo mezzo) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(mezzo);
        et.commit();
    }
}
