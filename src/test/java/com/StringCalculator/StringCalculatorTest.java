package com.StringCalculator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class StringCalculatorTest {
    StringCalculator calc = new StringCalculator();
    @Test
    void test_Empty_String_Should_Return_Zero(){
        assertEquals(0,calc.add(""));
    }

}
