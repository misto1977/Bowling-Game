package com.misto.bowlinggame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BowlingGameTest {

    BowlingGame bowlingGame;

    @BeforeEach
    public void initialize() {
        bowlingGame = new BowlingGame();
    }

    @Test
    public void canRollGutterGame() {
        roll( 20, 0 );
        assertEquals( bowlingGame.score(), 0 );
    }

    @Test
    public void canRollGameOfOnes() {
        roll( 20, 1 );
        assertEquals( bowlingGame.score(), 20 );
    }

    @Test
    public void canRollSpare() {
        bowlingGame.roll( 5 );
        bowlingGame.roll( 5 );
        bowlingGame.roll( 3 );
        roll( 17, 0 );
        assertEquals( bowlingGame.score(), 16 );
    }

    @Test
    public void canRollStrike() {
        bowlingGame.roll( 10 );
        bowlingGame.roll( 3 );
        bowlingGame.roll( 3 );
        roll( 17, 0 );
        assertEquals( bowlingGame.score(), 22 );
    }

    @Test
    public void canRollPerfectSerie() {
        roll( 12, 10 );
        assertEquals( bowlingGame.score(), 300 );
    }

    @Test
    public void canRollOutput38() {
        bowlingGame.roll( 10 );
        bowlingGame.roll( 9 );
        bowlingGame.roll( 1 );
        bowlingGame.roll( 4 );
        roll( 16, 0 );
        assertEquals( bowlingGame.score(), 38 );
    }

    @Test
    public void canRollTwoStrikesInRow() {
        bowlingGame.roll( 10 );
        bowlingGame.roll( 10 );
        bowlingGame.roll( 2 );
        bowlingGame.roll( 0 );
        roll( 16, 0 );
        assertEquals( bowlingGame.score(), 36 );
    }

    @Test
    public void canRollAlmostPerfect() {
        for (int i = 0; i < 11; i++)
            bowlingGame.roll( 10 );
        bowlingGame.roll( 9 );
        assertEquals( 299, bowlingGame.score() );

    }

    @Test
    public void canRollSpareInLastFrame() {
        for (int i = 0; i < 9; i++)
            bowlingGame.roll( 10 );
        bowlingGame.roll( 9 );
        bowlingGame.roll( 1 );
        bowlingGame.roll( 1 );
        assertEquals( 270, bowlingGame.score() );
    }


    private void roll( int times, int knockedPins ) {
        for (int i = 0; i < times; i++) {
            bowlingGame.roll( knockedPins );
        }
    }
}