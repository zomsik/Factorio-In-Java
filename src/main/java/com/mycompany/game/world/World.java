package com.mycompany.game.world;

import com.mycompany.game.Handler;
import com.mycompany.game.entities.EntityManager;
import com.mycompany.game.entities.creatures.Player;
import com.mycompany.game.entities.statics.Accumulator;
import com.mycompany.game.tiles.Tile;
import com.mycompany.game.utils.Utils;
import java.awt.Graphics;

public class World {
    
    private Handler handler;
    private int width, height;
    private int spawnX=500,spawnY=800;
    private int [][] tiles;
    //Entities
    private EntityManager entityManager;
    
    
    public World(Handler handler,String path){
        this.handler = handler;
        
        entityManager = new EntityManager(handler, new Player(handler, 100, 100));
        entityManager.addEntity(new Accumulator(handler,100,200));
        
        
        loadWorld(path);
        
        entityManager.getPlayer().setX(spawnX);
        entityManager.getPlayer().setX(spawnY);
        
        
        
    }
    
    public void tick(){
        entityManager.tick();
    }
    
    
    public void render(Graphics g){
        int xStart = (int) Math.max(0, handler.getGameCamera().getxOffset() / Tile.TILEWIDTH);
        int xEnd = (int) Math.min(width, (handler.getGameCamera().getxOffset() + handler.getWidth()) / Tile.TILEWIDTH + 1);
        int yStart = (int) Math.max(0, handler.getGameCamera().getyOffset() / Tile.TILEHEIGHT);
        int yEnd = (int) Math.min(height, (handler.getGameCamera().getyOffset() + handler.getHeight()) / Tile.TILEHEIGHT + 1);
        
        
        
    for(int y=yStart; y< yEnd;y++){
        for(int x=xStart;x < xEnd; x++){
            getTile(x, y).render(g, (int) (x * Tile.TILEWIDTH - handler.getGameCamera().getxOffset()), 
                    (int) (y * Tile.TILEHEIGHT - handler.getGameCamera().getyOffset()));   
        }
    }
        
    //ENTITIES
    entityManager.render(g);
        
    }
    
    public Tile getTile(int x, int y){
        if(x < 0 || y < 0 || x >= width || y >= height)
            return Tile.dirtTile;
        
        Tile t = Tile.tiles[tiles[x][y]];
        if(t == null)
            return Tile.dirtTile;
        return t;
    }
    
    
    private void loadWorld(String path)
    {
        String file = Utils.loadFileAsString(path);
        String[] tokens = file.split("\\s+");
        width = Utils.parseInt(tokens[0]);
        height = Utils.parseInt(tokens[1]);
        
        tiles = new int[width][height];
        for(int y=0; y< height;y++){
            for(int x=0;x < width; x++){
            tiles[x][y] = Utils.parseInt(tokens[(x + y * width) + 2]);
            }}
        
        
        
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }
    
    
    
    
    
}

