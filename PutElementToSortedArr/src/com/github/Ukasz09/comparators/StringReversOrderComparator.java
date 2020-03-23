package com.github.Ukasz09.comparators;

import java.util.Comparator;

public class StringReversOrderComparator implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        return o2.compareTo(o1);
    }
}
