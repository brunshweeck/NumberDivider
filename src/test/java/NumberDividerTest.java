import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberDividerTest {

    NumberDivider numberDivider;

    @BeforeEach
    void setUp() {
        numberDivider = new NumberDivider();
    }

    @Test
    public void divideFiniteStrictlyPositiveByZeroTest() {
        assertTrue(Double.isInfinite(numberDivider.divide(+99.0, +0.0)));
        assertTrue(Double.isInfinite(numberDivider.divide(+99.0, -0.0)));
    }

    @Test
    public void divideFiniteStrictlyNegativeByZeroTest() {
        assertTrue(Double.isInfinite(numberDivider.divide(-99.0, +0.0)));
        assertTrue(Double.isInfinite(numberDivider.divide(-99.0, -0.0)));
    }

    @Test
    public void dividePositiveInfinityByZeroTest() {
        assertTrue(Double.isInfinite(numberDivider.divide(Double.POSITIVE_INFINITY, +0.0)));
        assertTrue(Double.isInfinite(numberDivider.divide(Double.POSITIVE_INFINITY, -0.0)));
    }

    @Test
    public void divideNegativeInfinityByZeroTest() {
        assertTrue(Double.isInfinite(numberDivider.divide(Double.NEGATIVE_INFINITY, +0.0)));
        assertTrue(Double.isInfinite(numberDivider.divide(Double.NEGATIVE_INFINITY, -0.0)));
    }

    @Test
    public void divideNaNByZeroTest() {
        assertTrue(Double.isNaN(numberDivider.divide(Double.NaN, +0.0)));
        assertTrue(Double.isNaN(numberDivider.divide(Double.NaN, -0.0)));
    }

    @Test
    public void divideZeroByZeroTest() {
        assertTrue(Double.isNaN(numberDivider.divide(+0.0, +0.0)));
        assertTrue(Double.isNaN(numberDivider.divide(+0.0, -0.0)));
        assertTrue(Double.isNaN(numberDivider.divide(-0.0, +0.0)));
        assertTrue(Double.isNaN(numberDivider.divide(-0.0, -0.0)));
    }

    @Test
    public void divideByOneTest() {
        assertEquals(99, numberDivider.divide(99, 1));
    }

    @Test
    public void divideFinalNonZeroByItselfTest() {
        assertEquals(1, numberDivider.divide(99, 99));
        assertEquals(1, numberDivider.divide(-99, -99));
    }

    @Test
    public void divideFinalNonZeroByNegationTest() {
        assertEquals(-1, numberDivider.divide(99, -99));
        assertEquals(-1, numberDivider.divide(-99, 99));
    }

    @Test
    public void divideOthersByOthersTest() {
        assertEquals(0.7734375, numberDivider.divide(99, 128));
    }

}