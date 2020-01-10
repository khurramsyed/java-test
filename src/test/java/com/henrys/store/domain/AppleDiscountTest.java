package com.henrys.store.domain;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static java.time.LocalDate.now;
import static org.assertj.core.api.Assertions.assertThat;

public class AppleDiscountTest {


    @Test
    public void thereShouldBe10PercentDiscountOnApplesWhenOfferIsValid(){
        final List<Item> apples = Arrays.asList(Item.getItemByName("Apple"),Item.getItemByName("Apple"), Item.getItemByName("Apple"));
        BigDecimal discount = new AppleDiscount().calculateDiscount(apples ,now().plusDays(3));
        assertThat(discount).isEqualTo(new BigDecimal("0.03"));
    }

    @Test
    public void thereShouldBeNoDiscountOnApplesToday(){
        final List<Item> apples = Arrays.asList(Item.getItemByName("Apple"),Item.getItemByName("Apple"), Item.getItemByName("Apple"));
        BigDecimal discount = new AppleDiscount().calculateDiscount(apples ,now());
        assertThat(discount).isEqualTo(new BigDecimal("0.00"));
    }

    @Test
    public void thereShouldBeNoDiscountOnItemOtherThanApple(){
        List<Item> items = Arrays.asList(Item.getItemByName("milk"), Item.getItemByName("soup"), Item.getItemByName("bread"));
        BigDecimal discount = new AppleDiscount().calculateDiscount(items,now().plusDays(3));
        assertThat(discount).isEqualTo(new BigDecimal("0.00"));
    }

    @Test
    public void thereShouldBeNoDiscountNextMonth(){
        List<Item> items = Arrays.asList(Item.getItemByName("Apple"),Item.getItemByName("Apple"), Item.getItemByName("Apple"));
        BigDecimal discount = new AppleDiscount().calculateDiscount(items,now().plusMonths(1).withDayOfMonth(1));
        assertThat(discount).isEqualTo(new BigDecimal("0.00"));
    }
}
