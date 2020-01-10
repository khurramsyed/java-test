package com.henrys.store.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ArgumentParsingResult {

    private boolean parsingValid;
    private Order order;

}
