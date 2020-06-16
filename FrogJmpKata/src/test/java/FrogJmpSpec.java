import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;

import static org.junit.jupiter.api.Assertions.*;

public class FrogJmpSpec {
    @Test
    void whenTargetIsLessThanStartThenException() {
        assertThrows(InvalidParameterException.class, () -> FrogJmp.solution(20, 19, 10));
    }

    @Test
    void whenJumpSizeZeroThenException() {
        assertThrows(InvalidParameterException.class, () -> FrogJmp.solution(5, 19, 0));
    }

    @Test
    void whenJumpSizeNegativeThenException() {
        assertThrows(InvalidParameterException.class, () -> FrogJmp.solution(5, 19, -5));
    }

    @Test
    void whenJumpExactlyToTargetThenCorrectResult() {
        assertEquals(5, FrogJmp.solution(0, 75, 15));
        assertEquals(2, FrogJmp.solution(34, 44, 5));
    }

    @Test
    void whenMustJumpBehindTargetThenCorrectResult() {
        assertEquals(3, FrogJmp.solution(10, 85, 30));
        assertEquals(6, FrogJmp.solution(17, 79, 12));
    }
}
