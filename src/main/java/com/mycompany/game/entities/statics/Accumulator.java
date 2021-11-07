package com.mycompany.game.entities.statics;

import com.mycompany.game.Handler;
import com.mycompany.game.gfx.Assets;
import java.awt.Graphics;


public class Accumulator extends StaticEntity {

    public Accumulator(Handler handler, float x, float y) {
        super(handler, x, y, 130, 189);
        
        bounds.x = 10;
        bounds.y = 50;
        bounds.width=100;
        bounds.height = 150;
        
        
    }

    
    
    
    
    
    @Override
    public void tick() {
        
    }
    
    @Override
    public void die(){
        
    }
    
    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.accumulator, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
    }
    
}
