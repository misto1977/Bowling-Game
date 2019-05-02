package com.misto.bowlinggame;

public class BowlingGame {

    private int roll;
    private int[] rolls = new int[21]; //the most rolls you can have in the game

    public void roll( int knockedPins ) {
        rolls[roll++] = knockedPins; //storing rolls
        if (knockedPins == 10 && !lastFrame()) {
            rolls[roll++] = 0;
        }
    }


    public int score() {
        int score = 0;
        int rollIndex = 0; //separate counter to keep track in rolls array

        for (int frame = 0; frame < 10; frame++) {
            if (isStrike( rolls[rollIndex] )) { //strike
                score += 10 + rolls[rollIndex + 1] + rolls[rollIndex + 2];
                rollIndex++;
            } else if (isSpare( rollIndex )) { //spare
                score += 10 + rolls[rollIndex + 2];
                rollIndex += 2;
            } else {
                score += rolls[rollIndex] + rolls[rollIndex + 1]; //with each roll, add the number of knockedPins to the score
                rollIndex += 2;
            }

        }
        return score;
    }


    private boolean isStrike( int roll ) {
        return roll == 10;
    }

    private boolean isSpare( int rollIndex ) {
        return rolls[rollIndex] + rolls[rollIndex + 1] == 10;
    }

    private boolean lastFrame() {
        return roll < 18;
    }

}
