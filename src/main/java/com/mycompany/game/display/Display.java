package com.mycompany.game.display;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;

public class Display extends JFrame {
    
    private JFrame gamewindow;
    private int WIDTH;
    private int HEIGHT;
    private String TITLE;
    private Canvas canvas;
    
    public Display(int w, int h, String t){
        this.WIDTH = w;
        this.HEIGHT = h;
        this.TITLE = t;
        createDisplay();
        
    }
        
    private void createDisplay()
    {
        gamewindow = new JFrame();
        gamewindow.setSize(WIDTH, HEIGHT);
        gamewindow.setTitle(TITLE);
        
        //gamewindow.pack();
        
        gamewindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gamewindow.getContentPane().setBackground(Color.lightGray);
        gamewindow.setLocationRelativeTo(null);
        gamewindow.setVisible(true);
        
        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        canvas.setMaximumSize(new Dimension(WIDTH, HEIGHT));
        canvas.setMinimumSize(new Dimension(WIDTH, HEIGHT));
        canvas.setFocusable(false);
        gamewindow.add(canvas);
        gamewindow.pack();
    }

    public Canvas getCanvas() {
        return canvas;
    }
    
    public JFrame getFrame(){
        return gamewindow;
    }
    
    
}
