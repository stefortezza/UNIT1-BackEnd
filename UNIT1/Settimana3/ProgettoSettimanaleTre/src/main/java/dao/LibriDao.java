package dao;

import entity.Libri;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.time.LocalDate;
import java.util.List;

public class LibriDao {
    private EntityManager em;

    public LibriDao(EntityManager em) {
        this.em = em;
    }

    public void save(Libri libriDao) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(libriDao);
        et.commit();
    }

    public void delete(Long codiceISBN) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        Libri libro = getByCodiceISBN(codiceISBN);
        if (libro != null) {
            em.remove(libro);
        } else {
            System.out.println("Libro non trovato");
        }
        et.commit();
    }

    public Libri getByCodiceISBN(Long codiceISBN) {
        List<Libri> resultList = em.createQuery("SELECT l FROM Libri l WHERE l.codiceISBN = :codiceISBN", Libri.class)
                .setParameter("codiceISBN", codiceISBN)
                .getResultList();

        if (resultList.isEmpty()) {
            return null;
        } else {
            return resultList.get(0);
        }
    }

    public List<Libri> getByAnnoDiPubblicazione(int annoDiPubblicazione) {
        return em.createQuery("SELECT l FROM Libri l WHERE YEAR(l.annoPubblicazione) = :annoDiPubblicazione", Libri.class)
                .setParameter("annoDiPubblicazione", annoDiPubblicazione)
                .getResultList();
    }

    public List<Libri> getByAutore(String autore) {
        Query query = em.createQuery("select p from Libri p where p.autore= :autore");
        query.setParameter("autore", autore);
        return query.getResultList();
    }

    public List<Libri> getByTitolo(String titolo) {
        Query query = em.createQuery("SELECT t FROM Libri t WHERE t.titolo LIKE :titolo");
        query.setParameter("titolo", "%" + titolo + "%");
        return query.getResultList();
    }
}

