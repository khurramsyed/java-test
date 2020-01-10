package com.henrys.store.domain;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface Offer {

    BigDecimal calculateDiscount(List<Item> items, LocalDate purchaseDate);
    boolean isApplicable(LocalDate purchaseDate);
}
