
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.DisplayName;

import org.junit.jupiter.api.RepeatedTest;

import org.junit.jupiter.api.*;


public class CalculatorTest {
    private  Calculator calculator;

    @BeforeEach
    public void setup () throws Exception {
        calculator = new Calculator();
    }

    @Test
    @DisplayName("Multiply Function")
    public void testMultiply (){
        assertEquals(20 , calculator.multiply(4,5));
    }

    @Test
    @DisplayName("Add num")
     void addNumbers(){
        assertNotEquals(5,calculator.add(1,1));
    }
}
