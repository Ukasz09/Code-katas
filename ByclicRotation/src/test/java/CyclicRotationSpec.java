import org.junit.jupiter.api.*;

import java.security.InvalidParameterException;

import static org.junit.jupiter.api.Assertions.*;

public class CyclicRotationSpec {
    @Test
    void whenShiftedArrWithTheSameNumbersThenTheSameArr() {
        int arr[] = {
                0, 0, 0, 0
        };
        assertArrayEquals(arr, CyclicRotation.shift(arr, 4));
    }

    @Test
    void whenShiftedBy0TimesThenTheSameArr() {
        int arr[] = {
                1, 3, 21, 11, 2
        };
        assertArrayEquals(arr, CyclicRotation.shift(arr, 0));
    }

    @Test
    void whenShiftedByPositiveTimesQtyThenCorrect() {
        int arr[] = {
                3, 8, 9, 7, 6
        };
        assertArrayEquals(new int[]{9, 7, 6, 3, 8}, CyclicRotation.shift(arr, 3));
    }

    @Test
    void whenShiftedByNegativeTimesQtyThenTheException() {
        int arr[] = {
                3, 8, 9, 7, 6
        };
        assertThrows(InvalidParameterException.class, () -> CyclicRotation.shift(arr, -3));
    }

    @Test
    void whenShiftBy360DegreesThenTheTheSameArr() {
        int arr[] = {
                1, 2, 3, 4
        };
        assertArrayEquals(arr, CyclicRotation.shift(arr, 4));
    }

    @Test
    void whenArrIsNullThenException() {
        assertThrows(InvalidParameterException.class, () -> CyclicRotation.shift(null, 3));
    }

    @Test
    void whenShifted329TimesThenCorrectResult() {
        int arr[] = {
                13, 235, 1, 23, 12, 11
        };
        assertArrayEquals(new int[]{235, 1, 23, 12, 11, 13}, CyclicRotation.shift(arr, 329));
    }

}
