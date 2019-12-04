package com.imane.kata_tennis;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

 class Player {
    private String name;
    private Integer score;
    private List<String> allPoint = new ArrayList<String>();

     Player(String name) {
        this.name = name;
    }

}
