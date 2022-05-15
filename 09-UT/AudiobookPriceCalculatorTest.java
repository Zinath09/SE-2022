package put.io.testing.audiobooks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import put.io.testing.junit.Calculator;

import static org.junit.jupiter.api.Assertions.*;

class AudiobookPriceCalculatorTest {
    AudiobookPriceCalculator apc;
    Audiobook audio;
    @BeforeEach
    public void setUp(){
         apc = new AudiobookPriceCalculator();
         audio=new Audiobook("Audiobook ABC",10.0);
    }
    @Test
    public void testStandardCustomer() {

        assertEquals(10.0,apc.calculate(new Customer("", Customer.LoyaltyLevel.STANDARD, false),audio));
        assertEquals(0.0,apc.calculate(new Customer("", Customer.LoyaltyLevel.STANDARD, true),audio));
    }
    @Test
    public void testGoldCustomer() {
        assertEquals(8.0,apc.calculate(new Customer("", Customer.LoyaltyLevel.GOLD, false),audio));
        assertEquals(0,apc.calculate(new Customer("", Customer.LoyaltyLevel.GOLD, true),audio));
    }
    @Test
    public void testSilverCustomer() {
        assertEquals(9.0,apc.calculate(new Customer("", Customer.LoyaltyLevel.SILVER, false),audio));
        assertEquals(0.0,apc.calculate(new Customer("", Customer.LoyaltyLevel.SILVER, true),audio));
         }

    @Test
    public void testSubscriber() {
        assertEquals(8.0,apc.calculate(new Customer("", Customer.LoyaltyLevel.GOLD, false),audio));
        assertEquals(0.0,apc.calculate(new Customer("", Customer.LoyaltyLevel.SILVER, true),audio));
    }


}