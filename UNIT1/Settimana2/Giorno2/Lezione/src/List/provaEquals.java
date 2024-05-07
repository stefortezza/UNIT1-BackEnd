package List;

import Object.Persona;

import java.util.ArrayList;

public class provaEquals {
    public static void main(String[] args) {
        ArrayList<Persona> persone = new ArrayList<>();

        Persona p1 = new Persona("Stefano", "Fortezza", 25);
        Persona p2 = new Persona("Rossi", "Stefano", 24);
        Persona p3 = new Persona("Mario", "Bianchi", 26);
        Persona p4 = new Persona("Francesco", "Verdi", 28);
        Persona p5 = new Persona("Francesco", "Verdi", 28);


        persone.add(p1);
        persone.add(p2);
        persone.add(p3);
        persone.add(p4);

        System.out.println(persone.contains(p5)); //TRUE SE LO TROVA, FALSE SE NON LO TROVA
    }
}
