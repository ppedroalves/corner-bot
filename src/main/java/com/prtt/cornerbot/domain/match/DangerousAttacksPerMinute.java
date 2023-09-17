package com.prtt.cornerbot.domain.match;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Getter
@NoArgsConstructor
public class DangerousAttacksPerMinute {
    private Double home;
    private Double away;
}
