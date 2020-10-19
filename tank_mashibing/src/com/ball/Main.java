package com.ball;

public class Main {
    static final int DELTA_T = 50;
    public static void main(String[] args) throws InterruptedException {
        BallFrame ballFrame = new BallFrame();

        while (true) {
            Thread.sleep(DELTA_T);
            ballFrame.repaint();
        }
    }
}
