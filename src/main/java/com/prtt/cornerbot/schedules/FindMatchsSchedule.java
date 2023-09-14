package com.prtt.cornerbot.schedules;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.prtt.cornerbot.domain.LiveMatches;
import com.prtt.cornerbot.domain.Match;
import com.prtt.cornerbot.service.MatchService;
import com.prtt.cornerbot.service.TelegramApiService;
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
public class FindMatchsSchedule {

    @Autowired
    private PlayWrightService playWrightService;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MatchService matchService;

    @Autowired
    private TelegramApiService telegramApiService;

    @Scheduled(cron = "0 */5 * ? * *")
    public void filterGamesInParameters() throws JsonProcessingException {
        log.info("Starting game filtering at " + LocalDateTime.now());
        LiveMatches response = mapJsonToLiveMatches(playWrightService.getJson());
        List<Match> matches =  filterMatches(response.getMatches());
        telegramApiService.printGoodMatchForCorner(matches);

    }

    public LiveMatches mapJsonToLiveMatches(String json) throws JsonProcessingException {
        return JsonObjectMapper.mapperLiveGames(json, objectMapper);
    }

    public List<Match> filterMatches(List<Match> matches) {
        return matchService.filterGoodMatchesForCorners(matches);
    }

}
