package com.prtt.cornerbot.service;


import com.prtt.cornerbot.domain.Match;
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
                    Double dangerousAttackHomeTeam = m.getPressureStats().getAppm1().getHome();
                    Double dangerousAttackAwayTeam = m.getPressureStats().getAppm1().getAway();
                    if((m.getCurrentTime().getMinute() > 30  && m.getCurrentTime().getMinute() < 40) ||
                            (m.getCurrentTime().getMinute() > 75  && m.getCurrentTime().getMinute() <  85)){
                        if(dangerousAttackHomeTeam >= 1){
                            if(m.getScores().getHomeTeamScore() <= m.getScores().getAwayTeamScore()){
                                filteredMatches.add(m);
                            }
                        }

                        if(dangerousAttackAwayTeam >= 1){
                            if(m.getScores().getAwayTeamScore() <= m.getScores().getHomeTeamScore()){
                                filteredMatches.add(m);
                            }
                        }
                    }

                }

            }catch (Exception e){
                log.error("Ocorreu um erro ao tentar analisar o jogo: " +  m.getHomeTeam().getName() + " x " +  m.getAwayTeam().getName());
            }

        }
        return filteredMatches;
    }
}
