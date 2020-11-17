package com.salesianostriana.dam.calculadora;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CoverageTest {

    @Test
    public void whenEmptyString_thenAccept() {
        Palindromo palindromoTester = new Palindromo();
        assertTrue(palindromoTester.isPalindrome(""));
    }

}
