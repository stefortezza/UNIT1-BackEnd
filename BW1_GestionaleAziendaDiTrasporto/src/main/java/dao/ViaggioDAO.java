package dao;

import entity.tratta.Tratta;
import entity.tratta.Viaggio;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public void aggiornaTempoMedio() {
        HashMap<Tratta, List<Duration>> lista = new HashMap<>();
        em.createQuery("SELECT v FROM Viaggio v", Viaggio.class).getResultList().forEach(
                viaggio -> {
                    Tratta tratta = viaggio.getTratta();
                    Duration durata = viaggio.getPercorrenzaEffettiva();
                    List<Duration> listaNumerata = lista.get(tratta.getId());
                    if (listaNumerata == null) {
                        lista.put(tratta, new ArrayList<>(List.of(durata)));
                    } else {
                        listaNumerata.add(durata);
                        lista.put(tratta, listaNumerata);
                    }
                }
        );
        lista.forEach((tratta, valore) -> {
            Duration tempoTotale = Duration.ofDays(0);
            Duration tempoMedio;
            valore.forEach(tempoTotale::plus);
            tempoMedio = tempoTotale.dividedBy(valore.size());
            tratta.setPercorrenzaMedia(tempoMedio);
        });
    }
}
