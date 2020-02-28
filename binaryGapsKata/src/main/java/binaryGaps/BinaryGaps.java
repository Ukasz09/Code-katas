package binaryGaps;

import java.security.InvalidParameterException;

public class BinaryGaps {

    public static int getMaxGap(int number) {
        if (number <= 0)
            throw new InvalidParameterException("Number can not be negative or zero");

        String binary = Integer.toBinaryString(number);
        int maxGap = 0;
        int actualGap = 0;
        for (int i = 0; i < binary.length(); i++)
            if (binary.charAt(i) == '0')
                actualGap++;
            else {
                if (maxGap < actualGap)
                    maxGap = actualGap;
                actualGap = 0;
            }
        return maxGap;
    }
}
