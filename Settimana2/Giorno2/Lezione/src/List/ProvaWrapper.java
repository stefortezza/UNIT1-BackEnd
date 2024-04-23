package List;

public class ProvaWrapper {
    public static void main(String[] args) {
        //CLASSI WRAPPER
        //Byte, Short, Integer, Long, Float, Double, Character, Boolean: SERVONO PER POTER UTILZIZARE I PRIMITIVI
        //COME CLASSI, QUINDI UTILIZZARLI DENTRO I GENERICS.

        Integer iObject = 4;

        int i = iObject;

        System.out.println(i); //4

        int j = Integer.parseInt("123"); //il metodo PARSE TRASFORMA il tutto in STRINGA!

        System.out.println(j); //123

        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);
    }
}
