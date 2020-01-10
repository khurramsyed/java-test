package com.henrys.store.domain;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

public class HenrysStoreAppTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;


    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void restoreStreams() {
        outContent.reset();
        outContent.reset();
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    public void test3TinOfSoup2Bread_BoughtToday(){
        testResult(new String[]{"0", "soup","soup", "soup", "bread", "bread"}, "Expected Total Cost =3.15");
    }

    @Test
    public void test6ApplesAndMilkBoughtToday(){
        testResult(new String[]{"0", "apple","apple", "apple", "apple", "apple","apple","milk"}, "Expected Total Cost =1.90");
    }

    @Test
    public void test6ApplesAndMilkBoughtIn5DaysTime(){
        testResult(new String[]{"5", "apple","apple", "apple", "apple", "apple","apple","milk"}, "Expected Total Cost =1.84");
    }
    @Test
    public void test3Apples2Soups1BreadBoughtIn5DaysTime(){
        testResult(new String[]{"5", "apple","apple", "apple", "soup", "soup","bread"}, "Expected Total Cost =1.97");
    }

    @Test
    public void testInvalidItems(){
        HenryStoreApp.main(new String[]{"5", "rocket"});
        assertThat(outContent.toString()).contains("Not Found");
    }

    private void testResult(String[] args, String expectedResult) {
        HenryStoreApp.main(args);
        assertThat(outContent.toString()).isEqualTo(expectedResult);
    }


}

