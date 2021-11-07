package com.mycompany.game.gfx;

import java.awt.image.BufferedImage;

public class Assets {
    
    private static int cwidth=92,cheight=116;
    private static int crunningwidth=88,crunningheight=132;
    private static int cminingwidth= 196, cminingheight = 194;
    public static BufferedImage iron_chest,accumulator;
    public static BufferedImage grass,dirt,water;
    
    public static BufferedImage[] player_idle_up,player_idle_upright,player_idle_down,player_idle_downright,player_idle_left,player_idle_downleft,player_idle_upleft,player_idle_right;
    public static BufferedImage[] player_running_down,player_running_downright,player_running_downleft,player_running_up,
            player_running_upright,player_running_upleft,player_running_right,player_running_left;
    
    public static BufferedImage[] btn_start;
    
    public static BufferedImage[] player_mining_up,player_mining_upright,player_mining_down,player_mining_downright,player_mining_left,player_mining_downleft,player_mining_upleft,player_mining_right;
    
    
    
    public static void init(){
        Sheet character_idle = new Sheet(ImageLoader.loadImage("/textures/hr-level1_idle.png"));
        Sheet character_running = new Sheet(ImageLoader.loadImage("/textures/hr-level1_running.png"));
        Sheet character_mining = new Sheet(ImageLoader.loadImage("/textures/hr-level1_mining_tool-1.png"));
        Sheet grass1 = new Sheet(ImageLoader.loadImage("/terrain/hr-grass-1.png"));
        Sheet dirt1 = new Sheet(ImageLoader.loadImage("/terrain/dirt-1.png"));
        
        btn_start= new BufferedImage[2];
        
        
        player_running_down= new BufferedImage[21];
        player_running_downright= new BufferedImage[21];
        player_running_downleft= new BufferedImage[21];
        player_running_up= new BufferedImage[21];
        player_running_upright= new BufferedImage[21];
        player_running_upleft= new BufferedImage[21];      
        player_running_right= new BufferedImage[21];
        player_running_left= new BufferedImage[21];
        
        player_idle_down= new BufferedImage[21];
        player_idle_downright= new BufferedImage[21];
        player_idle_downleft= new BufferedImage[21];
        player_idle_up= new BufferedImage[21];
        player_idle_upright= new BufferedImage[21];
        player_idle_upleft= new BufferedImage[21];      
        player_idle_right= new BufferedImage[21];
        player_idle_left= new BufferedImage[21];  
        
        int k =26;
        player_mining_down= new BufferedImage[k];
        player_mining_downright= new BufferedImage[k];
        player_mining_downleft= new BufferedImage[k];
        player_mining_up= new BufferedImage[k];
        player_mining_upright= new BufferedImage[k];
        player_mining_upleft= new BufferedImage[k];      
        player_mining_right= new BufferedImage[k];
        player_mining_left= new BufferedImage[k];       
        
        
        
            for (int i=0;i<13;i++)
        {
            player_mining_down[i] = character_mining.crop(i*cminingwidth, 4*cminingheight, cminingwidth, cminingheight);
            player_mining_downright[i] = character_mining.crop(i*cminingwidth, 3*cminingheight, cminingwidth, cminingheight);
            player_mining_downleft[i] = character_mining.crop(i*cminingwidth, 5*cminingheight, cminingwidth, cminingheight);
            player_mining_up[i] = character_mining.crop(i*cminingwidth, 0*cminingheight, cminingwidth, cminingheight);
            player_mining_upright[i] = character_mining.crop(i*cminingwidth, 1*cminingheight, cminingwidth, cminingheight);
            player_mining_upleft[i] = character_mining.crop(i*cminingwidth, 7*cminingheight, cminingwidth, cminingheight);
            player_mining_right[i] = character_mining.crop(i*cminingwidth, 2*cminingheight, cminingwidth, cminingheight);
            player_mining_left[i] = character_mining.crop(i*cminingwidth, 6*cminingheight, cminingwidth, cminingheight);
            
            player_mining_down[k-i-1] = character_mining.crop(i*cminingwidth, 4*cminingheight, cminingwidth, cminingheight);
            player_mining_downright[k-i-1] = character_mining.crop(i*cminingwidth, 3*cminingheight, cminingwidth, cminingheight);
            player_mining_downleft[k-i-1] = character_mining.crop(i*cminingwidth, 5*cminingheight, cminingwidth, cminingheight);
            player_mining_up[k-i-1] = character_mining.crop(i*cminingwidth, 0*cminingheight, cminingwidth, cminingheight);
            player_mining_upright[k-i-1] = character_mining.crop(i*cminingwidth, 1*cminingheight, cminingwidth, cminingheight);
            player_mining_upleft[k-i-1] = character_mining.crop(i*cminingwidth, 7*cminingheight, cminingwidth, cminingheight);
            player_mining_right[k-i-1] = character_mining.crop(i*cminingwidth, 2*cminingheight, cminingwidth, cminingheight);
            player_mining_left[k-i-1] = character_mining.crop(i*cminingwidth, 6*cminingheight, cminingwidth, cminingheight);
            
            
        }

            
            
        for (int i=0;i<21;i++)
        {
            
            player_running_up[i] = character_running.crop(i*crunningwidth, 0, crunningwidth, crunningheight);
            player_running_upright[i] = character_running.crop(i*crunningwidth, 1*crunningheight, crunningwidth, crunningheight);
            player_running_upleft[i] = character_running.crop(i*crunningwidth, 7*crunningheight, crunningwidth, crunningheight);           
            player_running_down[i] = character_running.crop(i*crunningwidth, 4*crunningheight, crunningwidth, crunningheight);
            player_running_downright[i] = character_running.crop(i*crunningwidth, 3*crunningheight, crunningwidth, crunningheight);
            player_running_downleft[i] = character_running.crop(i*crunningwidth, 5*crunningheight, crunningwidth, crunningheight);
            player_running_right[i] = character_running.crop(i*crunningwidth, 2*crunningheight, crunningwidth, crunningheight);
            player_running_left[i] = character_running.crop(i*crunningwidth, 6*crunningheight, crunningwidth, crunningheight);

            player_idle_down[i] = character_idle.crop(i*cwidth, 4*cheight, cwidth, cheight);
            player_idle_downright[i] = character_idle.crop(i*cwidth, 3*cheight, cwidth, cheight);
            player_idle_downleft[i] = character_idle.crop(i*cwidth, 5*cheight, cwidth, cheight);
            player_idle_up[i] = character_idle.crop(i*cwidth, 0*cheight, cwidth, cheight);
            player_idle_upright[i] = character_idle.crop(i*cwidth, 1*cheight, cwidth, cheight);
            player_idle_upleft[i] = character_idle.crop(i*cwidth, 7*cheight, cwidth, cheight);
            player_idle_right[i] = character_idle.crop(i*cwidth, 2*cheight, cwidth, cheight);
            player_idle_left[i] = character_idle.crop(i*cwidth, 6*cheight, cwidth, cheight);
            
        }
        
       
     
        
        btn_start[0] = ImageLoader.loadImage("/menu/new-game.png");
        btn_start[1] = ImageLoader.loadImage("/menu/new-game1.png");        
        iron_chest = ImageLoader.loadImage("/textures/hr-iron-chest.png");
        accumulator = ImageLoader.loadImage("/textures/accumulator.png");
        grass = grass1.crop(0, 128, 128, 256);
        water = ImageLoader.loadImage("/terrain/hr-water-o.png");
        dirt = dirt1.crop(0, 64, 64, 64);
                
    }
}
