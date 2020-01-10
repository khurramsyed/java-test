package com.henrys.store.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CommandLineParserTest {

    private CommandLineParser commandLineParser = new CommandLineParser();

    @Test
    public void errorMessageShouldBeDisplayedWhenNoParameterIsPassed(){
        assertThat(commandLineParser.parse(new String[]{})).isEqualTo(false);
    }

    @Test
    public void errorMessageShouldBeDisplayedWhenDaysIsNotANumber(){
        assertThat(commandLineParser.parse(new String[]{"X"})).isEqualTo(false);
    }

    @Test
    public void errorMessageShouldBeDisplayedWhenDaysIsANumber(){
        assertThat(commandLineParser.parse(new String[]{"1"})).isEqualTo(true);
    }
}
