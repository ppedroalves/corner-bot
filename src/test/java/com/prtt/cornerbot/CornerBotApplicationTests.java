package com.prtt.cornerbot;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

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
