package dao;

import entity.tratta.Viaggio;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class ViaggioDAO {
    private EntityManager em;

    public ViaggioDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Viaggio viaggio) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(viaggio);
        et.commit();
    }

    public Viaggio getById(Integer id) {
        return em.find(Viaggio.class, id);
    }

    public void update(Viaggio viaggio) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(viaggio);
        et.commit();
    }

    public List<Viaggio> findAll() {
        return em.createQuery("SELECT v FROM Viaggio v", Viaggio.class).getResultList();
    }

    public void delete(Viaggio viaggio) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(viaggio);
        et.commit();
    }
}
