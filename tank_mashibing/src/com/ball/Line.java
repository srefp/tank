package com.ball;

import java.awt.*;

public class Line {
    private double x1, y1, x2, y2;
    static final double L = 141.4213562373095;
    public Line(double x1, double y1, double x2, double y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public void change(Ball ball, Fpoint fpoint) {
        this.x1 = fpoint.getX();
        this.y1 = fpoint.getY();
        this.x2 = ball.getX();
        this.y2 = ball.getY();
        double k;
        if (x1 == x2) {
            k = Double.MAX_VALUE;
        } else {
            k = (y1 - y2) / (x1 - x2);
        }
        if (k > 0) {
            ball.setTheta(90 - Math.toDegrees(Math.atan(k)));
        } else {
            ball.setTheta(-90 - Math.toDegrees(Math.atan(k)));
        }
    }

    public double getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public double getY1() {
        return y1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public double getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public double getY2() {
        return y2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }

    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.YELLOW);
        g.drawLine((int) x1 + BallFrame.FIXED_POINT_WIDTH / 2, (int) y1 + BallFrame.FIXED_POINT_HEIGHT / 2, (int) x2 + BallFrame.BALL_WIDTH / 2, (int) y2 + BallFrame.BALL_HEIGHT / 2);
        g.setColor(c);
    }
}
