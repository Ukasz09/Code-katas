package test.java;

import main.java.Fibonacci;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;

import static org.junit.jupiter.api.Assertions.*;

public class FibonacciTest {
    @Nested
    class FibonacciTests {
        @Nested
        class RecursionFibonacci {

            @Test
            void fibByIndex0is1() {
                assertEquals(0, Fibonacci.getFibByIndex(0));
            }

            @Test
            void fibByIndex1is1() {
                assertEquals(1, Fibonacci.getFibByIndex(1));
            }

            @Test
            void fibByIndexMinus2ThrowException() {
                assertThrows(InvalidParameterException.class, () -> Fibonacci.getFibByIndex(-2));
            }

            @Test
            void fibByIndex10Is55() {
                assertEquals(55, Fibonacci.getFibByIndex(10));
            }
        }

        @Nested
        class IterativelyFibonacci {
            @Test
            void fibByIndexIteratively0is1() {
                assertEquals(0, Fibonacci.getFibByIndexIteratively(0));
            }

            @Test
            void fibByIndexIteratively1is1() {
                assertEquals(1, Fibonacci.getFibByIndexIteratively(1));
            }

            @Test
            void fibByIndexIterativelyMinus2ThrowException() {
                assertThrows(InvalidParameterException.class, () -> Fibonacci.getFibByIndexIteratively(-2));
            }

            @Test
            void fibByIndexIteratively10Is55() {
                assertEquals(55, Fibonacci.getFibByIndexIteratively(10));
            }
        }

        @Nested
        class LambdasFibonacci {
            @Test
            void fibByIndexLambdas0is1() {
                assertEquals(0, Fibonacci.getFibByIndexLambda(0));
            }

            @Test
            void fibByIndexLambdas1is1() {
                assertEquals(1, Fibonacci.getFibByIndexLambda(1));
            }

            @Test
            void fibByIndexLambdasMinus2ThrowException() {
                assertThrows(InvalidParameterException.class, () -> Fibonacci.getFibByIndexLambda(-2));
            }

            @Test
            void fibByIndexLambdas10Is55() {
                assertEquals(55, Fibonacci.getFibByIndexLambda(10));
            }

        }

        @Nested
        class WhileLoopFibonacci {
            @Test
            void fibByIndex0is1() {
                assertEquals(0, Fibonacci.fibByWhileLoop(0));
            }

            @Test
            void fibByIndex1is1() {
                assertEquals(1, Fibonacci.fibByWhileLoop(1));
            }

            @Test
            void fibByIndexMinus2ThrowException() {
                assertThrows(InvalidParameterException.class, () -> Fibonacci.fibByWhileLoop(-2));
            }

            @Test
            void fibByIndex10Is55() {
                assertEquals(55, Fibonacci.fibByWhileLoop(10));
            }

        }
    }

    @Nested
    class FactorialTests{

        @Nested
        class RecursionFactorial{

            @Test
            void factorialRecursionFrom0Is1(){
                assertEquals(1, Fibonacci.factorialByRecursion(0));
            }

            @Test
            void factorialRecursionFrom1Is1(){
                assertEquals(1, Fibonacci.factorialByRecursion(1));

            }

            @Test
            void factorialRecursionFrom5Is120(){
                assertEquals(120, Fibonacci.factorialByRecursion(5));
            }

            @Test
            void factorialRecursionFromMinus1ThrowException(){
                assertThrows(InvalidParameterException.class,()-> Fibonacci.factorialByRecursion(-1));
            }
        }

        @Nested
        class IterativelyFactorial{
            @Test
            void factorialRecursionFrom0Is1(){
                assertEquals(1, Fibonacci.factorialIteratively(0));
            }

            @Test
            void factorialRecursionFrom1Is1(){
                assertEquals(1, Fibonacci.factorialIteratively(1));

            }

            @Test
            void factorialRecursionFrom5Is120(){
                assertEquals(120, Fibonacci.factorialIteratively(5));
            }

            @Test
            void factorialRecursionFromMinus1ThrowException(){
                assertThrows(InvalidParameterException.class,()-> Fibonacci.factorialIteratively(-1));
            }
        }

    }
}
