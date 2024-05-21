package it.epicode.Esercizio.bean;

import it.epicode.Esercizio.enums.StatoOrdine;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class Ordine {
    private int numeroOrdine;
    private StatoOrdine statoOrdine;
    private int numeroCoperti;
    private LocalDateTime dataAcquisizione;
    private Tavolo tavolo;
    private List<Bevanda> bevande;
    private List<Ingrediente> ingredienti;
    private List<Pizza> pizze;

    public double prezzoTotale() {
        double totale = bevande.stream().mapToDouble(Bevanda::getPrezzo).sum();
        totale += ingredienti.stream().mapToDouble(Ingrediente::getPrezzo).sum();
        totale += pizze.stream().mapToDouble(Pizza::getPrezzo).sum();
        totale += tavolo.getCoperto() * numeroCoperti;
        return totale;
    }

    public Ordine(int numeroCoperti, Tavolo tavolo) throws Exception {
        if (numeroCoperti <= tavolo.getNumeroCopertiMassimi()) {
            this.numeroCoperti = numeroCoperti;
            this.tavolo = tavolo;
        } else {
            throw new Exception("Numero coperti superiore ai coperti del tavolo");
        }
    }

    public void stampaOrdine() {
        System.out.println("Ordine" + numeroOrdine);
        System.out.println("Bevande");
        bevande.forEach(bevanda -> System.out.println(bevanda.getNome() + " ml " + bevanda.getMl() +
                "   prezzo: " + bevanda.getPrezzo()));

        System.out.println();
        System.out.println("Ingredienti");
        ingredienti.forEach(ingrediente -> System.out.println(ingrediente.getNome() +
                "   prezzo: " + ingrediente.getPrezzo()));

        System.out.println();
        System.out.println("Pizze");
        pizze.forEach(pizza -> System.out.println(pizza.getNome() +
                "   prezzo: " + pizza.getPrezzo()));
        System.out.println();
        System.out.println("Prezzo totale: " + prezzoTotale());
    }
}

    