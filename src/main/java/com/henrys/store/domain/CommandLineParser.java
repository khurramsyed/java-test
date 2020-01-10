package com.henrys.store.domain;

import lombok.Getter;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class CommandLineParser {

    private LocalDate orderDay;
    private List<Item> stockItems;
    private String errorMessage;

    public static final String INVALID_USAGE = "Usage HenrysStoreApp <difference from current day>  <Item1> <Itme2> ....";

    public ArgumentParsingResult parse(String... args) {
        if (args.length <= 1) {
            errorMessage = INVALID_USAGE;
            return new ArgumentParsingResult(false, null);
        }

        return new ArgumentParsingResult(parseOrderDay(args[0]) && parserOrderItems(args),
                new Order(orderDay, stockItems));
    }

    private boolean parseOrderDay(String arg) {
        try {
            orderDay = LocalDate.now().plusDays(Integer.valueOf(arg));
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean parserOrderItems(String... args) {
        List<String> inputItems = Arrays.asList(Arrays.copyOfRange(args, 1, args.length ));
        try {
            stockItems = inputItems.stream().map(Item::getItemByName).collect(Collectors.toList());
            return true;
        } catch (IllegalArgumentException ex) {
            errorMessage = ex.getMessage();
            return false;
        }
    }
}
