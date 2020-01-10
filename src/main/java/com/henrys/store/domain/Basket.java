package com.henrys.store.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Basket {

    private List<Item> items = new ArrayList<>();
    private List<Offer> offers = Arrays.asList(new AppleDiscount(), new BreadAndSoupDiscount());

    public void addItems(List<String> itemNames) {
        List<Item> newItems = itemNames.stream().map(Item::getItemByName).collect(Collectors.toList());
        items.addAll(newItems);
    }

    public List<Item> listItems() {
        return Collections.unmodifiableList(items);
    }

    public BigDecimal getPriceBeforeDiscount() {
        return items.stream().map(item -> item.price).reduce(BigDecimal.ZERO, BigDecimal::add).setScale(2, RoundingMode.DOWN);
    }

    public BigDecimal getDiscountedPrice(LocalDate purchaseDate) {
        BigDecimal totalDiscount =
                offers.stream().map(offer -> offer.calculateDiscount(items, purchaseDate))
                        .reduce(BigDecimal.ZERO, BigDecimal::add);
        return getPriceBeforeDiscount().subtract(totalDiscount).setScale(2,RoundingMode.DOWN);
    }


    public String printBasketDetails(LocalDate date){
        return "Expected Total Cost ="+getDiscountedPrice(date);
    }
}
