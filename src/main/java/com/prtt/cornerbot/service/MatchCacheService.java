package com.prtt.cornerbot.service;


import com.prtt.cornerbot.cache.MatchCache;
import com.prtt.cornerbot.repository.MatchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MatchCacheService {

    private final MatchRepository matchRepository;
    public void addToCache(String cacheId) {
        matchRepository.save(new MatchCache(cacheId));
    }

    public boolean isMatchInCache(String cacheId) {
        return matchRepository.findById(cacheId).isPresent();
    }
}
