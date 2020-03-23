package com.github.Ukasz09.main;

import com.github.Ukasz09.comparators.IntegerReversOrderComparator;
import com.github.Ukasz09.comparators.StringReversOrderComparator;

import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1, 3, 5, 7};
        Integer[] arr2 = new Integer[]{7, 5, 3, 1};
        Integer[] arr3 = new Integer[]{};
        String[] arr4 = new String[]{"Ania", "Basia", "Kasia", "Monika"};
        String[] arr5 = new String[]{"Za", "Wa", "Sa", "Aa"};

        addAndPrintArr(4, arr);
        addAndPrintArr(4, arr2, new IntegerReversOrderComparator());
        addAndPrintArr(4, arr3);
        addAndPrintArr(4, arr3, new IntegerReversOrderComparator());
        addAndPrintArr(9, arr);
        addAndPrintArr(0, arr);
        addAndPrintArr("Gosia", arr4);
        addAndPrintArr("Ba", arr5, new StringReversOrderComparator());
    }

    private static void addAndPrintArr(int value, Integer[] arr, Comparator<Integer> comparator) {
        SortedArr<Integer> sortedArr = new SortedArr<>(arr, comparator);
        sortedArr.insertInSortedArr(value);
        sortedArr.printSortedArr();
    }

    private static void addAndPrintArr(int value, Integer[] arr) {
        SortedArr<Integer> sortedArr = new SortedArr<>(arr);
        sortedArr.insertInSortedArr(value);
        sortedArr.printSortedArr();
    }

    private static void addAndPrintArr(String value, String[] arr, Comparator<String> comparator) {
        SortedArr<String> sortedArr = new SortedArr<>(arr, comparator);
        sortedArr.insertInSortedArr(value);
        sortedArr.printSortedArr();
    }

    private static void addAndPrintArr(String value, String[] arr) {
        SortedArr<String> sortedArr = new SortedArr<>(arr);
        sortedArr.insertInSortedArr(value);
        sortedArr.printSortedArr();
    }
}
