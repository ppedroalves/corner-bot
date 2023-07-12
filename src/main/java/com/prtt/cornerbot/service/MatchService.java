package com.prtt.cornerbot.service;


import com.prtt.cornerbot.domain.DangerousAttacksPerMinute;
import com.prtt.cornerbot.domain.Match;
import com.prtt.cornerbot.domain.Scores;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
                        if(isMatchOnFilter(m.getScores(), m.getPressureStats().getAppm1())){
                            filteredMatches.add(m);
                        }
                    }

                }

            }catch (Exception e){
                log.error("Ocorreu um erro ao tentar analisar o jogo: " +  m.getHomeTeam().getName() + " x " +  m.getAwayTeam().getName());
            }

        }
        return filteredMatches;
    }

    private boolean isMatchOnFilter(Scores gameScore, DangerousAttacksPerMinute appm) {
        if(appm.getHome() >= 1.0 && gameScore.getHomeTeamScore() <= gameScore.getAwayTeamScore())
            return true;

        if(appm.getAway() >= 1.0 && gameScore.getAwayTeamScore() <= gameScore.getHomeTeamScore())
            return true;

        return false;
    }

}
