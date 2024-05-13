package entity.ticket.rivenditore;

import entity.ticket.Ticket;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "rivenditori")
public abstract class Rivenditore {
    @Id
    @GeneratedValue
    private Integer id;
    @ManyToMany(mappedBy = "rivenditori")
    private List<Ticket> tickets;

    public Rivenditore() {
        this.tickets = new ArrayList<>();
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Rivenditore{" +
                "id=" + id +
                '}';
    }
}
