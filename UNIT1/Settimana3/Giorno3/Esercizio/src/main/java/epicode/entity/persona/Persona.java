package epicode.entity.persona;

import epicode.entity.partecipazione.Partecipazione;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
@Entity
@Table(name = "persone")
public class Persona {
    @Id
    @GeneratedValue
    private int id;
    private String Nome;
    private String Cognome;
    private String Email;
    @Column(name = "data_di_nascita")
    private LocalDate dataDiNascita;
    @Enumerated(EnumType.STRING)
    @Column(name = "sesso")
    private Sesso sesso;
    @OneToMany (mappedBy = "persona")
    private List<Partecipazione> partecipazioni;


    public Persona(int id, String nome, String cognome, String email, LocalDate dataDiNascita, Sesso sesso, List<Partecipazione> partecipazioni) {
        this.id = id;
        this.Nome = nome;
        this.Cognome = cognome;
        this.Email = email;
        this.dataDiNascita = dataDiNascita;
        this.sesso = sesso;
        this.partecipazioni = partecipazioni;
    }

    public Persona () {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getCognome() {
        return Cognome;
    }

    public void setCognome(String cognome) {
        Cognome = cognome;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public LocalDate getDataDiNascita() {
        return dataDiNascita;
    }

    public void setDataDiNascita(LocalDate dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }

    public Sesso getSesso() {
        return sesso;
    }

    public void setSesso(Sesso sesso) {
        this.sesso = sesso;
    }

    public List<Partecipazione> getPartecipazioni() {
        return partecipazioni;
    }

    public void setPartecipazioni(List<Partecipazione> partecipazioni) {
        this.partecipazioni = partecipazioni;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", Nome='" + Nome + '\'' +
                ", Cognome='" + Cognome + '\'' +
                ", Email='" + Email + '\'' +
                ", dataDiNascita=" + dataDiNascita +
                ", Sesso=" + sesso +
                '}';
    }
}
