import java.util.Arrays;

public class PermCheck {
    public static boolean isPermutationSlowImplementation(int[] arr) {
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 1; i++)
            if (arr[i + 1] != (arr[i] + 1))
                return false;
        return true;
    }

    public static boolean isPermutationEfficientImplementation(int[] arr) {
        int[] countArr = new int[arr.length + 2];
        for (int value : arr) countArr[value] += 1;

        boolean startedCheckingPermutation = false;
        boolean finishedCheckingPermutation = false;
        for (int count : countArr) {
            if (count != 1 && startedCheckingPermutation)
                finishedCheckingPermutation = true;
            else if (count != 0) {
                if (finishedCheckingPermutation)
                    return false;
                else startedCheckingPermutation = true;
            }
        }
        return true;
    }
}
