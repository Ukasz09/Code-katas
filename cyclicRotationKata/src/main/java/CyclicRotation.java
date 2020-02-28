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

        //todo: naprawic
        for (int shiftNo = 0; shiftNo < shiftOffset; shiftNo++) {
            int tmp = result[0];
            for (int i = 0; i < arr.length - 1; i++) {
                int newTemp = result[(i + 1) % arr.length];
                result[(i + 1) % arr.length] = tmp;
                tmp = newTemp;
            }
        }
        return result;
    }
}
