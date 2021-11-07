package com.mycompany.game.states;

import com.mycompany.game.Handler;
import com.mycompany.game.entities.creatures.Player;
import com.mycompany.game.entities.statics.Accumulator;
import com.mycompany.game.gfx.Assets;
import com.mycompany.game.world.World;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class GameState extends State {

    

    private World world;

  
    
    public GameState(Handler handler){
        super(handler);
        world = new World(handler, "worlds/world1.txt");
        handler.setWorld(world);
   
    }
    
    @Override
    public void tick() {
        world.tick();


    }

    @Override
    public void render(Graphics g) {
        
        world.render(g);  
        //g.drawImage(Assets.iron_chest,400,100,null);
        //g.drawImage(Assets.iron_chest,466,100,null);
        //g.drawImage(Assets.accumulator,200,200,null);
        //g.drawImage(Assets.accumulator,200,320,null);



        Font currentFont = g.getFont();
        Font newFont = currentFont.deriveFont(currentFont.getSize() * 1.4F);
        g.setFont(newFont);
        g.setColor(Color.red);
        g.drawString("FPS: "+ handler.getGame().getFpscounter() , 0, 15);
        
    } 
   
}
