package com.prtt.cornerbot.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.prtt.cornerbot.domain.LiveGames;

public class JsonObjectMapper {

    public static LiveGames mapperLiveGames(String json, ObjectMapper objectMapper) throws JsonProcessingException {
        return objectMapper.readValue(json, LiveGames.class);
    }
}
