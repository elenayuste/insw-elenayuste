import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

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
        double result = calculator.multiply(3, 4);
        assertEquals(12, result);
    }

    /// Multiplicación con cero

    @Test
    void testMultiplyZeroLeft() {
        double result = calculator.multiply(0, 4);
        assertEquals(0, result);
    }

    @Test
    void testMultiplyZeroRight() {
        double result = calculator.multiply(4, 0);
        assertEquals(0, result);
    }

    /// Multiplicación con números negativos

    @Test
    void testMultiplyNegativeLeft() {
        double result = calculator.multiply(-3, 4);
        assertEquals(-12, result);
    }

    @Test
    void testMultiplyNegativeRight() {
        double result = calculator.multiply(3, -4);
        assertEquals(-12, result);
    }

    @Test
    void testMultiplyNegative() {
        double result = calculator.multiply(-3, -4);
        assertEquals(12, result);
    }

    //// CONCAT
    /// Concatenación de dos cadenas normales
    @Test
    void testConcat() {
        String result = calculator.concat("Hola", "Mundo");
        assertEquals("HolaMundo", result);
    }

    /// Concatenación con uno de los parámetros nulos
    @Test
    void testConcatNullLeft() {
        String result = calculator.concat(null, "hola");
        assertEquals("empty", result);
    }

    @Test
    void testConcatNullRight() {
        String result = calculator.concat("hola", null);
        assertEquals("empty", result);
    }

    //// SUM
    /// Suma normal
    @Test
    void testSum() {
        double result = calculator.sum(3, 4);
        assertEquals(7, result);
    }

    /// Suma con negativos

    @Test
    void testSumNegative() {
        double result = calculator.sum(3, -4);
        assertEquals(-1, result);
    }

    //// DISCOUNT
    /// Descuento valido

    @Test
    void testDiscoun() {
        double result = calculator.discount(100, 30);
        assertEquals(70, result);
    }

    /// Descuentos del 0 y del 100
    @Test
    void testDiscoun100() {
        double result = calculator.discount(100, 100);
        assertEquals(0, result);
    }

    @Test
    void testDiscoun0() {
        double result = calculator.discount(100, 0);
        assertEquals(100, result);
    }

    /// Descuento invalido

    @Test
    void testDiscountInvPos() {
        assertThrows(IllegalArgumentException.class,
                () -> calculator.discount(100, 150));
    }

    @Test
    void testDiscountInvNeg() {
        assertThrows(IllegalArgumentException.class,
                () -> calculator.discount(100, -5));
    }

    //// CALCULATE TOTAL
    /// Lista de importes

    @Test
    void testCalculateTotal() {
        List<Double> imports = List.of(1.5, 2.5, 3.5, 4.5);

        double result = calculator.calculateTotal(imports);
        assertEquals(12, result);

    }

    /// Lista de importes vacía

    @Test
    void testCalculateTotalEmpty() {
        List<Double> imports = List.of();

        double result = calculator.calculateTotal(imports);
        assertEquals(0, result);

    }

}
