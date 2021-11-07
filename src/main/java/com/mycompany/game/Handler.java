package com.mycompany.game;

import com.mycompany.game.gfx.GameCamera;
import com.mycompany.game.input.KeyManager;
import com.mycompany.game.input.MouseManager;
import com.mycompany.game.world.World;

public class Handler {
    
    private Game game;
    private World world;

    public Handler(Game game) {
        this.game = game;
    }
    
    public GameCamera getGameCamera(){
        return game.getGameCamera();
    }
    
    public KeyManager getKeyManager(){
        return game.getKeyManager();
    }
    
    public MouseManager getMouseManager(){
        return game.getMouseManager();
    }
    
    
    
    public int getWidth(){
        return game.getWIDTH();
    }
    
    public int getHeight(){
        return game.getHEIGHT();
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public World getWorld() {
        return world;
    }

    public void setWorld(World world) {
        this.world = world;
    }
    
    
    
    
}
