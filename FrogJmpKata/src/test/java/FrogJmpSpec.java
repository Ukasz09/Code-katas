import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;

import static org.junit.jupiter.api.Assertions.*;

public class FrogJmpSpec {
    @Test
    void whenTargetIsLessThanStartThenException() {
        assertThrows(InvalidParameterException.class, () -> FrogJmp.getMinJumpQty(20, 19, 10));
    }

    @Test
    void whenJumpSizeZeroThenException() {
        assertThrows(InvalidParameterException.class, () -> FrogJmp.getMinJumpQty(5, 19, 0));
    }

    @Test
    void whenJumpSizeNegativeThenException() {
        assertThrows(InvalidParameterException.class, () -> FrogJmp.getMinJumpQty(5, 19, -5));
    }

    @Test
    void whenJumpExactlyToTargetThenCorrectResult() {
        assertEquals(5, FrogJmp.getMinJumpQty(0, 75, 15));
        assertEquals(2, FrogJmp.getMinJumpQty(34, 44, 5));
    }

    @Test
    void whenMustJumpBehindTargetThenCorrectResult() {
        assertEquals(3, FrogJmp.getMinJumpQty(10, 85, 30));
        assertEquals(6, FrogJmp.getMinJumpQty(17, 79, 12));
    }
}
