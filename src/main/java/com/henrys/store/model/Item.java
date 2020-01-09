package com.henrys.store.model;

import java.math.BigDecimal;

public enum Item {
    SOUP("soup", new BigDecimal("0.65")),
    BREAD("bread", new BigDecimal("0.80")),
    MILK("milk", new BigDecimal("1.30")),
    APPLE("apple", new BigDecimal("0.10"));

    final String name;
    final BigDecimal price;


    Item(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return name;
    }
}
