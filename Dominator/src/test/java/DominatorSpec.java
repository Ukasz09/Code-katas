import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DominatorSpec {
    @Test
    void whenNotHaveDominatorThenNeg1() {
        int[] arr = {1, 2, 3, 4, 4, 8, 6};
        int[] arr2 = {2, 2, 2, 3, 3, 3, 1, 2, 3, 1, 2, 3};
        assertEquals(-1, Dominator.getDominatorPosition(arr));
        assertEquals(-1, Dominator.getDominatorPosition(arr2));
    }

    @Test
    void givenValueWhichOccursInHalfOfTheElementsThenNeg1() {
        int[] arr = {1, 2, 3, 4, 4, 4};
        assertEquals(-1, Dominator.getDominatorPosition(arr));
    }

    @Test
    void givenAllElementsTheSameThenAnyIndexFromArr() {
        int[] arr = {4, 4, 4, 4, 4};
        List<Integer> expectedResult = Arrays.asList(0, 1, 2, 3, 4);
        assertTrue(expectedResult.contains(Dominator.getDominatorPosition(arr)));
    }

    @Test
    void whenArrWithDominatorThenCorrectIndex() {
        int[] arr = {3, 4, 3, 2, 3, -1, 3, 3};
        List<Integer> expectedResult = Arrays.asList(0, 2, 4, 6, 7);
        assertTrue(expectedResult.contains(Dominator.getDominatorPosition(arr)));
    }

    @Test
    void givenSize3WhenArrWithDominatorThenCorrectIndex() {
        int[] arr = {2, 1, 2};
        List<Integer> expectedResult = Arrays.asList(0, 2);
        assertTrue(expectedResult.contains(Dominator.getDominatorPosition(arr)));
    }
}
