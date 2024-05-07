package dao;

import entity.Libri;
import entity.Riviste;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class RivisteDao {
    private EntityManager em;

    public RivisteDao(EntityManager em) {
        this.em = em;
    }

    public void save(Riviste rivisteDao) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(rivisteDao);
        et.commit();
    }

    public void delete(Long codiceISBN) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        Riviste riviste = getByCodiceISBN(codiceISBN);
        if (riviste != null) {
            em.remove(riviste);
        } else {
            System.out.println("Libro non trovato");
        }
        et.commit();
    }

    public Riviste getByCodiceISBN(Long codiceISBN) {
        List<Riviste> resultList = em.createQuery("SELECT l FROM Riviste l WHERE l.codiceISBN = :codiceISBN", Riviste.class)
                .setParameter("codiceISBN", codiceISBN)
                .getResultList();

        if (resultList.isEmpty()) {
            return null;
        } else {
            return resultList.get(0);
        }
    }

    public List<Riviste> getByAnnoDiPubblicazione(int annoDiPubblicazione) {
        return em.createQuery("SELECT l FROM Riviste l WHERE YEAR(l.annoPubblicazione) = :annoDiPubblicazione", Riviste.class)
                .setParameter("annoDiPubblicazione", annoDiPubblicazione)
                .getResultList();
    }


}
