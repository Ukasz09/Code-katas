import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;

import static org.junit.jupiter.api.Assertions.*;

public class OddConcurrencesInArraySpec {

    @Nested
    class findOddConcurrencesByLambda {
        @Test
        void whenArraySizeIsEvenThenException() {
            int[] arr = {1, 2, 3, 4};
            assertThrows(InvalidParameterException.class, () -> OddConcurrencesInArray.findOddNumberByUsingLambadas(arr));
        }

        @Test
        void givenCorrectArrayWhenAllElementsTheSameThenResultIsAnyNumberFromArr() {
            int[] arr = {13, 13, 13, 13, 13};
            assertEquals(13, OddConcurrencesInArray.findOddNumberByUsingLambadas(arr));
        }

        @Test
        void whenArrSize1ThenResult1() {
            int[] arr = {1};
            assertEquals(1, OddConcurrencesInArray.findOddNumberByUsingLambadas(arr));
        }

        @Test
        void givenArraySize3WhenCorrectThenResult() {
            int[] arr = {1, 4, 1};
            assertEquals(4, OddConcurrencesInArray.findOddNumberByUsingLambadas(arr));
        }

        @Test
        void givenArraySize7WhenCorrectThenResult() {
            int[] arr = {9, 3, 9, 3, 9, 9, 7};
            assertEquals(7, OddConcurrencesInArray.findOddNumberByUsingLambadas(arr));
        }
    }

    @Nested
    class findOddConcurrencesIteratively {
        @Test
        void whenArraySizeIsEvenThenException() {
            int[] arr = {1, 2, 3, 4};
            assertThrows(InvalidParameterException.class, () -> OddConcurrencesInArray.findOddNumberIteratively(arr));
        }

        @Test
        void givenCorrectArrayWhenAllElementsTheSameThenResultIsAnyNumberFromArr() {
            int[] arr = {13, 13, 13, 13, 13};
            assertEquals(13, OddConcurrencesInArray.findOddNumberIteratively(arr));
        }

        @Test
        void whenArrSize1ThenResult1() {
            int[] arr = {1};
            assertEquals(1, OddConcurrencesInArray.findOddNumberIteratively(arr));
        }

        @Test
        void givenArraySize3WhenCorrectThenResult() {
            int[] arr = {1, 4, 1};
            assertEquals(4, OddConcurrencesInArray.findOddNumberIteratively(arr));
        }

        @Test
        void givenArraySize7WhenCorrectThenResult() {
            int[] arr = {9, 3, 9, 3, 9, 9, 7};
            assertEquals(7, OddConcurrencesInArray.findOddNumberIteratively(arr));
        }
    }

    @Nested
    class findOddConcurrencesEffective {
        @Test
        void whenArraySizeIsEvenThenException() {
            int[] arr = {1, 2, 3, 4};
            assertThrows(InvalidParameterException.class, () -> OddConcurrencesInArray.findOddNumberEffective(arr));
        }

        @Test
        void givenCorrectArrayWhenAllElementsTheSameThenResultIsAnyNumberFromArr() {
            int[] arr = {13, 13, 13, 13, 13};
            assertEquals(13, OddConcurrencesInArray.findOddNumberEffective(arr));
        }

        @Test
        void whenArrSize1ThenResult1() {
            int[] arr = {1};
            assertEquals(1, OddConcurrencesInArray.findOddNumberEffective(arr));
        }

        @Test
        void givenArraySize3WhenCorrectThenResult() {
            int[] arr = {1, 4, 1};
            assertEquals(4, OddConcurrencesInArray.findOddNumberEffective(arr));
        }

        @Test
        void givenArraySize7WhenCorrectThenResult() {
            int[] arr = {9, 3, 9, 3, 9, 9, 7};
            assertEquals(7, OddConcurrencesInArray.findOddNumberEffective(arr));
        }
    }

}
