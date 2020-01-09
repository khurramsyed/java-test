package com.henrys.store.domain;

import java.math.BigDecimal;
import java.util.Arrays;

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

    public static Item getItemByName(String name){
        return Arrays.stream(Item.values()).filter(item -> item.name().equalsIgnoreCase(name)).findFirst().orElseThrow(()->new IllegalArgumentException("Item "+name+ " Not Found"));
    }
}
