package com.henrys.store.domain;

import java.time.LocalDate;

import static java.time.LocalDate.now;

public abstract class TimeBoundOffer implements Offer {
    private final LocalDate startDate;
    private final LocalDate endDate;

    public TimeBoundOffer(){
        startDate = setOfferStartDate();
        endDate = setOfferEndDate();
    }

    @Override
    public boolean isApplicable(LocalDate purchaseDate) {
        return (purchaseDate.isAfter(startDate) || purchaseDate.isEqual(startDate)) &&
                (purchaseDate.isBefore(endDate) || purchaseDate.isEqual(endDate));
    }

    protected abstract LocalDate setOfferStartDate();
    protected abstract LocalDate setOfferEndDate();
}
