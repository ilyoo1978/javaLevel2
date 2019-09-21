package lesson1.circles;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainCircles extends JFrame {
    private static final int POS_X = 600;
    private static final int POS_Y = 200;
    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 600;
    private Sprite[] sprites = new Sprite[2];

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainCircles();
            }
        });
    }

    MainCircles(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Circles");
        GameCanvas gameCanvas = new GameCanvas(this);
        add(gameCanvas, BorderLayout.CENTER);
        JButton moreBtn = new JButton("More Balls");
        moreBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addOneBall();
            }
        });
        JButton lessBtn = new JButton("Less Balls");
        lessBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeOneBall();
            }
        });
        JPanel buttons = new JPanel();
        buttons.add(moreBtn);
        buttons.add(lessBtn);
        add(buttons, BorderLayout.SOUTH);
        initApplication();

        setVisible(true);
    }
    private void initApplication(){
        for (int i = 0; i < sprites.length; i++){
            sprites[i] = new Ball();
        }
    }

    private void addOneBall(){
        Sprite[] newArr = new Ball[sprites.length + 1];
        for (int i = 0; i < sprites.length; i++){
            newArr[i] = sprites[i];
        }
        newArr[newArr.length - 1] = new Ball();
        sprites = newArr;
    }

    private void removeOneBall(){
        if(sprites.length == 0){
            return;
        }
        Sprite[] newArr = new Ball[sprites.length - 1];
        for (int i = 1; i < sprites.length; i++){
            newArr[i - 1] = sprites[i];
        }
        sprites = newArr;
    }

    void onDrawFrame(GameCanvas canvas, Graphics g,float deltaTime){
        update(canvas, deltaTime);
        render(canvas, g);
    }
    private void update(GameCanvas canvas, float deltaTime){
        for (int i = 0; i < sprites.length; i++){
            sprites[i].update(canvas, deltaTime);
        }
    }
    private void render(GameCanvas canvas, Graphics g){
        for (int i = 0; i < sprites.length; i++){
            sprites[i].render(canvas, g);
        }
    }
}
