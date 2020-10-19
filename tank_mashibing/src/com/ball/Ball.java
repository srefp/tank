package com.ball;

import java.awt.*;

import static com.ball.BallFrame.SPEED;
import static com.ball.Line.L;

public class Ball {
    private double x, y;

    private double theta;
    boolean dir = true;

    static final double g = 9.8;
    static final int BALL_WIDTH = 10, BALL_HEIGHT = 10;

    public double getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public double getTheta() {
        return theta;
    }

    public void setTheta(double theta) {
        this.theta = theta;
    }

    public Ball(double x, double y, double theta) {
        this.x = x;
        this.y = y;
        this.theta = theta;
    }

    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.RED);
        g.fillOval((int) x, (int) y, BALL_WIDTH, BALL_HEIGHT);
        g.setColor(c);
        move();
    }

    private void move() {
        calTheta();

        x = 300 + L * Math.sin(Math.toRadians(theta));
        y = 100 + L * Math.cos(Math.toRadians(theta));

        x += SPEED;
    }

    public void calTheta() {
        double omiga = Math.sqrt(2 * g * (Math.abs(this.y - 170))) / L;
        if ((int) this.y == 170) {
            dir = !dir;
        }
        if (dir) {
            this.theta += omiga * 0.05 * Main.DELTA_T;
        } else {
            this.theta -= omiga * 0.05 * Main.DELTA_T;
        }
    }

//    public void move1() {
//        double v0 = Math.sqrt(2 * g * (y - 200));
//
//        double k = (100 - y) / (300 - x);
//        double theta = Math.atan(k);
//        double a = Math.sin(theta);
//
//        double ax = a * Math.cos(theta);
//        double ay = a * Math.sin(theta);
//
//        double xx = v0 * 0.001 * Main.DELTA_T + 0.5 * ax * 0.000001 * Main.DELTA_T * Main.DELTA_T;
//        double xy = v0 * 0.001 * Main.DELTA_T + 0.5 * ay * 0.000001 * Main.DELTA_T * Main.DELTA_T;
//
//        this.x += xx;
//        this.y += xy;
//    }

}
