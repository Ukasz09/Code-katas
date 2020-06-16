import java.util.ArrayList;
import java.util.Collections;

public class IterativeSolution {

    private static int solution(int[] A) {
        ArrayList<Integer> sum = new ArrayList<>();
        sum.add(A[0]);
        for (int i = 1; i < A.length; i++) {
            ArrayList<Integer> tmpSum = new ArrayList<>();
            for (Integer s : sum) {
                tmpSum.add(Math.abs(s + A[i]));
                tmpSum.add(Math.abs(s - A[i]));
                sum = tmpSum;
            }
        }
        return Collections.min(sum);
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 5, 2, -2}));
    }

}
