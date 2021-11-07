package com.mycompany.game.tiles;

import com.mycompany.game.gfx.Assets;
import java.awt.image.BufferedImage;

public class WaterTile extends Tile {

    public WaterTile(int id) {
        super(Assets.water , id);
    }

    @Override
    public boolean isSolid() {
        return true;
    }
    
    
    
    
}
