package com.prtt.cornerbot.schedules;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.prtt.cornerbot.domain.LiveGames;
import com.prtt.cornerbot.service.JsonObjectMapper;
import com.prtt.cornerbot.service.PlayWrightService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FindSoccerGames {

    @Autowired
    private PlayWrightService playWrightService;

    @Autowired
    private ObjectMapper objectMapper;

    @Scheduled(cron = "0 * * * * *")
    public void filterGamesInParameters() throws JsonProcessingException {
        System.out.println("Hello World");
        String html = playWrightService.getJson();
        LiveGames games = JsonObjectMapper.mapperLiveGames(html, objectMapper);
        System.out.println("Pronto");

    }
}
