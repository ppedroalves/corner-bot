package com.prtt.cornerbot.service;


import com.prtt.cornerbot.domain.DangerousAttacksPerMinute;
import com.prtt.cornerbot.domain.Match;
import com.prtt.cornerbot.domain.Scores;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Stream;

@Service
@Slf4j
public class MatchService {

    public List<Match> filterGoodMatchesForCorners(List<Match> matches){
        log.info("Total de jogos recebeidos para análise: " + matches.size());
        List<Match> filteredMatches = new ArrayList<>();
        for (Match m: matches) {
            try{
                if(Objects.equals(m.getStatus(), "LIVE")){
                    if((m.getCurrentTime().getMinute() > 30  && m.getCurrentTime().getMinute() < 40) ||
                            (m.getCurrentTime().getMinute() > 75  && m.getCurrentTime().getMinute() <  85)){
                        if(isMatchOnFilter(m))
                            filteredMatches.add(m);
                    }

                }
            }catch (Exception e){
                log.error("Ocorreu um erro ao tentar analisar o jogo: " +  m.getHomeTeam().getName() + " x " +  m.getAwayTeam().getName());
            }

        }
        return filteredMatches;
    }

    public boolean isMatchOnFilter(Match match) {
        Predicate<Match> isDifferenceOne = m -> Math.abs(m.getScores().getHomeTeamScore() - m.getScores().getAwayTeamScore()) == 1;
        Predicate<Match> isAvgAppmHigh = m -> (m.getPressureStats().getAppm1().getAway() + m.getPressureStats().getAppm1().getHome()) / 2 > 1.05;

        return Stream.of(isDifferenceOne, isAvgAppmHigh)
                .allMatch(filter -> filter.test(match));
    }



}
