package com.henrys.store.domain;

import java.util.stream.Collectors;

public class HenryStoreApp {

    public static void main(String args[]) {


        CommandLineParser commandLineParser = new CommandLineParser();
        ArgumentParsingResult parsingResult = commandLineParser.parse(args);

        if(parsingResult.isParsingValid()) {

            Basket basket = new Basket();
            basket.addItems(parsingResult.getOrder().getItems());
            System.out.print(basket.printBasketDetails(parsingResult.getOrder().getOrderDate()));

        }else{

            System.out.print(commandLineParser.getErrorMessage());
        }

    }
}
