import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class PermCheckSpec {

    @Nested
    class SlowImplementationTests {

        @Test
        void givenArrWithEachElementOnceRepeatWhenNoPermutationThenFalse() {
            int arr[] = {4, 1, 3};
            assertFalse(PermCheck.isPermutationSlowImplementation(arr));

            arr = new int[]{4, 1, 2, 3, 6};
            assertFalse(PermCheck.isPermutationSlowImplementation(arr));
        }

        @Test
        void whenArrWithEachElementMoreThanOnceRepeatThenFalse() {
            int arr[] = {4, 1, 2, 2, 3};
            assertFalse(PermCheck.isPermutationSlowImplementation(arr));
        }

        @Test
        void givenArrWithEachElementOnceRepeatWhenPermutationThenTrue() {
            int arr[] = {4, 1, 3, 2};
            assertTrue(PermCheck.isPermutationSlowImplementation(arr));
            arr = new int[]{4, 1, 3, 2, 9, 8, 7, 5, 6};
            assertTrue(PermCheck.isPermutationSlowImplementation(arr));
        }
    }

    @Nested
    class BetterImplementationTests {

        @Test
        void givenArrWithEachElementOnceRepeatWhenNoPermutationThenFalse() {
            int arr[] = {4, 1, 3};
            assertFalse(PermCheck.isPermutationMiddleAverage(arr));

            arr = new int[]{4, 1, 2, 3, 6};
            assertFalse(PermCheck.isPermutationSlowImplementation(arr));
        }

        @Test
        void whenArrWithEachElementMoreThanOnceRepeatThenFalse() {
            int arr[] = {4, 1, 2, 2, 3};
            assertFalse(PermCheck.isPermutationMiddleAverage(arr));
        }

        @Test
        void givenArrWithEachElementOnceRepeatWhenPermutationThenTrue() {
            int arr[] = {4, 1, 3, 2};
            assertTrue(PermCheck.isPermutationMiddleAverage(arr));
            arr = new int[]{4, 1, 3, 2, 9, 8, 7, 5, 6};
            assertTrue(PermCheck.isPermutationMiddleAverage(arr));
        }
    }

}
