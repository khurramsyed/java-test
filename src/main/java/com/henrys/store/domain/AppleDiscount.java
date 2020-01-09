package com.henrys.store.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class AppleDiscount implements Offer {
    @Override
    public BigDecimal calculateDiscount(List<Item> items) {
        return items.stream().filter(Item.APPLE::equals)
                .map(item -> item.price.multiply(new BigDecimal("0.1")))
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .setScale(2, RoundingMode.DOWN);
    }
}
