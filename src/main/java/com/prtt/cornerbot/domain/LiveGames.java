package com.prtt.cornerbot.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@Getter
@NoArgsConstructor
public class LiveGames {
    private Long total;
    private List<Data> data;
}
