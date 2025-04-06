import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
class FactorielTest {
    @Test
    void factorielOfZeroShouldReturnOne() {
        assertEquals(1, Factoriel.factoriel(0));
    }

    @Test
    void factorielOfPositiveNumberShouldReturnCorrectResult() {
        assertEquals(120, Factoriel.factoriel(5));
        assertEquals(1, Factoriel.factoriel(1));
        assertEquals(3628800, Factoriel.factoriel(10));
    }

    @Test
    void factorielOfNegativeNumberShouldThrowException() {
        assertThrows(IllegalArgumentException.class, () -> Factoriel.factoriel(-1));
    }

}