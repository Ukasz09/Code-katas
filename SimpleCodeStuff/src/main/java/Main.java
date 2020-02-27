package main.java;

public class Main {
    public static void main(String[] args){
        println(SimpleCodes.getFibByIndex(0));
        println(SimpleCodes.getFibByIndexLambda(1));
    }

    public static <T> void println(T object){
        System.out.println(object);
    }
}
