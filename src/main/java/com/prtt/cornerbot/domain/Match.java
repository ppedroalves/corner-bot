package com.prtt.cornerbot.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Getter
@NoArgsConstructor
public class Match {
    private Long fixtureId;
    private AwayTeam awayTeam;
    private CurrentTime currentTime;
    private HomeTeam homeTeam;
    private Scores scores;
    private String status;
    private Stats stats;
    private PressureStats pressureStats;
}
