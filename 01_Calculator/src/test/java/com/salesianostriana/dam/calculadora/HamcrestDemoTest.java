package com.salesianostriana.dam.calculadora;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class HamcrestDemoTest {
    @Test
    @DisplayName("String Examples")
    void stringExamples() {
        String s1 = "Hello";
        String s2 = "Hello";

        assertThat("Comparing Strings", s1, is(s2));
        assertThat(s1, equalTo(s2));
        assertThat(s1, sameInstance(s2));
        assertThat("ABCDE", containsString("BC"));
        assertThat("ABCDE", not(containsString("EF")));
    }

    @Test
    @DisplayName("List Examples")
    void listExamples() {
        // Create an empty list
        List<String> list = new ArrayList<>();
        assertThat(list, isA(List.class));
        assertThat(list, empty());

        // Add a couple items
        list.add("One");
        list.add("Two");
        assertThat(list, not(empty()));
        assertThat(list, hasSize(2));
        assertThat(list, contains("One", "Two"));
        assertThat(list, containsInAnyOrder("Two", "One"));
        assertThat(list, hasItem("Two"));
    }

    @Test
    @DisplayName("Number Examples")
    void numberExamples() {
        assertThat(5, lessThan(10));
        assertThat(5, lessThanOrEqualTo(5));
        assertThat(5.01, closeTo(5.0, 0.01));
    }
}

