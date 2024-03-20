import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompanyTest {
    private Company company;
    private User client1, client2, client3, client4, seller1, seller2, seller3, seller4;
    private Property property1, property2, property3, property4;
    private Sell sell1, sell2;
    @BeforeEach
    void setUp() {
        client1 = new User("José Manuel", "911111111", "zemanel@yahoo.com");
        client2 = new User("António Francisco", "922222222", "tochico@hotmail.com");
        client3 = new User("António Francisco", "922222222", "tochico@hotmail.com");
        client4 = new User("José Manuel", "911111111", "zemanel@yahoo.com");

        seller1 = new User("Fernando Fernandes", "966777101", "fefe@remax.pt");
        seller2 = new User("Rodrigo Rodrigues", "966777152", "roro@remax.pt");
        seller3 = new User("Fernando Fernandes", "966777101", "fefe@remax.pt");
        seller4 = new User("Rodrigo Rodrigues", "966777152", "roro@remax.pt");

        property1 = new Property("T3 Monte Belo", 150000.0);
        property2 = new Property("T2 Morgada", 100000.0);
        property3 = new Property("T3 Monte Belo", 150000.0);
        property4 = new Property("T2 Morgada", 100000.0);

        sell1 = new Sell(client1, seller1, property1);
        sell2 = new Sell(client2, seller2, property2);

        company = new Company();

        company.registerClient(client1);
        company.registerClient(client2);

        company.registerSeller(seller1);
        company.registerSeller(seller2);

        company.registerProperty(property1);
        company.registerProperty(property2);

        company.registerSell(sell1);
        company.registerSell(sell2);
    }
    @Test
    public void testConstructor() {
        assertNotNull(company.getClients());
        assertNotNull(company.getSellers());
        assertNotNull(company.getProperties());
        assertNotNull(company.getSells());
    }
    @Test
    public void testRegisterClient() {
        assertTrue(company.registerClient(client3));
    }

    @Test
    public void testRegisterClients() {
        assertTrue(company.registerClient(client3));
        assertTrue(company.registerClient(client4));
    }
    @Test
    public void testRegisterClientDuplicate() {
        assertFalse(company.registerClient(client1));
        company.registerClient(client4); //tive que meter este método dentro deste teste porque no setup já defini
        //um cliente com a mesma informação, se metesse no setup este método os outros testes (registerClient, register
        // Clients) não passavam. O mesmo acontece para sellers e properties.
        assertFalse(company.registerClient(client4));
    }
    @Test
    public void testRegisterClientNull() {
        assertNotNull(company.registerClient(client1));
        assertNotNull(company.registerClient(client2));
        assertNotNull(company.registerClient(client3));
        assertNotNull(company.registerClient(client4));
    }
    @Test
    public void testRegisterSeller() {
        assertTrue(company.registerSeller(seller3));
    }
    @Test
    public void testRegisterSellers() {
        assertTrue(company.registerSeller(seller3));
        assertTrue(company.registerSeller(seller4));
    }
    @Test
    public void testRegisterSellerDuplicate() {
        assertFalse(company.registerSeller(seller1));
        company.registerSeller(seller3);
        assertFalse(company.registerSeller(seller3));
    }
    @Test
    public void testRegisterSellerNull() {
        assertNotNull(company.registerSeller(seller1));
        assertNotNull(company.registerSeller(seller2));
        assertNotNull(company.registerSeller(seller3));
        assertNotNull(company.registerSeller(seller4));
    }
    @Test
    public void testRegisterProperty() {
        assertTrue(company.registerProperty(property3));
    }
    @Test
    public void testRegisterProperties() {
        assertTrue(company.registerProperty(property3));
        assertTrue(company.registerProperty(property4));
    }
    @Test
    public void testRegisterPropertyDuplicate() {
        assertFalse(company.registerProperty(property1));
        company.registerProperty(property3);
        assertFalse(company.registerProperty(property3));
    }
}