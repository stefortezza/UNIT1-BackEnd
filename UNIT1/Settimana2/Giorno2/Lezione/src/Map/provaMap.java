package Map;

import Object.Persona;

import java.util.HashMap;
import java.util.Set;

public class provaMap {
    public static void main(String[] args) {
        HashMap<String, Persona> anagrafe = new HashMap<>();

        Persona p1 = new Persona("Aldo", "Fortezza", 25);
        Persona p2 = new Persona("Rossi", "Stefano", 24);
        Persona p3 = new Persona("Mario", "Bianchi", 26);
        Persona p4 = new Persona("Francesco", "Verdi", 28);
        Persona p5 = new Persona("Bruno", "Verdi", 28);

        anagrafe.put("PPLOIHBGHJAGHYAH", p1); //per inserire un qualsiasi cosa, si utilizza il metodo PUT!!
        anagrafe.put("FNGJAODKAO10DLDR", p2);
        anagrafe.put("UAUDAYDMCLAMDAID", p3);

        anagrafe.get("FAFDADADA"); //POSSIAMO ESTRARRE LA PERSONA CON IL CODICE FISCALE CHE SCRIVO;
        System.out.println(anagrafe.get("UAUDAYDMCLAMDAID"));

        //CERCARE IL CODICE FISCALE COLLEGATO A p2
        Set<String> codiciFiscali = anagrafe.keySet();
        for (String chiave : codiciFiscali) {
            Persona p = anagrafe.get(chiave);
            if (/*p.equals(p2)*/ p == p2) {
                System.out.println(chiave);
            }
        }
    }
}
