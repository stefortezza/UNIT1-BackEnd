package composite;

public class Main {
    public static void main(String[] args) {
        Libro libro1 = new Libro("LibroA", 5, 200);
        Libro libro2 = new Libro("LibroB", 6, 300);
        Libro libro3 = new Libro("LibroC", 7, 150);
        Libro libro4 = new Libro("LibroD", 8, 230);
        Libro libro5 = new Libro("LibroE", 9, 210);
        Libro libro6 = new Libro("LibroF", 10, 280);
        Libro libro7 = new Libro("LibroG", 11, 120);
        Libro libro8 = new Libro("LibroH", 12, 150);
        Libro libro9 = new Libro("LibroI", 13, 210);
        Libro libro10 = new Libro("LibroL", 14, 200);

        Scatolo scatolo1 = new Scatolo("Scatolo1");
        Scatolo scatolo2 = new Scatolo("Scatolo2");
        Scatolo scatolo3 = new Scatolo("Scatolo3");
        Scatolo scatolo4 = new Scatolo("Scatolo4");

        scatolo4.add(libro1);
        scatolo4.add(libro2);
        scatolo4.add(libro3);

        scatolo3.add(libro4);
        scatolo3.add(libro5);
        scatolo3.add(libro6);

        scatolo2.add(libro7);
        scatolo2.add(libro8);
        scatolo2.add(libro9);

        scatolo1.add(libro10);
        scatolo1.add(scatolo2);
        scatolo1.add(scatolo3);
        scatolo1.add(scatolo4);

        System.out.println(scatolo1.getPrezzo());
        System.out.println(scatolo1.getPeso());

    }
}
