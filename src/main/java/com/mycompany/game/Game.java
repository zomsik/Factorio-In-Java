package com.mycompany.game;

import com.mycompany.game.display.Display;
import com.mycompany.game.gfx.Assets;
import com.mycompany.game.gfx.GameCamera;
import com.mycompany.game.input.KeyManager;
import com.mycompany.game.input.MouseManager;
import com.mycompany.game.states.GameState;
import com.mycompany.game.states.MenuState;
import com.mycompany.game.states.State;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Game implements Runnable {

    private Display display;
    private int WIDTH;
    private int HEIGHT;
    public String TITLE;
   private boolean running = false;
   private Thread thread;

   private BufferStrategy bs;
   private Graphics g;
   private int fpscounter=0;
   
    //States
    public State gameState;
    private State menuState;
    
    //Input
    private KeyManager keyManager;
    private MouseManager mouseManager;
    
    //Camera
    private GameCamera gameCamera;
   
    //Handler
    private Handler handler;
   
    public Game(int w, int h, String t)
    {
        this.WIDTH = w;
        this.HEIGHT = h;
        this.TITLE = t;
        keyManager = new KeyManager();
        mouseManager = new MouseManager();
   }
   
    private void init(){
        display = new Display(WIDTH,HEIGHT,TITLE);
        display.getFrame().addKeyListener(keyManager);
        display.getFrame().addMouseListener(mouseManager);
        display.getFrame().addMouseMotionListener(mouseManager);
        display.getCanvas().addMouseListener(mouseManager);
        display.getCanvas().addMouseMotionListener(mouseManager);        
        
        Assets.init();
        
        handler = new Handler(this);
        gameCamera = new GameCamera(handler, 0, 0);
        
        
        
        gameState = new GameState(handler);
        menuState = new MenuState(handler);
        State.setState(menuState);
    }
    
    
    
    private void tick(){
        keyManager.tick();
        
        if(State.getState() != null)
        State.getState().tick();
    }
    
    
    private void render(){
        bs = display.getCanvas().getBufferStrategy();
        if(bs == null){
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        
        g = bs.getDrawGraphics();
        //Clear Screen
        g.clearRect(0, 0, WIDTH, HEIGHT);
        //Drawing
        if(State.getState() != null)
        State.getState().render(g);

        
        //END

        bs.show();
        g.dispose();
    }
    
public void run(){
       
       init();
       
       int fps=60;
       double timePerTick = 1000000000 /fps;
       double delta = 0;
       long now;
       long lastTime = System.nanoTime();
       long timer = 0;
       int ticks=0;
       
       
       while(running){
           now = System.nanoTime();
           delta += (now-lastTime) /timePerTick;
           timer += now - lastTime;
           lastTime = now;
           
           
           if(delta>= 1){
                tick();
                render();  
                delta--;
                ticks++;
           }
           if(timer>=1000000000){
               fpscounter = ticks;
               ticks=0;
               timer=0;
           }

       }
       
       stop();
   } 

    public int getFpscounter() {
        return fpscounter;
    }
   
   
   
   public GameCamera getGameCamera(){
       return gameCamera;
   }
   
   public KeyManager getKeyManager(){
       return keyManager;
   }
   
   public MouseManager getMouseManager(){
       return mouseManager;
   }  
   

    public int getWIDTH() {
        return WIDTH;
    }

    public int getHEIGHT() {
        return HEIGHT;
    }
   
   
   
   
   
   public synchronized void start(){
       if (running) return;
       running = true;
       thread = new Thread(this);
       thread.start();
   }
   
   public synchronized void stop(){
       if(!running) return;
       running = false;
        try {
            thread.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
   }   

    public Object getGetCamera() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
