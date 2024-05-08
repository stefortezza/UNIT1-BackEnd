package dao;

import entity.ticket.rivenditore.DistributoreAutomatico;
import entity.ticket.rivenditore.Rivenditore;
import entity.ticket.rivenditore.RivenditoreAutorizzato;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.HashMap;
import java.util.List;

public class RivenditoreDAO {
    private EntityManager em;

    public RivenditoreDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Rivenditore rivenditore) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(rivenditore);
        et.commit();
    }

    public Rivenditore getById(Integer id) {
        return em.find(Rivenditore.class, id);
    }

    public void update(Rivenditore rivenditore) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(rivenditore);
        et.commit();
    }

    public List<Rivenditore> findAll() {
        return em.createQuery("SELECT r FROM Rivenditore r", Rivenditore.class).getResultList();
    }

    public HashMap<String, Integer> findNumTicketFromRivenditore() {
        HashMap<String, Integer> numTicketRivenditore = new HashMap<>();
        em.createQuery("SELECT r FROM Rivenditore r", Rivenditore.class)
                .getResultList()
                .forEach(rivenditore -> {
                    if (rivenditore instanceof RivenditoreAutorizzato) {
                        numTicketRivenditore.put(((RivenditoreAutorizzato) rivenditore).getNomeRivenditore()+" n°"+rivenditore.getId(), rivenditore.getTickets().size());
                    } else if (rivenditore instanceof DistributoreAutomatico) {
                        numTicketRivenditore.put("Distributore Automatico n°"+rivenditore.getId(), rivenditore.getTickets().size());
                    }
                });
        return numTicketRivenditore;
    }

    public void delete(Rivenditore rivenditore) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(rivenditore);
        et.commit();
    }
}
