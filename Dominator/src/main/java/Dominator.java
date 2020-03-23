import java.util.Deque;
import java.util.LinkedList;

public class Dominator {

    //Complexity: O(N)
    public static int getDominatorPosition(int[] arr) {
        Deque<Integer> stack = new LinkedList<>();

        for (int value : arr)
            if (stack.isEmpty() || stack.peek() == value)
                stack.push(value);
            else stack.pop();

        if (stack.isEmpty())
            return -1;
        int count = 0;
        int index = -1;
        int candidate = stack.pop();
        for (int i = 0; i < arr.length; i++)
            if (arr[i] == candidate) {
                count++;
                index = i;
            }
        return (count > (int) (arr.length / 2d)) ? index : -1;
    }
}
