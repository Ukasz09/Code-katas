package com.Ukasz09.fizzBuzz;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FizzBuzzTest {

    @Test
    void shouldReturnFizzFor3() {
        assertEquals(FizzBuzz.getFizzBuzzValue(3), "Fizz");
    }

    @Test
    void shouldReturnFizzFor5() {
        assertEquals(FizzBuzz.getFizzBuzzValue(5), "Buzz");
    }

    @Test
    void shouldReturnFizzFor15() {
        assertEquals(FizzBuzz.getFizzBuzzValue(15), "FizzBuzz");
    }

    @Test
    void shouldReturn0LengthArrFor0() {
        FizzBuzz fizzBuzz0 = new FizzBuzz(0);
        assertEquals(fizzBuzz0.getFizzBuzzArr().length, 0);
    }

    @Test
    void shouldReturn0LengthArrForNegative() {
        FizzBuzz fizzBuzzNegative = new FizzBuzz(-10);
        assertEquals(fizzBuzzNegative.getFizzBuzzArr().length, 0);
    }
}
