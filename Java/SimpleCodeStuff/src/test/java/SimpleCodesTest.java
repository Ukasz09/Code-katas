package test.java;

import main.java.SimpleCodes;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;

import static org.junit.jupiter.api.Assertions.*;

public class SimpleCodesTest {
    @Nested
    class FibonacciTests {
        @Nested
        class RecursionFibonacci {

            @Test
            void fibByIndex0is1() {
                assertEquals(0, SimpleCodes.getFibByIndex(0));
            }

            @Test
            void fibByIndex1is1() {
                assertEquals(1, SimpleCodes.getFibByIndex(1));
            }

            @Test
            void fibByIndexMinus2ThrowException() {
                assertThrows(InvalidParameterException.class, () -> SimpleCodes.getFibByIndex(-2));
            }

            @Test
            void fibByIndex10Is55() {
                assertEquals(55, SimpleCodes.getFibByIndex(10));
            }
        }

        @Nested
        class IterativelyFibonacci {
            @Test
            void fibByIndexIteratively0is1() {
                assertEquals(0, SimpleCodes.getFibByIndexIteratively(0));
            }

            @Test
            void fibByIndexIteratively1is1() {
                assertEquals(1, SimpleCodes.getFibByIndexIteratively(1));
            }

            @Test
            void fibByIndexIterativelyMinus2ThrowException() {
                assertThrows(InvalidParameterException.class, () -> SimpleCodes.getFibByIndexIteratively(-2));
            }

            @Test
            void fibByIndexIteratively10Is55() {
                assertEquals(55, SimpleCodes.getFibByIndexIteratively(10));
            }
        }

        @Nested
        class LambdasFibonacci {
            @Test
            void fibByIndexLambdas0is1() {
                assertEquals(0, SimpleCodes.getFibByIndexLambda(0));
            }

            @Test
            void fibByIndexLambdas1is1() {
                assertEquals(1, SimpleCodes.getFibByIndexLambda(1));
            }

            @Test
            void fibByIndexLambdasMinus2ThrowException() {
                assertThrows(InvalidParameterException.class, () -> SimpleCodes.getFibByIndexLambda(-2));
            }

            @Test
            void fibByIndexLambdas10Is55() {
                assertEquals(55, SimpleCodes.getFibByIndexLambda(10));
            }

        }
    }

    @Nested
    class FactorialTests{

        @Nested
        class RecursionFactorial{

            @Test
            void factorialRecursionFrom0Is1(){
                assertEquals(1,SimpleCodes.factorialByRecursion(0));
            }

            @Test
            void factorialRecursionFrom1Is1(){
                assertEquals(1,SimpleCodes.factorialByRecursion(1));

            }

            @Test
            void factorialRecursionFrom5Is120(){
                assertEquals(120,SimpleCodes.factorialByRecursion(5));
            }

            @Test
            void factorialRecursionFromMinus1ThrowException(){
                assertThrows(InvalidParameterException.class,()->SimpleCodes.factorialByRecursion(-1));
            }
        }

        @Nested
        class IterativelyFactorial{
            @Test
            void factorialRecursionFrom0Is1(){
                assertEquals(1,SimpleCodes.factorialIteratively(0));
            }

            @Test
            void factorialRecursionFrom1Is1(){
                assertEquals(1,SimpleCodes.factorialIteratively(1));

            }

            @Test
            void factorialRecursionFrom5Is120(){
                assertEquals(120,SimpleCodes.factorialIteratively(5));
            }

            @Test
            void factorialRecursionFromMinus1ThrowException(){
                assertThrows(InvalidParameterException.class,()->SimpleCodes.factorialIteratively(-1));
            }
        }

    }
}
