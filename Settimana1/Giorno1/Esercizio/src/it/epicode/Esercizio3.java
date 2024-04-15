package it.epicode;

import java.util.Scanner;

public class Esercizio3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.println("Inserisci un numero");
        int pariDispari = pariDispari(scanner.nextInt());

        System.out.println("Inserisci due numeri decimali");
        double x = scanner.nextDouble();
        double y = scanner.nextDouble();
        double perimetro = perimetroReggangolo(x, y);
        System.out.println("Il perimetro del rettangolo è: " + perimetro);

        System.out.println("Inserisci tre numeri decimali per calcolare l'Area del Triangolo");
        double la = scanner.nextDouble();
        double lb = scanner.nextDouble();
        double lc= scanner.nextDouble();
        double areaTriangolo = areaTriangolo(la, lb, lc);
        System.out.println("L'area del Triangolo è: " + areaTriangolo);
    }

    public static double perimetroReggangolo(double x, double y) {
        double q = (2 * x + 2 * y) / 2;
        return q;
    }

    public static double areaTriangolo(double la, double lb, double lc) {
        double k = (la + lb + lc) / 2;
        double s = Math.sqrt(k * (k - la) * (k - lb) * (k - lc));
        return s;
    }

    public static int pariDispari(int a) {
        System.out.println("il numero inserito è " + (a % 2 == 0 ? "pari" : "dispari"));
        return a % 2 == 0 ? a : a + 1;
    }
}
