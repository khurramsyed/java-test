package com.henrys.store.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Basket {

    private List<Item> items  = new ArrayList<>();

    public void addItems(List<String> itemNames) {
      List<Item> newItems = itemNames.stream().map(Item::getItemByName).collect(Collectors.toList());
      items.addAll(newItems);
    }

    public List<Item> listItems(){
        return Collections.unmodifiableList(items);
    }


}
