package Object;

public class UsaPersona {
    public static void main(String[] args) {
        Persona p1 = new Persona("Stefano", "Fortezza", 25);
        Persona p2 = new Persona("Stefano", "Fortezza", 23);
        System.out.println(p1);

        System.out.println(p1.equals(p2)); //COMPARAZIONE
        System.out.println(p1 == p2);

        System.out.println(p1.hashCode());
        System.out.println(p2.hashCode());

    }
}
