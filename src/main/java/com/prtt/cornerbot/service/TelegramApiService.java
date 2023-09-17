package com.prtt.cornerbot.service;


import com.prtt.cornerbot.client.TelegramApiBot;
import com.prtt.cornerbot.domain.match.Match;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TelegramApiService {

    private final TelegramApiBot telegramApiBot;

    public void printGoodMatchForCorner(List<Match> matches){
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
                + "\n\n" + buildBet365Link(m.getHomeTeam().getName())
                +"\n\n\n";

    }

    private String buildBet365Link(String name) {
        String[] formattName = name.split(" ");
        return "https://www.bet365.com/?nr=1#/AX/K%5E" + formattName[0];
    }

    private String buildTipText(Long totalCorners){
        return "+" + (totalCorners + 1L) + " CANTOS ASIATICOS || +"
                + totalCorners + ".5 CANTOS ASIATICOS";
    }


}
