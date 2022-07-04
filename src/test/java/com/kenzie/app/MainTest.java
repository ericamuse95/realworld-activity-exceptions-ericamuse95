package com.kenzie.app;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// DO NOT attempt to run these tests until you have resolved the compiler issues!
public class MainTest {
    @Test
    public void testIsValid_ValidInput(){
        int inputNumber = 2;
        assertTrue(Main.isValid(inputNumber));
    }

    @Test
    public void testIsValid_InvalidInput(){
        int inputNumber = 24;
        assertThrows(IllegalArgumentException.class, () -> {
            Main.isValid(inputNumber);
        });
    }

    @Test
    public void testProcessInput_ValidInput(){
        String input = "3";
        assertEquals(3, Main.processInput(input));
    }

    @Test
    public void testprocessInput_InvalidInput(){
        String input = "apples";
        assertThrows(NumberFormatException.class, () -> {
            Main.processInput(input);
        });
    }
}
