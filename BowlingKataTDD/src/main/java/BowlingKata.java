//todo: exceptions check (correct number of rounds, roll points etc)

/**
 * Assumed that:
 * - We will not provide live scores display - scores when game isn't finished
 */
public class BowlingKata {
    public static final int DEFAULT_PIN_QTY = 10;
    public static final int DEFAULT_ROUND_QTY = 10;

    private int pinQty = DEFAULT_PIN_QTY;
    private int roundQty = DEFAULT_ROUND_QTY;

    //----------------------------------------------------------------------//
    public int calculatePoints(GameRounds[] gameRounds) {
        int result = 0;
        for (int i = 0; i < pinQty; i++) {
            result += gameRounds[i].fstRoll;

            if (isStrike(gameRounds[i])) {
                result += gameRounds[i + 1].fstRoll;
                if (isStrike(gameRounds[i + 1]))
                    result += gameRounds[i + 2].fstRoll;
                else result += gameRounds[i + 1].sndRoll;
            } else {
                result += gameRounds[i].sndRoll;
                if (isSpare(gameRounds[i]))
                    result += gameRounds[i + 1].fstRoll;
            }
        }
        return result;
    }

    boolean isStrike(GameRounds gameRound) {
        return gameRound.fstRoll == pinQty;
    }

    boolean isSpare(GameRounds gameRound) {
        return gameRound.fstRoll + gameRound.sndRoll == pinQty;
    }

    public int getPinQty() {
        return pinQty;
    }

    public int getRoundQty() {
        return roundQty;
    }
}
