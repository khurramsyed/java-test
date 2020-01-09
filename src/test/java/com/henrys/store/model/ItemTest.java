package com.henrys.store.model;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class ItemTest {

    @Test
    public void itemNameShouldMatchItsValue() {
        boolean namesMatch = Arrays.stream(Item.values()).allMatch(item -> item.name().equalsIgnoreCase(item.name));
        assertThat(namesMatch);
    }

    @Test
    public void itemPricesShouldMatchCorrectly(){
        assertThat(Item.SOUP.price).isEqualTo(new BigDecimal("0.65"));
        assertThat(Item.MILK.price).isEqualTo(new BigDecimal("1.30"));
        assertThat(Item.BREAD.price).isEqualTo(new BigDecimal("0.80"));
        assertThat(Item.APPLE.price).isEqualTo(new BigDecimal("0.10"));
    }



}
