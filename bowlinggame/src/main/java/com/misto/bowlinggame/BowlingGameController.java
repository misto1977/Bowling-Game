package com.misto.bowlinggame;

import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class BowlingGameController {

    private BowlingGame bowlingGame;

    @GetMapping("/start")
    public String start() {
        bowlingGame = new BowlingGame();
        return "Bowling game running!";
    }

    @GetMapping("/roll")
    public String roll(@RequestParam("roll") String roll) {
        bowlingGame.roll( Integer.parseInt( roll ) );
        return  Integer.toString(bowlingGame.score());
    }

}
