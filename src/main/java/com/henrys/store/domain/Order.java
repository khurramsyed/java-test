package com.henrys.store.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@Data
public class Order {

    private LocalDate orderDate;
    private List<Item> items;
}
