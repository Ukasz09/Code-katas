package main.java;

import java.util.*;

public class OnlyUniqueNumbers {
    public static Integer[] getArrWithOnlyUniqueValue(Integer[] arr) {
        HashSet<Integer> uniqueNumbSet = new HashSet<>(Arrays.asList(arr));
        return uniqueNumbSet.toArray(new Integer[uniqueNumbSet.size()]);
    }
}
