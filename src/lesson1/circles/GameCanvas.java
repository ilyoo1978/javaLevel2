package lesson1.circles;

import javax.swing.*;
import java.awt.*;

public class GameCanvas extends JPanel {
    private MainCircles gameWindow;
    private long lastFrameTime;
    private Background background;

    GameCanvas(MainCircles gameWindow){
        this.gameWindow = gameWindow;
        background = new Background(this);
        lastFrameTime = System.nanoTime();
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        long currentTime = System.nanoTime();
        float delta = (currentTime - lastFrameTime) * 0.000000001f;
        lastFrameTime = currentTime;
        try {
            Thread.sleep(17);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        gameWindow.onDrawFrame(this, g, delta);
        background.changeColor();
        repaint();
    }
    public int getLeft(){return 0;}
    public int getTop(){return 0;}
    public int getRight(){return getWidth() - 1;}
    public int getBottom(){return getHeight() - 1;}

}
