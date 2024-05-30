package adapter;

public class Main {
    public static void main(String[] args) {
        Quadrato quadrato = new Quadrato(8);
        Triangolo triangolo = new Triangolo(4,7,9);
        Rettangolo rettangolo = new Rettangolo(3,7);
        FiguraGeometricaAdapter rettangoloAdapter = new FiguraGeometricaAdapter(rettangolo);

        CalcolatoreFigure calcolatoreFigure = new CalcolatoreFigure();
        calcolatoreFigure.add(quadrato);
        calcolatoreFigure.add(triangolo);
        calcolatoreFigure.add(rettangoloAdapter);

        System.out.println(calcolatoreFigure.perimetroTotale());
        System.out.println(calcolatoreFigure.areaTotale());
    }
}
