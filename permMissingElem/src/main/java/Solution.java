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

    public int getMissingPermEfficientImplementation(int[] A) {
        long dataSize=A.length;
        long totalSumOfArithmeticSeries = ((dataSize + 2) * (dataSize + 1)) / 2;
        long actualSum = 0;
        for (int value : A) actualSum += value;
        return (int) (totalSumOfArithmeticSeries - actualSum);
    }

    public int getMissingPermEfficientWithLambda(int[] A) {
        long dataSize=A.length;
        long totalSumOfArithmeticSeries = ((dataSize + 2) * (dataSize + 1)) / 2;
        return (int) (totalSumOfArithmeticSeries - IntStream.of(A).sum());
    }
}
