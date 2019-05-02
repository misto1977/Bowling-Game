package com.misto.bowlinggame;

public class BowlingGameFrames {

    private Frame[] frames;
    private int currentFrameIndex;

    public BowlingGameFrames() {
        this.frames = new Frame[10];
        initFrames();
        currentFrameIndex = 0;
    }

    //Filling frames array with Frame objects
    private void initFrames() {
        for (int i = 0; i < this.frames.length; i++) {
            this.frames[i] = new Frame();
        }
    }

    public void roll( int roll ) {
        currentFrame().setKnockedPins( roll ); // Rolling down number of pins specified by roll in current frame

        if (currentFrame().isComplete()) {
            currentFrameIndex++; // Go to next frame index
        }
    }

    // Calculating total score for all frames
    public int score() {
        int sum = 0;
        for (int i = 0; i < this.frames.length; i++) {
            if (this.frames[i].isStrike()) {
                sum += 10 + this.frames[i + 1].sumOfKnockedPins();
            } else if (this.frames[i].isSpare()) {
                sum += 10 + this.frames[i + 1].knockedPins[0];
            } else {
                sum += this.frames[i].sumOfKnockedPins();
            }
        }
        return sum;
    }

    private Frame previousFrame() {
        return this.frames[currentFrameIndex - 1]; // Returning previous frame, subtracting 1 from currentFrameIndex
    }

    private boolean isFirstFrame() {
        return currentFrameIndex == 0;
    }

    private Frame currentFrame() {
        return this.frames[currentFrameIndex];
    }

    public class Frame {

        private int[] knockedPins;
        private int attempts;

        protected Frame() {
            this.knockedPins = new int[]{0, 0}; // Creating array with room for two integers, setting default score to 0
            this.attempts = 0;
        }

        private void setKnockedPins( int roll ) {
            this.knockedPins[this.attempts] = roll; // Setting score for current index in knockedPins
            this.attempts++; // Increasing attempt index
            if (isStrike()) this.attempts++;
        }

        private int sumOfKnockedPins() {
            return this.knockedPins[0] + this.knockedPins[1];
        }

        private boolean isComplete() {
            return this.attempts == 2; // Return true if attempts is 2
        }

        private boolean isStrike() {
            return this.knockedPins[0] == 10; // Return true if first knockedPins index is 10
        }

        private boolean isSpare() {
            return this.knockedPins[0] + this.knockedPins[1] == 10; // Return true if the sum of both knockedPins indexes is 10
        }
    }
}