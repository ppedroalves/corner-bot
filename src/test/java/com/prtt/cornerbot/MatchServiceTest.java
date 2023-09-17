package com.prtt.cornerbot;

import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class MatchServiceTest {


//    @MockBean
//    private MatchService matchService;
//
//    @Test
//    public void testIsDifferenceOne_True() {
//        Match match = createMatchWithScores(3L, 4L);
//        assertTrue(matchService.isMatchOnFilter(match));
//    }
//
//    @Test
//    public void testIsDifferenceOne_False() {
//        Match match = createMatchWithScores(2L, 5L);
//        assertFalse(matchService.isMatchOnFilter(match));
//    }
//
//    @Test
//    public void testIsAvgAppmHigh_True() {
//        Match match = createMatchWithAppm(2.0, 1.5);
//        assertTrue(matchService.isMatchOnFilter(match));
//    }
//
//    @Test
//    public void testIsAvgAppmHigh_False() {
//        Match match = createMatchWithAppm(1.0, 0.5);
//        assertFalse(matchService.isMatchOnFilter(match));
//    }
//
//    private Match createMatchWithScores(Long homeScore, Long awayScore) {
//        Scores scores = new Scores(homeScore, awayScore);
//        PressureStats pressureStats = new PressureStats(new DangerousAttacksPerMinute(1.0, 1.0), new DangerousAttacksPerMinute(2.0, 2.0));
//        Match match = new Match();
//        match.setScores(scores);
//        match.setPressureStats(pressureStats);
//        return match;
//    }
//
//    private Match createMatchWithAppm(Double homeAppm, Double awayAppm) {
//        Scores scores = new Scores(2L, 2L);
//        PressureStats pressureStats = new PressureStats(new DangerousAttacksPerMinute(homeAppm, awayAppm), new DangerousAttacksPerMinute(2.0, 2.0));
//        Match match = new Match();
//        match.setScores(scores);
//        match.setPressureStats(pressureStats);
//        return match;
//    }
}
