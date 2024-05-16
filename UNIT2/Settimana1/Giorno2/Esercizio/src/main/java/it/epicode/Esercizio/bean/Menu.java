package it.epicode.Esercizio.bean;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
public class Menu {
    @Autowired
    private List<Ingrediente> ingredienti;

    @Autowired
    private List<Bevanda> bevande;

    @Autowired
    private List<Pizza> pizze;

    public void stampaMenu() {
        System.out.println("Menu");
        System.out.println("Bevande");
        bevande.forEach(bevanda -> System.out.println(bevanda.getNome() + " ml " + bevanda.getMl() +
                "   Kcal: " + bevanda.getCalorie() + "   prezzo: " + bevanda.getPrezzo()));

        System.out.println();
        System.out.println("Ingredienti");
        ingredienti.forEach(ingrediente -> System.out.println(ingrediente.getNome() +
                "   Kcal: " + ingrediente.getCalorie() + "   prezzo: " + ingrediente.getPrezzo()));

        System.out.println();
        System.out.println("Pizze");
        pizze.forEach(pizza -> System.out.println(pizza.getNome() +
                "   Kcal: " + pizza.getCalorie() + "   prezzo: " + pizza.getPrezzo()));
        ;
    }
}
