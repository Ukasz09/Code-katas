package src.main.java;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LambadaExercises {
    private static final int DEFAULT_LITERALS_QTY = 4;

    public static void sortWithLambda(int literalsQty) {
        List<String> collection = makeCollection(literalsQty);

        sortLiteralsCollectionByNaturalOrder(collection);
        printCollection(collection, "Sorted natural order: ");

        sortLiteralsCollectionByReversOrder(collection);
        printCollection(collection, "Sorted revers order: ");

        sortLiteralsCollectionByLength(collection);
        printCollection(collection, "Sorted natural by length order: ");

        sortLiteralsCollectionByQtyOfALiteral(collection);
        printCollection(collection, "Sorted natural order by qty of 'a' / 'A' literals in word: ");
    }

    private static List<String> makeCollection(int elementsQty) {
        if (elementsQty <= 0)
            elementsQty = DEFAULT_LITERALS_QTY;
        Scanner scanner = new Scanner(System.in);
        List<String> collection = new LinkedList<>();
        for (int i = 0; i < elementsQty; i++) {
            System.out.print("Write any string literal: ");
            collection.add(scanner.nextLine());
        }
        return collection;
    }

    public static void sortLiteralsCollectionByNaturalOrder(List<String> collection) {
        collection.sort(String::compareTo);
    }

    public static void sortLiteralsCollectionByReversOrder(List<String> collection) {
        collection.sort((o1, o2) -> (-1) * o1.compareTo(o2));
    }

    public static void sortLiteralsCollectionByLength(List<String> collection) {
        collection.sort(Comparator.comparingInt(String::length));
    }

    //from less to more
    public static void sortLiteralsCollectionByQtyOfALiteral(List<String> collection) {
        Function<String, Integer> amountOfA = (String w1) -> {
            int aQty = 0;
            for (int i = 0; i < w1.length(); i++)
                aQty = ('a' == w1.charAt(i) || 'A' == w1.charAt(i)) ? aQty + 1 : aQty;
            return aQty;
        };

        collection.sort(Comparator.comparingInt(amountOfA::apply));
    }

    public static void printCollection(List<String> collection, String textBeforePrintingCollection) {
        System.out.println("\n" + textBeforePrintingCollection);
        collection.forEach(n -> System.out.print(n + " "));
    }

    public static <T> boolean equalsWithLambda(T object1, T object2) {
        Predicate<T> predicate = object1::equals;
        return predicate.test(object2);
    }

    public static Human getHumanInstanceByLambda(int age, String name) {
        BiFunction<Integer, String, Human> humanCreator = Human::new;
        return humanCreator.apply(age, name);
    }

    public static Map<String, Integer> wordCounter(String text) {
        Map<String, Integer> wordCount = new HashMap<>();
        Arrays.stream(text.split(" "))
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(Function.identity()))
                .forEach((k,v)->wordCount.put(k,v.size()));
        return wordCount;
    }
}
