package com.henrys.store.domain;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AppleDiscountTest {
    private final List<Item> apples = Arrays.asList(Item.getItemByName("Apple"),Item.getItemByName("Apple"), Item.getItemByName("Apple"));

    @Test
    public void thereShouldBe10PercentDiscountOnApplesWhenOfferIsValid(){
        BigDecimal discount = new AppleDiscount().calculateDiscount(apples ,3);
        assertThat(discount).isEqualTo(new BigDecimal("0.03"));
    }

    @Test
    public void thereShouldBeNoDiscountOnApplesToday(){
        BigDecimal discount = new AppleDiscount().calculateDiscount(apples ,0);
        assertThat(discount).isEqualTo(new BigDecimal("0.00"));
    }

    @Test
    public void thereShouldBeNoDiscountOnItemOtherThanApple(){
        List<Item> items = Arrays.asList(Item.getItemByName("milk"), Item.getItemByName("soup"), Item.getItemByName("bread"));
        BigDecimal discount = new AppleDiscount().calculateDiscount(items,0);
        assertThat(discount).isEqualTo(new BigDecimal("0.00"));
    }
}
