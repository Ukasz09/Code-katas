import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;

import static org.junit.jupiter.api.Assertions.*;

public class MaxDoubleSliceSumSpec {
    @Nested
    static class SingleSliceTest {
        @Test
        void whenCellsQtyIsLowerThan3Then0() {
            int[] arr = {3, 2, 6, -1, 4, 5, -1, 2};
            assertEquals(0, SlicesSum.singleSliceSumBetweenExcludedIndexes(arr, 0, 1));
        }

        @Test
        void whenNoDominatorThan0() {
            int[] arr = {3, 2, 6, -1, 4, 5, -1, 2};
            assertEquals(0, SlicesSum.singleSliceSumBetweenExcludedIndexes(arr, 5, 7));
            assertEquals(0, SlicesSum.singleSliceSumBetweenExcludedIndexes(arr, 2, 4));
        }


        @Test
        void whenCellsQtyIs3ThenCorrect() {
            int[] arr = {3, 2, 6, -1, 4, 5, -1, 2};
            assertEquals(2, SlicesSum.singleSliceSumBetweenExcludedIndexes(arr, 0, 2));
        }

        @Test
        void whenCellsQtyIsBiggerThan3ThenCorrect() {
            int[] arr = {3, 2, 6, -1, 4, 5, -1, 2};
            int[] arr2 = {5, -7, 3, 5, -2, 4, -1};
            assertEquals(16, SlicesSum.singleSliceSumBetweenExcludedIndexes(arr, 0, 7));
            assertEquals(5, SlicesSum.singleSliceSumBetweenExcludedIndexes(arr, 4, 7));
            assertEquals(14, SlicesSum.singleSliceSumBetweenExcludedIndexes(arr, 1, 7));
            assertEquals(10, SlicesSum.singleSliceSumBetweenExcludedIndexes(arr2, 0, arr2.length - 1));
        }
    }

    @Nested
    static class DoubleSliceTest {
        @Test
        void whenCorrectArrSizeThenCorrectSum() {
            int[] arr = {3, 2, 6, -1, 4, 5, -1, 2};
            int[] arr2 = {10, 15, -14, -4, 8, -1, 4, -1, -1};
            assertEquals(17, SlicesSum.getMaxDoubleSliceSum(arr));
            assertEquals(22, SlicesSum.getMaxDoubleSliceSum(arr2));
        }

        @Test
        void whenIncorrectArrSizeThenException() {
            int[] arr = {1, 3};
            assertThrows(InvalidParameterException.class, () -> SlicesSum.getMaxDoubleSliceSum(arr));
        }

    }
}
