import java.security.InvalidParameterException;
import java.util.*;
import java.util.stream.IntStream;

public class OddConcurrencesInArray {
    public static int findOddNumberByUsingLambadas(int[] arr) {
        if (arr.length % 2 == 0)
            throw new InvalidParameterException("Array can not be even size");
        for (int value : arr)
            if (numberQtyInArr(arr, value) % 2 != 0)
                return value;
        throw new InvalidParameterException("One number in arr should dont have a pair");
    }

    private static int numberQtyInArr(int[] arr, int searchedNumber) {
        return (int) IntStream.of(arr).filter(numb -> numb == searchedNumber).count();
    }

    public static int findOddNumberIteratively(int[] arr) {
        if (arr.length % 2 == 0)
            throw new InvalidParameterException("Array can not be even size");
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for (int value : arr) {
            Integer countQty;
            if ((countQty = countMap.get(value)) == null)
                countQty = 0;
            countMap.put(value, countQty + 1);
        }

        for (Map.Entry<Integer, Integer> entry : countMap.entrySet())
            if (entry.getValue() % 2 != 0)
                return entry.getKey();
        throw new InvalidParameterException("One number in arr should dont have a pair");
    }

    public static int findOddNumberEffective(int[] A) {
        if (A.length % 2 == 0)
            throw new InvalidParameterException("Array can not be even size");
        HashSet<Integer> tmp = new HashSet<>();
        for (int value : A)
            if (tmp.contains(value))
                tmp.remove(value);
            else tmp.add(value);
        if (tmp.isEmpty())
            throw new InvalidParameterException("One number in arr should dont have a pair");
        return tmp.iterator().next();
    }
}