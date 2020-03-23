import java.security.InvalidParameterException;

public class SlicesSum {
    //Complexity: O(N)
    public static int singleSliceSumBetweenExcludedIndexes(int[] arr, int startIndex, int endIndex) {
        int maxActualEnding = 0;
        int maxResult = maxActualEnding;
        if (startIndex < 0 || startIndex > arr.length - 1 || endIndex > arr.length - 1 || endIndex < 0 || endIndex < startIndex)
            throw new InvalidParameterException("Incorrect indexes");
        for (int i = startIndex + 1; i < endIndex; i++) {
            maxActualEnding = Math.max(0, maxActualEnding + arr[i]);
            maxResult = Math.max(maxResult, maxActualEnding);
        }
        return maxResult;
    }

    //Complexity: O(N^2)
    public static int getMaxDoubleSliceSum(int[] arr) {
        int maxResult = 0;
        if (arr.length < 3)
            throw new InvalidParameterException("Incorrect indexes");
        for (int i = 1; i < arr.length - 2; i++) {
            int actualMax = getMaxFromEndToStartIndexExcluded(arr, 0, i) + getMaxFromStartedToEndIndexExcluded(arr, i, arr.length - 1);
            maxResult = Math.max(actualMax, maxResult);
        }
        return maxResult;
    }

    private static int getMaxFromStartedToEndIndexExcluded(int[] arr, int startIndex, int endIndex){
        if (startIndex < 0 || startIndex >= arr.length - 1 || endIndex > arr.length - 1 || endIndex < 0 || endIndex < startIndex)
            throw new InvalidParameterException("Incorrect indexes");
        int maxResult=0;
        int actual=0;
        for (int i = startIndex+1; i < endIndex; i++) {
            actual+=arr[i];
            maxResult=Math.max(actual,maxResult);
        }
        return maxResult;
    }

    private static int getMaxFromEndToStartIndexExcluded(int[] arr, int endIndex, int startIndex){
        if (endIndex < 0 || endIndex > arr.length - 1 || startIndex > arr.length - 1 || startIndex <= 0 || startIndex < endIndex)
            throw new InvalidParameterException("Incorrect indexes");
        int maxResult=0;
        int actual=0;
        for (int i = startIndex-1; i >endIndex; i--) {
            actual+=arr[i];
            maxResult=Math.max(actual,maxResult);
        }
        return maxResult;
    }

}
