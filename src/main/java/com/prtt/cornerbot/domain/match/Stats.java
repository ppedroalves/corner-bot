package com.prtt.cornerbot.domain.match;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Getter
@NoArgsConstructor
public class Stats {
    private DangerousAttacks dangerousAttacks;
    private Corners corners;
    private GoalChances shotsOffgoal;
    private ShotsOnGoal shotsOngoal;
    private PossessionTime possessionTime;
}
