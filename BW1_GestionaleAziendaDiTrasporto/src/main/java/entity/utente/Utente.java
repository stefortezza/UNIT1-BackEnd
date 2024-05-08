package entity.utente;

import enums.Sesso;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="utenti")
public class Utente {
    @Id
    @GeneratedValue
    private Integer id;
    private String nome;
    private String cognome;
    @Column(name="data_di_nascita")
    private LocalDate dataDiNascita;
    private String email;
    @Column(name="numero_telefono")
    private String numeroTelefono;
    @Enumerated(EnumType.STRING)
    private Sesso sesso;

    public Utente(String nome, String cognome, LocalDate dataDiNascita, String email, String numeroTelefono, Sesso sesso) {
        this.nome = nome;
        this.cognome = cognome;
        this.dataDiNascita = dataDiNascita;
        this.email = email;
        this.numeroTelefono = numeroTelefono;
        this.sesso = sesso;
    }

    public Utente() {

    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public LocalDate getDataDiNascita() {
        return dataDiNascita;
    }

    public void setDataDiNascita(LocalDate dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public Sesso getSesso() {
        return sesso;
    }

    public void setSesso(Sesso sesso) {
        this.sesso = sesso;
    }

    @Override
    public String toString() {
        return "Utente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", dataDiNascita=" + dataDiNascita +
                ", email='" + email + '\'' +
                ", numeroTelefono='" + numeroTelefono + '\'' +
                ", sesso=" + sesso +
                '}';
    }
}
