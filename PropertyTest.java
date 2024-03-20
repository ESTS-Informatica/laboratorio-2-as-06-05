import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PropertyTest {
    private Property property1;

    @org.junit.jupiter.api.BeforeEach
    public void setUp() {
        property1 = new Property("T3 Monte Belo", 150000.0);
    }

    @Test
    public void testConstructor() {
        assertEquals("T3 Monte Belo", property1.getDescription());
        assertEquals(150000.0, property1.getPrice());
    }
    @Test
    public void testGetId() {
        assertEquals(1, property1.getId());
    }

    @Test
    public void testGetDescription() {
        assertEquals("T3 Monte Belo", property1.getDescription());
    }
    @Test
    public void testGetPrice() {
        assertEquals(150000.0, property1.getPrice());
    }
    @Test
    public void testToString() {
        System.out.println(property1.toString());
        assertEquals("Descricao   : T3 Monte Belo" + "\n" + "Preco       : 150000.0 Euros", property1.toString());
    }
}