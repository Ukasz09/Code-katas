import java.security.InvalidParameterException;
import java.util.Deque;
import java.util.LinkedList;

public class Nesting {
    public static boolean isNested(String signs) {
        Deque<Character> processedSigns = new LinkedList<>();
        for (int i = 0; i < signs.length(); i++) {
            char sign = signs.charAt(i);
            switch (sign) {
                case '(':
                    processedSigns.addLast(sign);
                    break;
                case ')': {
                    if (!processedSigns.isEmpty() && processedSigns.getLast() == '(')
                        processedSigns.removeLast();
                    else processedSigns.addLast(sign);
                }
                break;

                default:
                    throw new InvalidParameterException("Unallowed sign=" + sign);
            }
        }
        return processedSigns.isEmpty();
    }


}
