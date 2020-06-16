import java.security.InvalidParameterException;
import java.util.Arrays;

public class CyclicRotation {
    public int[] solution(int[] A, int K) {
        if (A == null)
            throw new InvalidParameterException("Given arr is null");
        if (K < 0)
            throw new InvalidParameterException("Times to shift numbers can not be negative");
        if (A.length == 0)
            return A;

        int shiftQty = K % A.length;
        int[] result = Arrays.copyOf(A, A.length);
        for (int i = 0; i < shiftQty; i++) {
            int tmp = result[A.length - 1];
            System.arraycopy(result, 0, result, 1, A.length - 1);
            result[0] = tmp;
        }
        return result;
    }
}
