import java.security.InvalidParameterException;

public class PassingCars {

    //O(n^2)
    public static int countPassingCarsInefficient(int arr[]) {
        int passingCarsQty = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                for (int j = i; j < arr.length; j++)
                    passingCarsQty += arr[j];
            }
        }
        return passingCarsQty;
    }

    //O(2n)
    public static int countPassingCarsEfficient(int arr[]) {
        int passingCarsQty = 0;
        int[] prefixArr = getPrefixArr(arr);
        for (int i = 0; i < arr.length; i++)
            if (arr[i] == 0)
                passingCarsQty += (prefixArr[arr.length] - prefixArr[i+1]);
        return passingCarsQty;
    }

    private static int[] getPrefixArr(int[] baseArr) {
        //notice that prefixArr is bigger than arr and arr[0]==prefixArr[1]
        int[] prefixArr = new int[baseArr.length + 1];
        prefixArr[0] = 0;
        for (int i = 0; i < baseArr.length; i++)
            prefixArr[i + 1] = prefixArr[i] + baseArr[i];
        return prefixArr;
    }

}
