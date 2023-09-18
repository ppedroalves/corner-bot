package com.prtt.cornerbot.domain.match;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonProperty("possessiontime")
    private PossessionTime possessionTime;
}
