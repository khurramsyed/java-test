package com.henrys.store.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CommandLineParserTest {

    private CommandLineParser commandLineParser = new CommandLineParser();

    @Test
    public void errorMessageShouldBeDisplayedWhenNoParameterIsPassed(){
        assertThat(commandLineParser.parse(new String[]{}).isParsingValid()).isEqualTo(false);
    }

    @Test
    public void errorMessageShouldBeDisplayedWhenDaysIsNotANumber(){
        assertThat(commandLineParser.parse(new String[]{"X", "apple"}).isParsingValid()).isEqualTo(false);
    }

    @Test
    public void errorMessageShouldBeDisplayedWhenMissingParameter(){
        assertThat(commandLineParser.parse(new String[]{"1"}).isParsingValid()).isEqualTo(false);
        assertThat(commandLineParser.getErrorMessage()).isEqualTo(CommandLineParser.INVALID_USAGE);
    }

    @Test
    public void noErrorMessageShouldBeDisplayedWhenCorrectParamtersPassed(){
        assertThat(commandLineParser.parse(new String[]{"1", "apple", "soup"}).isParsingValid()).isEqualTo(true);
        assertThat(commandLineParser.getStockItems()).contains(Item.APPLE.name.toLowerCase());
        assertThat(commandLineParser.getStockItems()).contains(Item.SOUP.name.toLowerCase());
    }

    @Test
    public void noErrorMessageShouldBeDisplayedWhenInvalidItemsIsPassed(){
        assertThat(commandLineParser.parse(new String[]{"1", "apple", "invalid itme"}).isParsingValid()).isEqualTo(false);
        assertThat(commandLineParser.getErrorMessage()).contains("Not Found");
    }
}
