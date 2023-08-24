package com.prtt.cornerbot.schedules;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.prtt.cornerbot.client.TelegramApiBot;
import com.prtt.cornerbot.domain.LiveMatches;
import com.prtt.cornerbot.domain.Match;
import com.prtt.cornerbot.service.MatchService;
import com.prtt.cornerbot.utils.JsonObjectMapper;
import com.prtt.cornerbot.service.PlayWrightService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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

    @Autowired
    private TelegramApiBot telegramApiBot;

    @Scheduled(cron = "0 */10 * ? * *")
    public void filterGamesInParameters() throws JsonProcessingException {
        log.info("Starting game filtering at " + LocalDateTime.now());
        LiveMatches response = JsonObjectMapper.mapperLiveGames(playWrightService.getJson(), objectMapper);
        printGoodMatchForCorner(matchService.filterGoodMatchesForCorners(response.getMatches()));

    }



    private void printGoodMatchForCorner(List<Match> matches){
        if(matches.isEmpty()){
            log.info("Nenhuma partida dentro dos parametros");
            return;
        }

        StringBuilder builder = new StringBuilder();
        builder.append("ALERTA ❗" + "\n\n");
        for (Match m : matches) {
            log.info("O jogo: " + m.getHomeTeam().getName() + " x " + m.getAwayTeam().getName() +
                    " está nos parametros de escanteio.");

            builder.append(buildMessageMatch(m));
        }

        telegramApiBot.sendMessage(builder.toString());
    }


    private String buildMessageMatch(Match m){
        return  m.getLeague().getName()
                + "\n\n" + m.getHomeTeam().getName() + " x " + m.getAwayTeam().getName()
                + "\n\n" + m.getCurrentTime().getMinute() + " minutos de jogo"
                + "\n\n" + "Escanteios: " + m.getStats().getCorners().getHome() + " - " + m.getStats().getCorners().getAway()
                + "\n\n" + buildTipText(m.getStats().getCorners().getHome() + m.getStats().getCorners().getAway())
                +"\n\n\n";

    }

    private String buildTipText(Long totalCorners){
        return "+" + (totalCorners + 1L) + " CANTOS ASIATICOS || +"
                + totalCorners + ".5 CANTOS ASIATICOS";
    }
}
