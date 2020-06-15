import java.util.*;

public class Solution {
    private static long minResult = Long.MAX_VALUE;

    private static void findMinResult(int[] A, int[] S, int changingIndex, HashMap<String, Long> calcValues) {
        if (changingIndex >= 0) {
            S[changingIndex] *= -1;
            long result = Math.abs(calcResult(A, S, A.length - 1, calcValues));
            if (result < minResult)
                minResult = result;
            findMinResult(A, S, changingIndex - 1, calcValues);

            S[changingIndex] *= -1;
            result = Math.abs(calcResult(A, S, A.length - 1, calcValues));
            if (result < minResult)
                minResult = result;
            findMinResult(A, S, changingIndex - 1, calcValues);
        }

    }

    private static long calcResult(int[] A, int[] S, int endIndex, HashMap<String, Long> calcValues) {
        String key = toKey(S, endIndex);
        if (endIndex == 0)
            return A[0] * S[0];
        if (calcValues.containsKey(key))
            return calcValues.get(key);
        return A[endIndex] * S[endIndex] + calcResult(A, S, endIndex - 1, calcValues);
    }

    private static String toKey(int[] values, int endIndex) {
        StringBuilder key = new StringBuilder(values.length);
        for (int i = 0; (i < values.length && i <= endIndex); i++)
            key.append(values[i] == -1 ? '0' : '1');
        return key.toString();
    }


    private static long solution(int[] A) {
        int[] S = new int[A.length];
        Arrays.fill(S, 1);
        findMinResult(A, S, S.length - 1, new HashMap<>());
        return minResult;
    }

    //----------------------------------------------------------------------------------------------------------------//
    public static void main(String[] args) {
//        int[] test = new int[5000];
//        Random random = new Random();
//        for (int i = 0; i < test.length; i++)
//            test[i] = random.nextInt(201) - 100;
//        System.out.println(solution(test));
        System.out.println(solution(new int[]{1, 5, 2, -2}));
    }
}
