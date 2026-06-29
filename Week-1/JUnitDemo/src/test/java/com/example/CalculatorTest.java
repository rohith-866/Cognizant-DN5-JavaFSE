package com.example;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {

    private Calculator calculator;

    @Before
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void testAdd() {
        assertEquals(10, calculator.add(6, 4));
    }

    @Test
    public void testSubtract() {
        assertEquals(3, calculator.subtract(8, 5));
    }

    @Test
    public void testMultiply() {
        assertEquals(20, calculator.multiply(4, 5));
    }

    @Test
    public void testDivide() {
        assertEquals(2.5, calculator.divide(5, 2), 0.001);
    }

    @Test(expected = ArithmeticException.class)
    public void testDivideByZero() {
        calculator.divide(10, 0);
    }
}
