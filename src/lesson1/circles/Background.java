package lesson1.circles;

import java.awt.*;

public class Background {
    private int r = 1,
                g = 1,
                b = 1;
    private Color color = new Color(
            (int)(Math.random() * 255),
            (int)(Math.random() * 255),
            (int)(Math.random() * 255)
    );
    GameCanvas canvas;
    Background(GameCanvas canvas){
        this.canvas = canvas;
    }
    protected void changeColor(){
        if(color.getRed() + r >= 255 || color.getRed() + r <= 0){
            r = -r;
        }
        if(color.getGreen() + g >= 255 || color.getGreen() + g <= 0){
            g = -g;
        }
        if(color.getBlue() + b >= 255 || color.getBlue() + b <= 0){
            b = -b;
        }
        color = new Color(color.getRed() + r, color.getGreen() + g, color.getBlue() + b);
        canvas.setBackground(color);


    }
}
