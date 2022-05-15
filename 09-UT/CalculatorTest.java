package put.io.testing.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.common.TextParsingException;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest
{
    private Calculator calculator;
    @BeforeEach
    public void setUp(){
        calculator = new Calculator();
    }
    @Test
    public void testMultiplication() {
        assertEquals(0,calculator.multiply(0,4));
        assertEquals(12,calculator.multiply(3,4));
    }
    @Test
    public void testAdding() {
        assertEquals(4,calculator.add(0,4));
        assertEquals(7,calculator.add(3,4));
    }

@Test
void testExpectedExceptionFail() {
    IllegalArgumentException thrown = Assertions
            .assertThrows(IllegalArgumentException.class, () -> {
                calculator.addPositiveNumbers(-1,2);
            }, "NumberFormatException error was expected");

    Assertions.assertEquals("The arguments must be positive", thrown.getMessage());
}


}