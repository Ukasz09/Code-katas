import java.util.Arrays;
import java.util.HashSet;

public class PermCheck {
    public static int isPermutationSlowImplementation(int[] arr) {
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 1; i++)
            if (arr[i + 1] != (arr[i] + 1))
                return 0;
        return 1;
    }

    public static int isPermutationNormal(int[] arr) {
        int[] countArr = new int[arr.length + 2];
        for (int value : arr) countArr[value] += 1;

        boolean startedCheckingPermutation = false;
        boolean finishedCheckingPermutation = false;
        for (int count : countArr) {
            if (count != 1 && startedCheckingPermutation)
                finishedCheckingPermutation = true;
            else if (count != 0) {
                if (finishedCheckingPermutation)
                    return 0;
                else startedCheckingPermutation = true;
            }
        }
        return 1;
    }
    public static int isPermutationEfficient(int[] arr) {
        HashSet<Integer> startedSet = new HashSet<>(arr.length);
        for (int i = 0; i < arr.length; i++)
            startedSet.add(i + 1);
        for (int numb : arr)
            startedSet.remove(numb);
        return startedSet.isEmpty() ? 1 : 0;
    }

}
