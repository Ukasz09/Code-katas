package src.main.java;

import java.util.function.Consumer;

public class LambdaTester {

    public static void main(String[] args) {
      String text="Ania hania Ania i basia ma i nie ma";
      LambadaExercises.wordCounter(text);

    }

    public static <T> void doSthByLambda(Consumer<T> doAction, T subject) {
        doAction.accept(subject);
    }

    public static void println(Object object){
        System.out.println(object);
    }


}
