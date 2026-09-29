import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import com.example.insw.model.Article;

public class ArticleTest {
    private Article articulo;

    @BeforeEach
    void setUp() {
        // Setup calcuator
        this.articulo = new Article("camiseta", 2, 15.5, 20);

    }

    @Test
    void testGetGrossAmount() {
        double result = articulo.getGrossAmount();
        assertEquals(31, result);
    }

    @Test
    void testGetDiscountAmount() {
        double result = articulo.getDiscountedAmount();
        assertEquals(24.8, result);
    }

}
