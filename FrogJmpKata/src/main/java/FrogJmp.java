import java.security.InvalidParameterException;

public class FrogJmp {
    public static int getMinJumpQty(int startPosition, int targetPosition, double jumpSize) {
        if (targetPosition < startPosition)
            throw new InvalidParameterException("Target position must be equal or greater then start position");
        if (jumpSize <= 0)
            throw new InvalidParameterException("Jump size must be greater than 0");
        return (int) Math.ceil((targetPosition-startPosition)/jumpSize);
    }
}
