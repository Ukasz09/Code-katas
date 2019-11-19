package com.github.Ukasz09.main;

import java.util.Comparator;

/**
* SortedArr class contains generic type, sorted arr passed by parametrized constructor
* insertInSortedArr put element to sortedArr and keep the order of elements
* by using comparator passed in constructor or natural order (comparetTo) from added element
* if comparator==null
*
* @author  Lukasz Gajerski (https://github.com/Ukasz09)
* @version 1.0
* @since   2019-11-19
*/
public class SortedArr<T extends Comparable<T>> {

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //                                                Fields
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private T[] sortedArr;
    private Comparator<T> predicate;

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //                                             Constructors
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public SortedArr(T[] sortedArr) {
        this(sortedArr, null);
    }

    @SuppressWarnings("unchecked")
    public SortedArr(T[] sortedArr, Comparator<T> predicate) {
        if (sortedArr == null)
            this.sortedArr = (T[]) new Comparable[]{};
        this.predicate = predicate;
        this.sortedArr = sortedArr;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //                                                Methods
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @SuppressWarnings("unchecked")
    public void insertInSortedArr(T value) {
        T[] tmpArr = (T[]) new Comparable[sortedArr.length + 1];
        int compareResult = -1;
        for (int i = 0; i < sortedArr.length; i++) {
            if (predicate == null)
                compareResult = sortedArr[i].compareTo(value);
            else compareResult = predicate.compare(sortedArr[i], value);

            if (compareResult > 0) {
                tmpArr[i] = value;
                System.arraycopy(sortedArr, i, tmpArr, i + 1, sortedArr.length - i);
                sortedArr = tmpArr;
                return;
            } else tmpArr[i] = sortedArr[i];
        }

        //if add at last index
        tmpArr[sortedArr.length] = value;
        sortedArr = tmpArr;
    }

    public void printSortedArr() {
        for (T value : sortedArr) {
            System.out.print(value + ", ");
        }
        System.out.println("\b\b");
    }

    public T[] getSortedArr() {
        return sortedArr;
    }
}
