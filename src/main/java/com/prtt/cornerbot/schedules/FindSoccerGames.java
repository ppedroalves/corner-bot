package com.prtt.cornerbot.schedules;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.prtt.cornerbot.domain.LiveMatches;
import com.prtt.cornerbot.domain.Match;
import com.prtt.cornerbot.utils.JsonObjectMapper;
import com.prtt.cornerbot.service.PlayWrightService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class FindSoccerGames {

    @Autowired
    private PlayWrightService playWrightService;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MatchService matchService;

    @Scheduled(cron = "0 */10 * ? * *")
    public void filterGamesInParameters() throws JsonProcessingException {
        log.info("Starting game filtering.");
        String html = playWrightService.getJson();
        LiveMatches response = JsonObjectMapper.mapperLiveGames(html, objectMapper);
        printGoodMatchForCorner(matchService.filterGoodMatchesForCorners(response.getMatches()));

    }



    private void printGoodMatchForCorner(List<Match> matches){
        if(matches.size() == 0){
            System.out.println("Nenhuma partida dentro dos parametros");
        }

        for (Match m : matches) {
            System.out.println("O jogo: " + m.getHomeTeam().getName() + " x " + m.getAwayTeam().getName() +
                    " está nos parametros de escanteio.");
        }
    }
}
