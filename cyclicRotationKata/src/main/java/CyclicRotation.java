import java.security.InvalidParameterException;
import java.util.Arrays;

public class CyclicRotation {
    public static int[] shift(int[] arr, int timesToShift) {
        if (arr == null)
            throw new InvalidParameterException("Given arr is null");
        if (timesToShift < 0)
            throw new InvalidParameterException("Times to shift numbers can not be negative");

        int shiftOffset = timesToShift % arr.length;
        int[] result = Arrays.copyOf(arr, arr.length);
        for (int shiftNo = 0; shiftNo < shiftOffset; shiftNo++) {
            int tmp = result[arr.length - 1];
            System.arraycopy(result, 0, result, 1, arr.length - 1);
            result[0] = tmp;
        }
        return result;
    }
}
