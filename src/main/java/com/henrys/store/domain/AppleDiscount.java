package com.henrys.store.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import static java.time.LocalDate.now;

import java.time.LocalDate;
import java.util.List;

public class AppleDiscount extends TimeBoundOffer {
    @Override
    public BigDecimal calculateDiscount(List<Item> items, int daysInFuture) {
        if(isApplicable(daysInFuture)) {
            return items.stream().filter(Item.APPLE::equals)
                    .map(item -> item.price.multiply(new BigDecimal("0.1")))
                    .reduce(BigDecimal.ZERO, BigDecimal::add)
                    .setScale(2, RoundingMode.DOWN);
        }
        return new BigDecimal("0.00");
    }

    @Override
    protected LocalDate setOfferStartDate() {
        return now().plusDays(3);
    }

    @Override
    protected LocalDate setOfferEndDate() {
        return now().plusMonths(1).withDayOfMonth(1);
    }
}
