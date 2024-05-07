package Lambda;

import java.util.ArrayList;
import java.util.List;

public class ProvaLambdaQuattro {
    public static void main(String[] args) {
        List<Integer> numeriImmutabile = List.of(2, 3, 4, 7, 1, 9, 34, 78);

        ArrayList<Integer> numeri = new ArrayList<>(numeriImmutabile);

        numeri.sort((o1, o2) -> o1.compareTo(o2));

        numeri.forEach(integer -> System.out.println(integer));

        System.out.println();

        numeri.replaceAll(integer -> integer + 10);

        numeri.forEach(integer -> System.out.println(integer));

    }
}
