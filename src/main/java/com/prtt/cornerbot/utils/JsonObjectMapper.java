package com.prtt.cornerbot.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.prtt.cornerbot.domain.LiveMatches;

public class JsonObjectMapper {

    public static LiveMatches mapperLiveGames(String json, ObjectMapper objectMapper) throws JsonProcessingException {
        return objectMapper.readValue(json, LiveMatches.class);
    }
}
