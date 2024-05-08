package dao;

import entity.mezzo.Mezzo;
import entity.tratta.Tratta;

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

    public Integer contaTratte(Mezzo mezzo, Tratta tratta) {
        return mezzo.getViaggi().stream()
                .filter(viaggio -> viaggio.getTratta().getId().equals(tratta.getId()))
                .toList().size();
    }
}
