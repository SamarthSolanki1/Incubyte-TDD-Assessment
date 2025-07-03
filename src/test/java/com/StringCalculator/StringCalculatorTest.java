package com.StringCalculator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class StringCalculatorTest {
    StringCalculator calc = new StringCalculator();
    @Test
    void test_Empty_String_Should_Return_Zero(){
        assertEquals(0,calc.add(""));
    }
    @Test
    void test_Single_Number_Should_Return_That_Number(){
        assertEquals(1,calc.add(" 1"));
        assertEquals(82,calc.add("82    "));
    }
    @Test
    void test_Two_Numbers_Should_Return_Sum(){
        assertEquals(6,calc.add("3,3"));
        assertEquals(30,calc.add("  10,20  "));
    }

}
