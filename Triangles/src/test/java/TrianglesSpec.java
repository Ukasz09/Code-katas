import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;

import static org.junit.jupiter.api.Assertions.*;

public class TrianglesSpec {
    @Test
    void whenEdgeInTriangleIsNegativeOrZeroThenException() {
        int[] edges = {2, 3, 4, 1, -2, 22};
        assertThrows(InvalidParameterException.class, () -> Triangles.isPossibleToBuildAnyTriangle(edges));
    }

    @Test
    void whenEdgesQtyIsLessThan3ThenFalse() {
        int[] edges = {2, 3};
        assertFalse(Triangles.isPossibleToBuildAnyTriangle(edges));
    }

    @Test
    void whenNotPossibleToBuildTriangleThenFalse() {
        int[] edges = {10, 50, 5, 1};
        assertFalse(Triangles.isPossibleToBuildAnyTriangle(edges));
    }

    @Test
    void whenPossibleToBuildTriangleThenTrue() {
        int[] edges = {10, 2, 5, 1, 8, 20};
        int[] edges2 = {100, 6, 5, 3, 4, 7};
        int[] edges3 = {1, 5, 1, 1, 4, 2};
        assertTrue(Triangles.isPossibleToBuildAnyTriangle(edges));
        assertTrue(Triangles.isPossibleToBuildAnyTriangle(edges2));
        assertTrue(Triangles.isPossibleToBuildAnyTriangle(edges3));
    }
}
