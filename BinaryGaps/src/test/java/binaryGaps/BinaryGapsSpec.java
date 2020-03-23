package binaryGaps;

import org.junit.jupiter.api.*;

import java.security.InvalidParameterException;

import static org.junit.jupiter.api.Assertions.*;

public class BinaryGapsSpec {
    @Test
    public void whenNumberWithOneBinaryGapThenCorrectResult() {
        assertEquals(2, BinaryGaps.getMaxGap(9));
    }

    @Test
    public void whenNumberWithTwoBinaryGapThenCorrectResult() {
        assertEquals(4, BinaryGaps.getMaxGap(529));
    }

    @Test
    public void whenNumber20ThenResult1() {
        assertEquals(2, BinaryGaps.getMaxGap(9));
    }

    @Test
    public void whenNumberWithNoBinaryGapsThenCorrectResult() {
        assertEquals(0, BinaryGaps.getMaxGap(15));
        assertEquals(0, BinaryGaps.getMaxGap(32));
    }

    @Test
    public void whenNumber1041ThenResult5() {
        assertEquals(5, BinaryGaps.getMaxGap(1041));
    }

    @Test
    public void whenNegativeNumberThenException() {
        assertThrows(InvalidParameterException.class, () -> BinaryGaps.getMaxGap(-4));
    }

    @Test
    public void when0ThenException() {
        assertThrows(InvalidParameterException.class, () -> BinaryGaps.getMaxGap(0));
    }

}
