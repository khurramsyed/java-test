package com.henrys.store.domain;

import java.time.LocalDate;

public class CommandLineParser {

    private LocalDate orderDay;

    public boolean parse(String args[]) {
        if (args.length == 0) {
            return false;
        }
        return parseOrderDay(args[0]);
    }

    private boolean parseOrderDay(String arg) {
        try {
            orderDay = LocalDate.now().plusDays(Integer.valueOf(arg));
            return true;
        }
        catch (NumberFormatException e) {
          return false;
        }
    }
}
