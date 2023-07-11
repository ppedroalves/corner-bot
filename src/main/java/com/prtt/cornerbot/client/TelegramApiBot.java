package com.prtt.cornerbot.client;


import com.prtt.cornerbot.client.config.ApiTelegramConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "telegramApiBot", url="https://api.telegram.org/bot${bot.token.id}", configuration = ApiTelegramConfiguration.class)
public interface TelegramApiBot {


    @PostMapping(path = "/sendMessage")
    void sengMessage(@RequestParam("text") String text);

}
