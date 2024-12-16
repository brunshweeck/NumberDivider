import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class NumberDividerTest {

    NumberDivider numberDivider = new NumberDivider();

//    @Test
//    public void divideStatusTest() {
//        assertTrue(numberDivider.isActive(LocalTime.NOON));
//    }

    @Test
    public void divideFiniteNonZeroByZeroTest() {
        for (int i = 1; i < 10; i++) {
            assertTrue(Double.isInfinite(numberDivider.divide(i, 0.0)));
        }
    }

    @Test
    public void divideInfiniteByZeroTest() {
        assertTrue(Double.isInfinite(numberDivider.divide(Double.POSITIVE_INFINITY, 0.0)));
        assertTrue(Double.isInfinite(numberDivider.divide(Double.NEGATIVE_INFINITY, 0.0)));
    }

    @Test
    public void divideNaNByZeroTest() {
        assertTrue(Double.isNaN(numberDivider.divide(Double.NaN, 0.0)));
    }

    @Test
    public void divideZeroByZeroTest() {
        assertTrue(Double.isNaN(numberDivider.divide(0.0, 0.0)));
    }

    @Test
    public void divideByOneTest() {
        for (int i = 0; i < 10; i++) {
            assertEquals(numberDivider.divide(i, 1), i);
        }
    }

    @Test
    public void divideFinalNonZeroByItselfTest() {
        for (int i = 0; i < 10; i++) {
            assertEquals(numberDivider.divide(i, i), 1);
        }
    }

}