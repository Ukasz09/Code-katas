import java.util.*;

public class Solution {
    private static int minResult = Integer.MAX_VALUE;

    private static void calcValues(int[] A, int[] S, int endIndex, boolean negativeValue, HashMap<List<Integer>, Integer> calculatedValues) {
        S[endIndex] = negativeValue ? -1 : 1;
        if (endIndex + 1 < A.length) {
            calcValues(A, S, endIndex + 1, true, calculatedValues);
            calcValues(A, S, endIndex + 1, false, calculatedValues);
        } else {
            int result = Math.abs(calcResult(A, S, endIndex, calculatedValues));
            if (result < minResult)
                minResult = result;
        }
    }

    private static int calcResult(int[] A, int[] S, int endIndex, HashMap<List<Integer>, Integer> alreadyCalcVal) {
        if (endIndex == 0) {
            int result = A[0] * S[0];
            alreadyCalcVal.put(new ArrayList<>(Collections.singletonList(result)), result);
            return result;
        }

        List<Integer> usedValuesS = new ArrayList<>(endIndex + 1);
        for (int i = 0; i < endIndex + 1; i++)
            usedValuesS.add(S[i]);
        if (alreadyCalcVal.containsKey(usedValuesS))
            return alreadyCalcVal.get(usedValuesS);

        int result = A[endIndex] * S[endIndex] + calcResult(A, S, endIndex - 1, alreadyCalcVal);
        alreadyCalcVal.put(usedValuesS, result);
        return result;
    }

    private static int solution(int[] A) {
        int uniqueValuesQty = (2 + A.length + 1) / 2 * A.length; //arithmetic sequence
        HashMap<List<Integer>, Integer> calcValues = new HashMap<>(uniqueValuesQty);
        calcValues(A, new int[A.length], 0, true, calcValues);
        calcValues(A, new int[A.length], 0, false, calcValues);
        return minResult;
    }

    //----------------------------------------------------------------------------------------------------------------//
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 5, 2, -2}));
    }

}
