package com.imane.kata_tennis;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Getter
public enum ScoreEnum {

    ZERO(0),
    FIFTEEN(15),
    THIRTY(30),
    FORTY(40);

    private Integer  value;
}
