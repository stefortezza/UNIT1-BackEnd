package dao;

import entity.ElementoPrestato;
import entity.Prestito;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.time.LocalDate;
import java.util.List;

public class PrestitoDao {
    private EntityManager em;

    public PrestitoDao(EntityManager em) {
        this.em = em;
    }

    public void save(Prestito prestitoDao) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(prestitoDao);
        et.commit();
    }

    public void delete(int id) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        PrestitoDao prestitoDao = getById(id);
        if (prestitoDao != null) {
            em.remove(prestitoDao);
        } else {
            System.out.println("Prestito non trovato");
        }
        et.commit();
    }

    public PrestitoDao getById(int id) {
        return em.find(PrestitoDao.class, id);
    }

    public List<Prestito> getElementiInPrestitoByNumeroTessera(int numeroDiTessera) {
        Query query = em.createQuery("SELECT e FROM Prestito e JOIN e.utente u WHERE u.numeroDiTessera = :numeroDiTessera");
        query.setParameter("numeroDiTessera", numeroDiTessera);
        return query.getResultList();
    }

    public List<Prestito> getPrestitiScadutiNonRestituiti() {
        LocalDate oggi = LocalDate.now();
        Query query = em.createQuery("SELECT p FROM Prestito p WHERE p.dataRestituzionePrevista < :oggi AND p.dataRestituzioneEffettiva IS NULL");
        query.setParameter("oggi", oggi);
        return query.getResultList();
    }
}
