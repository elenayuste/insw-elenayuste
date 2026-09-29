import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import com.example.insw.model.Article;
import com.example.insw.model.Order;

public class OrderTest {

    private Order order;

    @BeforeEach
    void setUp() {
        // Setup calcuator
        Article a1 = new Article("camiseta", 2, 15.5, 20);
        Article a2 = new Article("sudadera", 5, 50, 10);
        Article a3 = new Article("cinturon", 3, 8, 15);

        List<Article> articulos = List.of(a1, a2, a3);
        this.order = new Order("1", articulos);
    }

    @Test
    void testGetGrossTotal() {
        double resultado = order.getGrossTotal();
        assertEquals(305, resultado);
    }

    @Test
    void testGetDiscountTotal() {
        double resultado = order.getDiscountedTotal();
        assertEquals(270.2, resultado);
    }

}
