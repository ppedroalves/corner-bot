package com.prtt.cornerbot.domain.match;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@Getter
@NoArgsConstructor
public class LiveMatches {
    private Long total;
    @JsonProperty("data")
    private List<Match> matches;
}
