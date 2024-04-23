package Map;

import Object.Persona;

public class usaAnagrafe {
    public static void main(String[] args) {
        Anagrafe anagrafe = new Anagrafe();

        Persona p1 = new Persona("Aldo", "Rossi", 25);
        Persona p2 = new Persona("Francesco", "Verdi", 24);
        Persona p3 = new Persona("Stefano", "Fortezza", 25);

        anagrafe.aggiungiPersona("LMKMJHNBJHNKA", p1);
        anagrafe.aggiungiPersona("UADGABDAJKDAD", p2);
        anagrafe.aggiungiPersona("ILKJJNAHAJAUK", p3);

        anagrafe.stampaAnagrafe();

    }
}
