package com.ball;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DecimalFormat;

public class BallFrame extends Frame {

    static final int BALL_POS_X = 200, BALL_POS_Y = 200;
    static final int WINDOW_WIDTH = 1000, WINDOW_HEIGHT = 600;
    static final int BALL_WIDTH = 10, BALL_HEIGHT = 10;
    static final int FIXED_POINT_WIDTH = 5, FIXED_POINT_HEIGHT = 5;
    static final int FIXED_POINT_X = 300, FIXED_POINT_Y = 100;
    static final int SPEED = 1;

    static Ball ball = null;
    static Line line = null;
    static Fpoint fpoint = null;

    static {
        init();
    }

    public static void init() {
        ball = new Ball(BALL_POS_X, BALL_POS_Y, -45);
        line = new Line(300, 100, 200, 200);
        fpoint = new Fpoint(FIXED_POINT_X, FIXED_POINT_Y);
    }


    public BallFrame() {
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setResizable(false);
        setTitle("单摆仿真");
        setVisible(true);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    Image offScreeImage = null;

    @Override
    public void update(Graphics g) {
        if (offScreeImage == null) {
            offScreeImage = this.createImage(WINDOW_WIDTH, WINDOW_HEIGHT);
        }
        Graphics gOffScreen = offScreeImage.getGraphics();
        Color c = gOffScreen.getColor();
        gOffScreen.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
        gOffScreen.setColor(c);
        paint(gOffScreen);
        g.drawImage(offScreeImage, 0, 0, null);
    }

    @Override
    public void paint(Graphics g) {
        Color c = g.getColor();

        g.setColor(Color.WHITE);
        DecimalFormat df = new DecimalFormat("0.00");
        g.drawString("绳长：" + df.format(Line.L) + "cm", 10, 60);
        g.drawString("小球角度：" + df.format(ball.getTheta()) + "°", 10, 80);
        g.drawString("小球坐标：(" + df.format(ball.getX()) + ", " + df.format(ball.getY()) + ")", 10, 100);
        g.drawString("周期：" + df.format(calT()) + "s", 10, 120);

        g.setColor(Color.WHITE);
        line.change(ball, fpoint);
        ball.paint(g);
        line.paint(g);
        fpoint.paint(g);

        g.setColor(c);
    }

    public double calT() {
        double T = 2 * Math.PI * Math.sqrt(0.01 * Line.L / Ball.g);
        return T;
    }
}
