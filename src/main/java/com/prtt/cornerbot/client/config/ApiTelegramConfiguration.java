package com.prtt.cornerbot.client.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.beans.factory.annotation.Value;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ApiTelegramConfiguration implements RequestInterceptor {

    @Value("${chat.id}")
    private String chatId;

    @Override
    public void apply(RequestTemplate requestTemplate) {
        Map<String, Collection<String>> params = new HashMap<>();
        params.put("chat_id", Collections.singleton(chatId));
        params.put("parse_mode", Collections.singleton("html"));
        params.put("disable_web_page_preview", Collections.singleton("True"));
        requestTemplate.queries(params);
    }
}
