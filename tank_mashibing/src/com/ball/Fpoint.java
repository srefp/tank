package com.ball;

import java.awt.*;

import static com.ball.BallFrame.*;

public class Fpoint {
    private int x, y;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Fpoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.YELLOW);
        g.fillOval(x, y, FIXED_POINT_WIDTH, FIXED_POINT_HEIGHT);
        g.setColor(c);

        move();
    }

    private void move() {
        x += SPEED;
    }

}
