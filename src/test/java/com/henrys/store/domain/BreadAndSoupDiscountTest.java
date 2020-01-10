package com.henrys.store.domain;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static java.time.LocalDate.now;
import static org.assertj.core.api.Assertions.assertThat;

public class BreadAndSoupDiscountTest {

    @Test
    public void shouldBeNoDiscountWith_NonDisountItems(){
        List<Item> items = Arrays.asList(Item.getItemByName("milk"), Item.getItemByName("bread"));
        assertThat(new BreadAndSoupDiscount().calculateDiscount(items,now())).isEqualTo(new BigDecimal("0.00"));
    }

    @Test
    public void shouldBeNoDiscountWhen_DiscountHasNotStarted(){
        List<Item> items = Arrays.asList(Item.getItemByName("soup"),Item.getItemByName("soup"), Item.getItemByName("bread"));
        assertThat(new BreadAndSoupDiscount().calculateDiscount(items,now().minusDays(2))).isEqualTo(new BigDecimal("0.00"));
    }

    @Test
    public void shouldHaveDiscountWhen_DiscountedItemsArePresent_And_DiscountStarted(){
        List<Item> items = Arrays.asList(Item.getItemByName("soup"),Item.getItemByName("soup"), Item.getItemByName("bread"));
        assertThat(new BreadAndSoupDiscount().calculateDiscount(items,now())).isEqualTo(new BigDecimal("0.40"));
    }

    @Test
    public void shouldHaveNoDiscountWhen_DiscountedItemsArePresent_And_DiscountEndDateIsPassed(){
        List<Item> items = Arrays.asList(Item.getItemByName("soup"),Item.getItemByName("soup"), Item.getItemByName("bread"));
        assertThat(new BreadAndSoupDiscount().calculateDiscount(items,now().plusDays(7))).isEqualTo(new BigDecimal("0.00"));
    }

    @Test
    public void shouldHaveNoDiscount_WhenThereIsNoBread(){
        List<Item> items = Arrays.asList(Item.getItemByName("soup"),Item.getItemByName("soup"));
        assertThat(new BreadAndSoupDiscount().calculateDiscount(items,now())).isEqualTo(new BigDecimal("0.00"));
    }

    @Test
    public void shouldHaveNoDiscount_WhenThereIsNotEnoughSoups(){
        List<Item> items = Arrays.asList(Item.getItemByName("soup"),Item.getItemByName("bread"));
        assertThat(new BreadAndSoupDiscount().calculateDiscount(items,now())).isEqualTo(new BigDecimal("0.00"));
    }
}
