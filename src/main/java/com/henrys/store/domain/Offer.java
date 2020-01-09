package com.henrys.store.domain;

import java.math.BigDecimal;
import java.util.List;

public interface Offer {

    BigDecimal calculateDiscount(List<Item> items);
}
