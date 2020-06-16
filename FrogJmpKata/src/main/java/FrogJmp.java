import java.security.InvalidParameterException;

public class FrogJmp {
    public static int solution(int X, int Y, int D) {
        if (Y < X)
            throw new InvalidParameterException("Target position must be equal or greater then start position");
        if (D <= 0)
            throw new InvalidParameterException("Jump size must be greater than 0");
        return (int) (Math.ceil((Y - X) / (double) (D)));
    }
}
