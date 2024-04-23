package Set;

import Object.Persona;

import java.util.Comparator;
import java.util.TreeSet;

public class provaSortedSet {
    public static void main(String[] args) {
        TreeSet<Persona> persone = new TreeSet<Persona>(new Comparator<Persona>() {
            @Override
            public int compare(Persona o1, Persona o2) {
                return o1.getNome().compareTo(o2.getNome()); //IN QUESTO VENGONO ORDINATI IN BASE AL NOME! DALLA A ALLA Z
            }
        });

        Persona p1 = new Persona("Aldo", "Fortezza", 25);
        Persona p2 = new Persona("Rossi", "Stefano", 24);
        Persona p3 = new Persona("Mario", "Bianchi", 26);
        Persona p4 = new Persona("Francesco", "Verdi", 28);
        Persona p5 = new Persona("Bruno", "Verdi", 28);

        persone.add(p1);
        persone.add(p2);
        persone.add(p3);
        persone.add(p4);
        persone.add(p5);

        System.out.println(persone);
    }
}
