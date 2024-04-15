package it.epicode;

import java.util.Scanner;

public class Operatori {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in); //RAPPRESENTA L'INPUT DEL NOSTRO PC DI DEFOULT, OVVERO LA TASTIERA.

        System.out.println("Inserisci un numero");
        int x = scanner.nextInt(); //INIZIALMENTE ERA COSI' => int x = 5;
        System.out.println("Inserisci un'altro numero");
        int y = scanner.nextInt(); //INIZIALMENTE ERA COSI' => int x = 2;

        scanner.nextLine();

        System.out.println("Inserisci una parola");
        String s = scanner.nextLine();

        System.out.println(s);

        int z = x%y;

        System.out.println(x%y);

        x++; //SIGNIFICA INCREMENTARE DI 1 IL VALORE DELLA X; X=X+1;

        System.out.println(x);

        boolean b1 = true;
        boolean b2 = false;

        System.out.println(b1 & b2);

        System.out.println(b1 || b2);

        System.out.println(!b1);

         int somma = somma(5, 6);

        System.out.println(somma);

        concatena("Java ", 22);
    }

    public static int somma (int a, int b) { //QUESTO METODO E' RICHIAMABILE DAL MAIN, INSERENDO STATIC
        int c = a + b;
        return c;
    }

    public  static void concatena (String s, int a) {
        System.out.println( s + a);
    }

}
