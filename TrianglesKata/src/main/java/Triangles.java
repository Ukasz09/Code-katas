import java.security.InvalidParameterException;
import java.util.Arrays;

public class Triangles {

    public static boolean isPossibleToBuildAnyTriangle(int[] edges) {
        if (edges.length < 3)
            return false;
        Arrays.sort(edges);
        if (edges[0] < 0)
            throw new InvalidParameterException("Edge can not be negative");
        for (int i = 0; i < edges.length; i++)
            for (int j = i + 1; j < edges.length - 1; j++)
                if ((edges[i] + edges[j]) > edges[j + 1])
                    return true;
        return false;
    }

}
