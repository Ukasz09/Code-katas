package com.Ukasz09.fizzBuzz;

public class Main {

    public static void main(String[] args){
        FizzBuzz fizzBuzz= new FizzBuzz(20);
        FizzBuzz fizzBuzzDefault= new FizzBuzz();
        FizzBuzz fizzBuzz0= new FizzBuzz(0);
        FizzBuzz fizzBuzzNegative= new FizzBuzz(-4);

        fizzBuzz.printFizzBuzzArr();
        fizzBuzzDefault.printFizzBuzzArr();
        fizzBuzz0.printFizzBuzzArr();
        fizzBuzzNegative.printFizzBuzzArr();
    }



}
