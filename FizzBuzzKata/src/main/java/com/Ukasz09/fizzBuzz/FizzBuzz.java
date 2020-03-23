package com.Ukasz09.fizzBuzz;

public class FizzBuzz {

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //                                                  Fields
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private static final int DEFAULT_SIZE = 100;
    private static final String DIVIDED_BY_15_STATEMENT = "FizzBuzz";
    private static final String DIVIDED_BY_3_STATEMENT = "Fizz";
    private static final String DIVIDED_BY_5_STATEMENT = "Buzz";

    private String[] fizzBuzzArr;

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //                                               Constructors
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public FizzBuzz() {
        this(DEFAULT_SIZE);
    }

    public FizzBuzz(int amount) {
        if (amount < 0)
            fizzBuzzArr = new String[]{};
        else fizzBuzzArr = new String[amount];
        calculateFizzBuzz();
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //                                           Methods: STATIC
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static String getFizzBuzzValue(int value) {
        if (isDividedVy15(value))
            return DIVIDED_BY_15_STATEMENT;
        if (isDividedVy3(value))
            return DIVIDED_BY_3_STATEMENT;
        if (isDividedVy5(value))
            return DIVIDED_BY_5_STATEMENT;
        return String.valueOf(value);
    }

    private static boolean isDividedVy15(int number) {
        return (number % 15 == 0);
    }

    private static boolean isDividedVy3(int number) {
        return (number % 3 == 0);
    }

    private static boolean isDividedVy5(int number) {
        return (number % 5 == 0);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //                                           Methods: NOT_STATIC
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private void calculateFizzBuzz() {
        for (int i = 0; i < fizzBuzzArr.length; i++)
            fizzBuzzArr[i] = FizzBuzz.getFizzBuzzValue(i + 1);
    }

    public void printFizzBuzzArr() {
        for (int i = 0; i < fizzBuzzArr.length; i++)
            System.out.print(fizzBuzzArr[i] + ", ");
        System.out.println("\b\b");
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //                                       Methods: Getters, setters
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public String[] getFizzBuzzArr() {
        return fizzBuzzArr;
    }
}
