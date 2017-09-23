package further.set;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetMain {
    public static void main(String[] args) {
        Set<Integer> squares = new HashSet<>();
        Set<Integer> cubes = new HashSet<>();

        for (int i = 1; i <= 100; i++) {
            squares.add(i * i);
            cubes.add(i * i * i);
        }

        System.out.println("There are " + squares.size() + " squares");
        System.out.println("There are " + cubes.size() + " cubes");

        Set<Integer> union = new HashSet<>(squares);
        union.addAll(cubes);
        System.out.println();
        System.out.println("There are " + union.size() + " elements in union");

        Set<Integer> intersection = new HashSet<>(squares);
        intersection.retainAll(cubes);

        System.out.println();
        System.out.println("There are " + intersection.size() + " elements in intersection");

        intersection.forEach(i -> {
            System.out.println(i + " is the square of " + Math.sqrt(i) + " and the cube of " + Math.cbrt(i));
        });

        Set<String> words = new HashSet<>();
        String[] arrayWords = "the quick brown fox jumps over the lazy dog".split(" ");
        words.addAll(Arrays.asList(arrayWords)); // an array added into a set

        words.forEach(word -> {
            System.out.println(word);
        });

        Set<String> nature = new HashSet<>();
        Set<String> divine = new HashSet<>();
        String[] arrayNatureWords = { "all", "nature", "is", "but", "art", "unknown", "to", "thee" };
        nature.addAll(Arrays.asList(arrayNatureWords));

        String[] arrayDivineWords = { "to", "err", "is", "human", "to", "forgive", "is", "divine" };
        divine.addAll(Arrays.asList(arrayDivineWords));

        System.out.println();

        System.out.println("nature - divine");
        Set<String> diff1 = new HashSet<>(nature);
        diff1.removeAll(divine);
        printSet(diff1);

        System.out.println("divine - nature");
        Set<String> diff2 = new HashSet<>(divine);
        diff2.removeAll(nature);
        printSet(diff2);
        System.out.println();

        Set<String> unionTest = new HashSet<>(nature);
        unionTest.addAll(divine); // all together
        Set<String> intersectionTest = new HashSet<>(nature);
        intersectionTest.retainAll(divine); // occur in both

        System.out.println("Symmetric Difference is removing intersection from union");
        unionTest.removeAll(intersectionTest);
        printSet(unionTest);

        if (nature.containsAll(divine)){
            System.out.println("divine is a subset of nature");
        } else {
            System.out.println("divine is NOT a subset of nature");
        }

        if (nature.containsAll(intersectionTest)){
            System.out.println("Intersection is a subset of nature");
        }

        if (divine.containsAll(intersectionTest)){
            System.out.println("Intersection is a subset of divine");
        }

    }

    private static void printSet(Set<String> theSet){
        System.out.print("\t");
        theSet.forEach( entry -> System.out.print(entry + " "));
        System.out.println();
    }


}
