package com.Ukasz09.fizzBuzz;

import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class FizzBuzzTest {

    @Nested
    class Constructors {

        @Test
        void shouldMakeArrLength100ForDefault() {
            assertEquals(100, new FizzBuzz().getFizzBuzzArr().length);
        }

        @Test
        void shouldMakeArrLength0ForNegative1() {
            assertEquals(0, new FizzBuzz(-1).getFizzBuzzArr().length);
        }

        @Test
        void shouldMakeArrLength0For0() {
            assertEquals(0, new FizzBuzz(0).getFizzBuzzArr().length);
        }

        @Test
        void shouldMakeArrLength3For3() {
            assertEquals(3, new FizzBuzz(3).getFizzBuzzArr().length);
        }

    }

    @Nested
    class StaticMethodsTests {

        @Nested
        class ReturnedFizz {
            @Test
            void shouldReturnFizzFor3() {
                assertEquals("Fizz", FizzBuzz.getFizzBuzzValue(3));
            }

            @Test
            void shouldReturnFizzForNegative3() {
                assertEquals("Fizz", FizzBuzz.getFizzBuzzValue(-3));
            }
        }

        @Nested
        class ReturnedBuzz {

            @Test
            void shouldReturnBuzzFor5() {
                assertEquals("Buzz", FizzBuzz.getFizzBuzzValue(5));
            }

            @Test
            void shouldReturnBuzzForNegative5() {
                assertEquals("Buzz", FizzBuzz.getFizzBuzzValue(-5));
            }
        }

        @Nested
        class ReturnedFizzBuzz {
            @Test
            void shouldReturnFizzBuzzFor15() {
                assertEquals("FizzBuzz", FizzBuzz.getFizzBuzzValue(15));
            }

            @Test
            void shouldReturnFizzBuzzForNegative15() {
                assertEquals("FizzBuzz", FizzBuzz.getFizzBuzzValue(-15));
            }

            @Test
            void shouldReturnFizzBuzzFor0() {
                assertEquals("FizzBuzz", FizzBuzz.getFizzBuzzValue(0));
            }
        }

        @Nested
        class ReturnedNumber {
            @Test
            void shouldReturn4For4() {
                assertEquals("4", FizzBuzz.getFizzBuzzValue(4));
            }

            @Test
            void shouldReturn15671For15671() {
                assertEquals("15671", FizzBuzz.getFizzBuzzValue(15671));
            }
        }
    }

    @Nested
    class NotStaticMethodsTests {

        @Nested
        class OutputTests {
            private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
            private final PrintStream originalOut = System.out;

            @BeforeEach
            void setUpStreams() {
                System.setOut(new PrintStream(outContent));
            }

            @AfterEach
            void restoreStreams() {
                System.setOut(originalOut);
            }

            @Test
            void printNothingWithNewLineFor0() {
                new FizzBuzz(0).printFizzBuzzArr();
                assertEquals("\b\b" + System.getProperty("line.separator"), outContent.toString());
            }

            @Test
            void printNothingWithNewLineForNegative1() {
                new FizzBuzz(-1).printFizzBuzzArr();
                assertEquals("\b\b" + System.getProperty("line.separator"), outContent.toString());
            }

            @Test
            void printProperForNegative15() {
                new FizzBuzz(15).printFizzBuzzArr();
                assertEquals("1, 2, Fizz, 4, Buzz, Fizz, 7, 8, Fizz, Buzz, 11, Fizz, 13, 14, FizzBuzz, " + "\b\b" + System.getProperty("line.separator"), outContent.toString());
            }

        }


        @Test
        void shouldReturn0LengthArrFor0() {
            FizzBuzz fizzBuzz0 = new FizzBuzz(0);
            assertEquals(0, fizzBuzz0.getFizzBuzzArr().length);
        }

        @Test
        void shouldReturn0LengthArrForNegative1() {
            FizzBuzz fizzBuzzNeg1 = new FizzBuzz(-1);
            assertEquals(0, fizzBuzzNeg1.getFizzBuzzArr().length);
        }

        @Test
        void shouldReturn1LengthArrFor1() {
            FizzBuzz fizzBuzz1 = new FizzBuzz(1);
            assertEquals(1, fizzBuzz1.getFizzBuzzArr().length);
        }
    }
}
