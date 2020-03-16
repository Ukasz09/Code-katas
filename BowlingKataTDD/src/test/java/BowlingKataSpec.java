import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class BowlingKataSpec {
    private BowlingKata gameInstance;

    @BeforeEach
    void initGameInstance() {
        gameInstance = new BowlingKata();
    }

    @Test
    void whenAllRowIsStrikeThenResult300() {
        GameRounds[] gameRound = new GameRounds[gameInstance.getRoundQty() + 2];
        for (int i = 0; i < gameRound.length; i++)
            gameRound[i] = new GameRounds(gameInstance.getPinQty());
        assertEquals(300, gameInstance.calculatePoints(gameRound));
    }

    @Test
    void whenInEveryFirstRoll9AndSecondMissThenResult90() {
        GameRounds[] gameRounds = new GameRounds[gameInstance.getRoundQty()];
        for (int i = 0; i < gameRounds.length; i++)
            gameRounds[i] = new GameRounds(9, 0);
        assertEquals(90, gameInstance.calculatePoints(gameRounds));
    }

    @Test
    void whenNoMissStrikeNorSpareThenCorrectResult() {
        int[] points = new int[]{1, 2, 5, 1, 1, 1, 2, 2, 6, 3, 1, 8, 3, 5, 3, 3, 3, 1, 2, 4};
        GameRounds[] gameRounds = new GameRounds[gameInstance.getRoundQty()];
        int offset = 0;
        for (int i = 0; i < points.length; i += 2) {
            gameRounds[offset] = new GameRounds(points[i], points[i + 1]);
            offset++;
        }
        assertEquals(Arrays.stream(points).sum(), gameInstance.calculatePoints(gameRounds));
    }

    @Test
    void whenEveryFirstTurn5AndSecondSpareThenResult150() {
        GameRounds[] gameRounds = new GameRounds[gameInstance.getRoundQty() + 1];
        for (int i = 0; i < gameRounds.length; i++)
            gameRounds[i] = new GameRounds(5, gameInstance.getPinQty() - 5);
        assertEquals(150, gameInstance.calculatePoints(gameRounds));
    }

    @Test
    void whenAllTurnsAreMissedThenResult0() {
        GameRounds[] gameRounds = new GameRounds[gameInstance.getRoundQty()];
        for (int i = 0; i < gameRounds.length; i++)
            gameRounds[i] = new GameRounds(0, 0);
        assertEquals(0, gameInstance.calculatePoints(gameRounds));
    }


}
