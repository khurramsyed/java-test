package com.henrys.store.domain;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class BasketTest {

    private Basket basket;

    @Before
    public void setUp(){
        basket = new Basket();
    }

    @Test
    public void addValidItems(){
        basket.addItems(Arrays.asList("apple","apple", "milk", "bread", "soup"));
        assertThat(basket.listItems().size()).isEqualTo(5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addInvalidItems(){
        basket.addItems(Arrays.asList("apple","apple", "milk", "beard", "soup"));
    }
}
