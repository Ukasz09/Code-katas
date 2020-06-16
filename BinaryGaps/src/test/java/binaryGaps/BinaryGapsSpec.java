package binaryGaps;

import org.junit.jupiter.api.*;

import java.security.InvalidParameterException;

import static org.junit.jupiter.api.Assertions.*;

public class BinaryGapsSpec {
    @Test
    public void whenNumberWithOneBinaryGapThenCorrectResult() {
        assertEquals(2, BinaryGaps.solution(9));
    }

    @Test
    public void whenNumberWithTwoBinaryGapThenCorrectResult() {
        assertEquals(4, BinaryGaps.solution(529));
    }

    @Test
    public void whenNumber20ThenResult1() {
        assertEquals(2, BinaryGaps.solution(9));
    }

    @Test
    public void whenNumberWithNoBinaryGapsThenCorrectResult() {
        assertEquals(0, BinaryGaps.solution(15));
        assertEquals(0, BinaryGaps.solution(32));
    }

    @Test
    public void whenNumber1041ThenResult5() {
        assertEquals(5, BinaryGaps.solution(1041));
    }

    @Test
    public void whenNegativeNumberThenException() {
        assertThrows(InvalidParameterException.class, () -> BinaryGaps.solution(-4));
    }

    @Test
    public void when0ThenException() {
        assertThrows(InvalidParameterException.class, () -> BinaryGaps.solution(0));
    }

}
