package main.java;

import java.security.InvalidParameterException;
import java.util.stream.Stream;

public class SimpleCodes {
    public static long getFibByIndex(int index) {
        if (index < 0)
            throw new InvalidParameterException("Index should be greater than 0");
        if (index == 0)
            return 0;
        if (index == 1)
            return 1;
        return getFibByIndex(index - 2) + getFibByIndex(index - 1);
    }

    public static long getFibByIndexIteratively(int index) {
        if (index < 0)
            throw new InvalidParameterException("Index should be greater than 0");
        int first = 0;
        int second = 1;
        for (int i = 0; i < index; i++) {
            int temp = first;
            first = second;
            second += temp;
        }

        return first;
    }

    public static long getFibByIndexLambda(int index) {
        if(index<0)
            throw new InvalidParameterException("Index should be greater than 0");
        if(index==0)
            return 0;
        return Stream.iterate(new long[]{1, 1}, (arr) -> new long[]{arr[1], arr[0] + arr[1]})
                .limit(index)
                .reduce((a, b) -> b)
                .get()[0];
    }

    public static long factorialByRecursion(int number){
       if(number<0)
           throw new InvalidParameterException("Number should be greater or equal 0");
       return computeFactorial(number);
    }

    private static long computeFactorial(int number){
        if(number<2)
            return 1;
        return number* factorialByRecursion(number-1);
    }

    public static long factorialIteratively(int number){
        if(number<0)
            throw new InvalidParameterException("Number should be greater or equal 0");
        long result=1;
        for(int i=number; i>0; i--)
            result*=i;
        return result;
    }
}
