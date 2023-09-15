package com.prtt.cornerbot.schedules;

import com.prtt.cornerbot.repository.MatchRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CacheSchedule {

    private final MatchRepository matchRepository;

    @Scheduled(cron = "0 0 2 * * ?")
    public void cleanupCache() {
        matchRepository.deleteAll();
    }

}
