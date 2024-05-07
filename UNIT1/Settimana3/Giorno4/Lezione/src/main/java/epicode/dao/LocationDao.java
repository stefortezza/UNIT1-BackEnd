package epicode.dao;

import epicode.entity.location.Location;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class LocationDao {
    private EntityManager em;

    //INSERIMENTO DEL COSTRUTTORE
    public LocationDao(EntityManager em) {
        this.em = em;
    }

    //INSERIMETNO DI UN EVENTO
    public void save(Location location) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(location);
        et.commit();
    }

    //ELIMINAZIONE DI UN EVENTO
    public void delete(int id) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        Location location = getById(id);
        if (location != null) {
            em.remove(location);
        } else {
            System.out.println("Location non presente");
        }
        et.commit();
    }

    //RICERCA DI UN EVENTO IN BASE AL SUO ID
    public Location getById(int id) {
        return em.find(Location.class, id);
    }
}
