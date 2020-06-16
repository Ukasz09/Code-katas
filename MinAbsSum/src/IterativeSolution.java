import java.util.Collections;
import java.util.HashSet;

public class IterativeSolution {

    private static int solution(int[] A) {
        if (A == null || A.length == 0)
            return 0;

        HashSet<Integer> sum = new HashSet<>();
        sum.add(A[0]);
        for (int i = 1; i < A.length; i++) {
            HashSet<Integer> tmpSum = new HashSet<>();
            for (Integer s : sum) {
                tmpSum.add(Math.abs(s + A[i]));
                tmpSum.add(Math.abs(s - A[i]));
                sum = tmpSum;
            }
            System.out.println();
        }
        return Collections.min(sum);
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 5, 2, -2}));
    }

}
