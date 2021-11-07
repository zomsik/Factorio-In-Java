package com.mycompany.game.gfx;

import java.awt.image.BufferedImage;

public class Sheet {
    
    private BufferedImage sheet;
    
    public Sheet(BufferedImage charactersheet){
        this.sheet = charactersheet;
    }
    
    public BufferedImage crop(int x, int y, int width, int height){
        return sheet.getSubimage(x, y, width, height);
    }
    
    
}
