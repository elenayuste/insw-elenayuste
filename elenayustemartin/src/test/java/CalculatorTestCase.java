import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;

import com.example.insw.Calculator;

public class CalculatorTestCase {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        // Setup calcuator
        this.calculator = new Calculator();
    }

    //// MULTIPLY
    /// Multiplicación normal

    @Test
    void testMultiply() {
        int result = calculator.multiply(3, 4);
        assertEquals(12, result);
    }

    /// Multiplicación con cero

    @Test
    void testMultiplyZeroLeft() {
        int result = calculator.multiply(0, 4);
        assertEquals(0, result);
    }

    @Test
    void testMultiplyZeroRight() {
        int result = calculator.multiply(4, 0);
        assertEquals(0, result);
    }

    /// Multiplicación con números negativos

    @Test
    void testMultiplyNegativeLeft() {
        int result = calculator.multiply(-3, 4);
        assertEquals(-12, result);
    }

    @Test
    void testMultiplyNegativeRight() {
        int result = calculator.multiply(3, -4);
        assertEquals(-12, result);
    }

    @Test
    void testMultiplyNegative() {
        int result = calculator.multiply(-3, -4);
        assertEquals(12, result);
    }

    //// CONCAT
    /// Concatenación de dos cadenas normales
    @Test
    void testConcat() {
        String result = calculator.concat("Hola", "Mundo");
        assertEquals("Hola Mundo", result);
    }

    /// Concatenación con uno de los parámetros nulos
    @Test
    void testConcatNullLeft() {
        String result = calculator.concat("null", "hola");
        assertEquals("empty", result);
    }

    @Test
    void testConcatNullRight() {
        String result = calculator.concat("hola", "null");
        assertEquals("empty", result);
    }

    //// SUM
    /// Suma normal
    @Test
    void testSum() {
        double result = calculator.sum(3, 4);
    }

}
