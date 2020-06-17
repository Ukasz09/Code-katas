import java.util.stream.IntStream;

public class Solution {

    public int solution(int[] A) {
        // with lambdas is a little bit slower
        // int totalSum = IntStream.of(A).sum();
        int totalSum = 0;
        for (int a : A) totalSum += a;
        int minResult = Integer.MAX_VALUE;
        int leftSum = 0;
        for (int i = 0; i < A.length - 1; i++) {
            int value = A[i];
            leftSum += value;
            int result = Math.abs(leftSum - (totalSum - leftSum));
            if (result < minResult)
                minResult = result;
        }
        return minResult;
    }
}
