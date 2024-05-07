package Map;

import Object.Persona;

import java.util.HashMap;
import java.util.Set;

public class Anagrafe {

    private HashMap<String, Persona> anagrafe;

    public Anagrafe() {
        anagrafe = new HashMap<>();
    }

    public void aggiungiPersona(String cf, Persona persona) {
        anagrafe.put(cf, persona);
    }

    public void rimuoviPersona(String cf) {
        anagrafe.remove(cf);
    }

    public Persona cercaPerCodiceFiscale(String cf) {
        return anagrafe.get(cf); //NULL SE NON TROVA NESSUNO.
    }

    public void stampaAnagrafe() {
        Set<String> chiavi = anagrafe.keySet();

        for (String cf : chiavi) {
            System.out.println(cf + ": " + anagrafe.get(cf));
        }
    }
}
