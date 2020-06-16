import java.util.HashSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {
    public int getMissingPerm(int[] A) {
        int[] count = new int[A.length + 2];
        for (int value : A) count[value]++;
        for (int i = 1; i < count.length; i++)
            if (count[i] == 0)
                return i;
        return 0;
    }

    public int getMissingPermEfficientArithmeticSeries(int[] A) {
        long dataSize = A.length;
        long totalSumOfArithmeticSeries = ((dataSize + 2) * (dataSize + 1)) / 2;
        long actualSum = 0;
        for (int value : A) actualSum += value;
        return (int) (totalSumOfArithmeticSeries - actualSum);
    }

    public int getMissingPermHashSet(int[] A) {
        HashSet<Integer> set = IntStream.rangeClosed(1, A.length + 1).boxed().collect(Collectors.toCollection(HashSet::new));
        for (Integer numb : A) set.remove(numb);
        return set.iterator().next();
    }

    public int getMissingPermWithLambda(int[] A) {
        long dataSize = A.length;
        long totalSumOfArithmeticSeries = ((dataSize + 2) * (dataSize + 1)) / 2;
        return (int) (totalSumOfArithmeticSeries - IntStream.of(A).sum());
    }
}
