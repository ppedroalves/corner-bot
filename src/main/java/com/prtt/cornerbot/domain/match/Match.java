package com.prtt.cornerbot.domain.match;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@NoArgsConstructor
@Setter
public class Match {
    private Long fixtureId;
    private AwayTeam awayTeam;
    private CurrentTime currentTime;
    private HomeTeam homeTeam;
    private League league;
    private Scores scores;
    private String status;
    private Stats stats;
    private PressureStats pressureStats;
}
