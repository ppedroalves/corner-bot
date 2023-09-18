package com.prtt.cornerbot.service;


import com.prtt.cornerbot.domain.match.Match;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@Slf4j
@RequiredArgsConstructor
public class MatchService {

    private final MatchCacheService matchCacheService;

    public List<Match> filterGoodMatchesForCorners(List<Match> matches){
        log.info("Total de jogos recebeidos para análise: " + matches.size());
        List<Match> filteredMatches = new ArrayList<>();
        for (Match m: matches) {
            try{
                String cacheId = buildCacheId(m);
                if(isMatchOnFilter(m) && !matchCacheService.isMatchInCache(cacheId)){
                    filteredMatches.add(m);
                    matchCacheService.addToCache(cacheId);
                }
            }catch (Exception e){
                log.error("Ocorreu um erro ao tentar analisar o jogo: " +  m.getHomeTeam().getName() + " x " +  m.getAwayTeam().getName());
            }

        }
        return filteredMatches;
    }

    private String buildCacheId(Match m) {
        return m.getFixtureId().toString() + ((m.getCurrentTime().getMinute() <= 45) ? "HT" : "FT");
    }

    private boolean isMatchOnFilter(Match match) {

        return (Objects.equals(match.getStatus(), "LIVE"))  &&  isMatchOnMinute(match.getCurrentTime().getMinute())
                && isMatchOnAppmHigh(match) && isMatchHaveGoalChances(match);

    }

    private boolean isMatchOnMinute(Long minute){
       return (minute >= 28  &&  minute < 40) ||
                (minute > 75 && minute < 90);
    }

    private boolean isMatchOnAppmHigh(Match match){

        return (match.getPressureStats().getAppm1().getHome() >= 1.0 &&
                match.getScores().getHomeTeamScore() - match.getScores().getAwayTeamScore() <= 0) ||
                (match.getPressureStats().getAppm1().getAway() >= 1.0 &&
                        match.getScores().getAwayTeamScore() - match.getScores().getHomeTeamScore() <= 0);
    }

    private boolean isMatchHaveGoalChances(Match m){
        Long homeShots =  m.getStats().getShotsOffgoal().getHome() + m.getStats().getShotsOngoal().getHome();
        Long awayShots =  m.getStats().getShotsOffgoal().getAway() + m.getStats().getShotsOngoal().getAway();
        Long totalShots = homeShots + awayShots;

        Long differencePossetionTime = Math.abs(m.getStats().getPossessionTime().getAway() - m.getStats().getPossessionTime().getHome());

        boolean isFirstHalf = m.getCurrentTime().getMinute() <= 45;
        boolean hasEnoughGoalChances = (isFirstHalf && totalShots > 7) || (!isFirstHalf && totalShots >= 15);

        return (differencePossetionTime >= 20)  &&  hasEnoughGoalChances;

    }

}
