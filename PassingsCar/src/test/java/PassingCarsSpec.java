import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PassingCarsSpec {
    @Nested
    class InefficientPassingCarsTest{
        @Test
        void when0PassingCarsThen0() {
            int[] cars = {1, 1, 1, 1, 0, 0};
            assertEquals(0, PassingCars.countPassingCarsInefficient(cars));
            cars = new int[]{0, 0, 0, 0, 0, 0, 0};
            assertEquals(0, PassingCars.countPassingCarsInefficient(cars));
        }

        @Test
        void when5PassingCarsThenResult5() {
            int[] cars = {0, 1, 0, 1, 1};
            assertEquals(5, PassingCars.countPassingCarsInefficient(cars));
        }

        @Test
        void when8PassingCarsThenResult8() {
            int[] cars = {1, 0, 0, 1, 0, 1, 1};
            assertEquals(8, PassingCars.countPassingCarsInefficient(cars));
        }

        @Test
        void when1PassingCarsThenResult1() {
            int[] cars = {0, 1};
            assertEquals(1, PassingCars.countPassingCarsInefficient(cars));
        }
    }

    @Nested
    class EfficientPassingCarsTest{
        @Test
        void when0PassingCarsThen0() {
            int[] cars = {1, 1, 1, 1, 0, 0};
            assertEquals(0, PassingCars.countPassingCarsEfficient(cars));
            cars = new int[]{0, 0, 0, 0, 0, 0, 0};
            assertEquals(0, PassingCars.countPassingCarsEfficient(cars));
        }

        @Test
        void when5PassingCarsThenResult5() {
            int[] cars = {0, 1, 0, 1, 1};
            assertEquals(5, PassingCars.countPassingCarsEfficient(cars));
        }

        @Test
        void when8PassingCarsThenResult8() {
            int[] cars = {1, 0, 0, 1, 0, 1, 1};
            assertEquals(8, PassingCars.countPassingCarsEfficient(cars));
        }

        @Test
        void when1PassingCarsThenResult1() {
            int[] cars = {0, 1};
            assertEquals(1, PassingCars.countPassingCarsEfficient(cars));
        }
    }
}
