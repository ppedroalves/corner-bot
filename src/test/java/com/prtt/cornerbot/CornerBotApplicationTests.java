package com.prtt.cornerbot;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.prtt.cornerbot.domain.LiveMatches;
import com.prtt.cornerbot.domain.Match;
import com.prtt.cornerbot.domain.Scores;
import com.prtt.cornerbot.service.MatchService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest(classes = CornerBotApplicationTests.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@ContextConfiguration(classes = CornerBotApplicationTests.class)
class CornerBotApplicationTests {
//	@Test
//	public void testMapJsonToLiveMatches() throws JsonProcessingException {
//		// Simular o JSON
//		String json = "{...}";
//
//		// Criar mock do PlayWrightService e ObjectMapper, se necessário
//
//		// Criar o objeto MatchService com os mocks
//		MatchService matchService = new MatchService(playWrightService, objectMapper);
//
//		LiveMatches liveMatches = matchService.mapJsonToLiveMatches(json);
//
//		// Realizar asserções nos objetos LiveMatches
//		// ...
//	}
//
//	@Test
//	public void testFilterMatches() {
//		// Criar lista de partidas para teste
//
//		// Criar o objeto MatchService
//		MatchService matchService = new MatchService(playWrightService, objectMapper);
//
//		List<Match> filteredMatches = matchService.filterMatches(matches);
//
//		// Realizar asserções nos objetos filteredMatches
//		// ...
//	}
}
