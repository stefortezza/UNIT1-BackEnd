package entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "utente")
public class Utente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String cognome;
    @Column(name = "data_di_nascita")
    private LocalDate dataDiNascita;
    private int numeroDiTessera;

    @OneToMany(mappedBy = "utente", cascade = CascadeType.ALL)
    private List<Prestito> prestiti = new ArrayList<>();

    public Utente( String nome, String cognome, LocalDate dataDiNascita, int numeroDiTessera, List<Prestito> prestiti) {
        this.nome = nome;
        this.cognome = cognome;
        this.dataDiNascita = dataDiNascita;
        this.numeroDiTessera = numeroDiTessera;
        this.prestiti = prestiti;
    }

    public Utente() {
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

    public int getNumeroDiTessera() {
        return numeroDiTessera;
    }

    public void setNumeroDiTessera(int numeroDiTessera) {
        this.numeroDiTessera = numeroDiTessera;
    }

    public List<Prestito> getPrestiti() {
        return prestiti;
    }

    public void setPrestiti(List<Prestito> prestiti) {
        this.prestiti = prestiti;
    }


    @Override
    public String toString() {
        return "Utente{" +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", dataDiNascita=" + dataDiNascita +
                ", numeroDiTessera=" + numeroDiTessera +
                '}';
    }
}
