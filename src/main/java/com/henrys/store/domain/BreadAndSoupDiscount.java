package com.henrys.store.domain;

import java.math.BigDecimal;
import static java.time.LocalDate.now;
import java.time.LocalDate;
import java.util.List;

public class BreadAndSoupDiscount extends TimeBoundOffer {
    @Override
    protected LocalDate setOfferStartDate() {
        return now().minusDays(1);
    }

    @Override
    protected LocalDate setOfferEndDate() {
        //TODO: Check with the PO if it is 7 days from now or 7 days in total.
        return now().plusDays(6);
    }

    @Override
    public BigDecimal calculateDiscount(List<Item> items, LocalDate purchaseDate) {
        if(isApplicable(purchaseDate)){

        }
        return new BigDecimal("0.00");
    }
}
