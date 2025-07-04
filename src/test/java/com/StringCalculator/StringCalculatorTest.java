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
    @Test
    public void test_Any_Amount_Of_Number_String_Should_Return_Sum_Of_All_Those_Number(){
        assertEquals(12,calc.add("6,4,2"));
        assertEquals(24,calc.add("6,4,9,1,4"));
        assertEquals(37, calc.add("1,20,4,1,2,3,2,4 "));
    }
    @Test
    public void  test_NewLines_ShouldAlsoBeTreatedasDelimeter(){
        assertEquals(6,calc.add("1\n2, 3"));
    }
    @Test
    public void test_Negative_Number_Should_throw_exception(){
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
                () -> calc.add("3,4,-8"));
        assertEquals("Negatives are Not allowed: -8", thrown.getMessage());
    }
    @Test
    public void test_Numbers_Above_1000_Should_be_Ignored(){
        assertEquals(5,calc.add("1001,2,3"));
    }
    @Test
    public void test_Custom_Delimiter_Any_Length() {
        assertEquals(6, calc.add("//[***]\n1***2***3"));
    }







}
