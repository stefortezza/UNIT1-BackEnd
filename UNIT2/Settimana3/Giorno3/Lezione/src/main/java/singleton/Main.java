package singleton;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
//        CorsoEpicode corsoEpicode1 = new CorsoEpicode("Front-End", LocalDate.now(), 35, "Roma");

//        CorsoEpicode corsoEpicode2 = new CorsoEpicode("Back-End", LocalDate.now(), 35, "Roma");

        CorsoEpicode corsoEpicode1 = CorsoEpicode.getInstance();
        CorsoEpicode corsoEpicode2 = CorsoEpicode.getInstance();


        System.out.println(corsoEpicode1.hashCode());
        System.out.println(corsoEpicode2.hashCode());
    }
}
