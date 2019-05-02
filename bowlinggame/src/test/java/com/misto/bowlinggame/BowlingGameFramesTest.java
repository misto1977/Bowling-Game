package com.misto.bowlinggame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BowlingGameFramesTest {

    private BowlingGameFrames bowlingGameFrames;


    @BeforeEach
    void setUp() {
        bowlingGameFrames = new BowlingGameFrames();
    }

    @Test
    public void canRollTwoStrikesInRow() {
        bowlingGameFrames.roll( 10 );
        bowlingGameFrames.roll( 10 );
        bowlingGameFrames.roll( 2 );
        bowlingGameFrames.roll( 1 );
        assertEquals( bowlingGameFrames.score(), 36 );
    }

    @Test
    public void canRollSpare() {
        bowlingGameFrames.roll( 5 );
        bowlingGameFrames.roll( 5 );
        assertEquals( bowlingGameFrames.score(), 10 );
    }



    @Test
    void score() {

    }


    private void roll( int times, int knockedPins ) {
        for (int i = 0; i < times; i++) {
            bowlingGameFrames.roll( knockedPins );
        }
    }
}

