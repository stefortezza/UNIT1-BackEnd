package Set;

import Object.Persona;

import java.util.HashSet;

public class provaSet {
    public static void main(String[] args) {
        HashSet<Persona> persone = new HashSet<Persona>();

        Persona p1 = new Persona("Stefano", "Fortezza", 25);
        Persona p2 = new Persona("Rossi", "Stefano", 24);
        Persona p3 = new Persona("Mario", "Bianchi", 26);
        Persona p4 = new Persona("Francesco", "Verdi", 28);
        Persona p5 = new Persona("Francesco", "Verdi", 28);

        persone.add(p1);
        persone.add(p2);
        persone.add(p3);
        persone.add(p4);

        System.out.println(persone);

        persone.add(p5);

        System.out.println(persone); //NONOSTANTE HO AGGIUNGO IL P5, NON LO TROVO PERCHE' ELIMINA GLI OGGETTI UGUALI.
        //UGUALI CON LO STESSO NOME, COGNOME ED ETA - DATI PRESI DA EQUALS DI PERSONA.

        for (Persona p : persone) {
            System.out.println(p);
        }
    }
}
