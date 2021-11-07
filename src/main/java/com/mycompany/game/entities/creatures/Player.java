package com.mycompany.game.entities.creatures;

import java.awt.Graphics;
import com.mycompany.game.Game;
import com.mycompany.game.Handler;
import com.mycompany.game.entities.Entity;
import com.mycompany.game.gfx.Animation;
import com.mycompany.game.gfx.Assets;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;


public class Player extends Creature {
    
    //Animations
    private Animation animDown,animUp,animRight,animLeft,animDownright,animUpright,animDownleft,animUpleft;
    private Animation animIdleDown,animIdleUp,animIdleRight,animIdleLeft,animIdleDownright,animIdleUpright,animIdleDownleft,animIdleUpleft;    
    private Animation animMiningDown,animMiningUp,animMiningRight,animMiningLeft,animMiningDownright,animMiningUpright,animMiningDownleft,animMiningUpleft;     
    private int damage = 10;
    private long lastAttackTimer, attackCooldown=600, attackTimer= attackCooldown;
    
    private int idlelookposition=4;
    private int speed = 5;
    private int animationspeed = 15;
    private int animationidlespeed = 150;
    private int animationminingspeed = 10;
    private static int defaultwidth=92,defaultheight=116;

    public Player(Handler handler, float x, float y) {
        super(handler, x, y, defaultwidth, defaultheight);
        
        bounds.x = 30;
        bounds.y = 70;
        bounds.width=30;
        bounds.height = 42;
        
        //
        animDown = new Animation(animationspeed, Assets.player_running_down);
        animUp = new Animation(animationspeed, Assets.player_running_up);
        animDownright = new Animation(animationspeed, Assets.player_running_downright);
        animUpright = new Animation(animationspeed, Assets.player_running_upright);
        animDownleft = new Animation(animationspeed, Assets.player_running_downleft);
        animUpleft = new Animation(animationspeed, Assets.player_running_upleft);
        animRight = new Animation(animationspeed, Assets.player_running_right);
        animLeft = new Animation(animationspeed, Assets.player_running_left);
        
        animIdleDown = new Animation(animationidlespeed, Assets.player_idle_down);
        animIdleUp = new Animation(animationidlespeed, Assets.player_idle_up);
        animIdleRight = new Animation(animationidlespeed, Assets.player_idle_right);
        animIdleLeft = new Animation(animationidlespeed, Assets.player_idle_left);
        animIdleDownright = new Animation(animationidlespeed, Assets.player_idle_downright);
        animIdleUpright = new Animation(animationidlespeed, Assets.player_idle_upright);
        animIdleDownleft = new Animation(animationidlespeed, Assets.player_idle_downleft);
        animIdleUpleft = new Animation(animationidlespeed, Assets.player_idle_upleft);
        
        
        animMiningDown = new Animation(animationminingspeed, Assets.player_mining_down);
        animMiningUp = new Animation(animationminingspeed, Assets.player_mining_up);
        animMiningRight = new Animation(animationminingspeed, Assets.player_mining_right);
        animMiningLeft = new Animation(animationminingspeed, Assets.player_mining_left);
        animMiningDownright = new Animation(animationminingspeed, Assets.player_mining_downright);
        animMiningUpright = new Animation(animationminingspeed, Assets.player_mining_upright);
        animMiningDownleft = new Animation(animationminingspeed, Assets.player_mining_downleft);
        animMiningUpleft = new Animation(animationminingspeed, Assets.player_mining_upleft);
    }
    
    @Override
    public void die(){
        
    }

    	@Override
	public void tick() {
                animDown.tick();
                animUp.tick();
                animDownright.tick();
                animUpright.tick();
                animDownleft.tick();
                animUpleft.tick();
                animLeft.tick();
                animRight.tick();
                
                animIdleDown.tick();
                animIdleUp.tick();
                animIdleDownright.tick();
                animIdleUpright.tick();
                animIdleDownleft.tick();
                animIdleUpleft.tick();
                animIdleLeft.tick();
                animIdleRight.tick();
                
                animMiningDown.tick();
                animMiningUp.tick();
                animMiningRight.tick();
                animMiningLeft.tick();
                animMiningDownright.tick();
                animMiningUpright.tick();
                animMiningDownleft.tick();
                animMiningUpleft.tick();
                
                //Movement
                getInput();
                move();
                handler.getGameCamera().centerOnEntity(this);
                
                
                checkAttacks();
	}
        
        private void checkAttacks(){
            
            if(xMove!= 0 || yMove!=0)
                return;
            
            attackTimer += System.currentTimeMillis() - lastAttackTimer;
            lastAttackTimer = System.currentTimeMillis();
            if(attackTimer < attackCooldown)
                return;
            
            
            Rectangle cb = getCollisionBounds(0,0);
            Rectangle ar = new Rectangle();
            int arSize = 20;
            ar.width= arSize;
            ar.height = arSize;
            
            
            
            if(handler.getKeyManager().attack && idlelookposition==0){
                    ar.x = cb.x + cb.width/2 - arSize/2;
                    ar.y = cb.y - arSize;
            } else if(handler.getKeyManager().attack && idlelookposition==2){
                    ar.x = cb.x + cb.width;
                    ar.y = cb.y + cb.height/2 - arSize/2;
            } else if(handler.getKeyManager().attack && idlelookposition==4){
                    ar.x = cb.x + cb.width/2 - arSize/2;
                    ar.y = cb.y + cb.height;
            } else if(handler.getKeyManager().attack && idlelookposition==6){
                    ar.x = cb.x - arSize;
                    ar.y = cb.y + cb.height/2 - arSize/2;
            } else{
                return;
            }
            
            attackTimer = 0;
            
            for(Entity e: handler.getWorld().getEntityManager().getEntities()){
                if(e.equals(this))
                    continue;
                
                if(e.getCollisionBounds(0,0).intersects(ar)){
                    e.hurt(damage);
                    return;
                }
                
            }
            
            
            
        }
        
        private void getInput(){
            xMove=0;
            yMove=0;
           /* if(!handler.getKeyManager().attack && getWidth()!=defaultwidth)
            {
                System.out.println(getWidth());
                setWidth(defaultwidth);
                setHeight(defaultheight);
                this.setX(this.getX()+52);
                this.setY(this.getY()+18);
            }*/

            
            if(handler.getKeyManager().attack)
            {
                /*if(getWidth()!=196)
                {
                setWidth(196);
                setHeight(194);
                this.setX(this.getX()-52);
                this.setY(this.getY()-18);
                }*/
                return;                
                
            }
            

            
            if(handler.getKeyManager().up) 
                { 
                //    playerposition=Assets.playeridleup;
                    yMove = -speed;
                } 		
		if(handler.getKeyManager().down)
		{ 
                    //playerposition=animDown.getCurrentFrame();
                    yMove = speed;
                } 
		if(handler.getKeyManager().left)
		{ 
                    //playerposition=Assets.playeridleleft;
                    xMove = -speed;
                } 
		if(handler.getKeyManager().right)
                { 
                  //  playerposition=Assets.playeridleright;
                    xMove = speed;
                } 
                
                
                //if(handler.getKeyManager().up && handler.getKeyManager().right) playerposition=Assets.playeridleupright;
                //if(handler.getKeyManager().up && handler.getKeyManager().left) playerposition=Assets.playeridleupleft;
                //if(handler.getKeyManager().down && handler.getKeyManager().right) playerposition=Assets.playeridledownright;
                //if(handler.getKeyManager().down && handler.getKeyManager().left) playerposition=Assets.playeridledownleft;
        }
        
        
        
        
        

    @Override
    public void render(Graphics g) {
        g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
        
        //Colision
        /*g.setColor(Color.red);
        g.fillRect((int)(x+ bounds.x - handler.getGameCamera().getxOffset()),
                (int)(y+ bounds.y - handler.getGameCamera().getyOffset()),
                    bounds.width, bounds.height);*/
        
    }

    @Override
    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public void setHeight(int height) {
        this.height = height;
    }
    
    
    
    
    
    private BufferedImage getCurrentAnimationFrame(){
        //ATACK OR MINE
        if(handler.getKeyManager().attack && idlelookposition==0){
            return animMiningUp.getCurrentFrame();
        } else if(handler.getKeyManager().attack && idlelookposition==2){
            return animMiningRight.getCurrentFrame();    
        } else if(handler.getKeyManager().attack && idlelookposition==4){
            return animMiningDown.getCurrentFrame();    
        } else if(handler.getKeyManager().attack && idlelookposition==6){
            return animMiningLeft.getCurrentFrame();   
                    
        //MAIN
        }else if (xMove< 0 && yMove==0){
            idlelookposition=6;
            return animLeft.getCurrentFrame();
        }else if(xMove > 0 && yMove==0){
            idlelookposition=2;
            return animRight.getCurrentFrame();
        }else if(yMove < 0 && xMove==0){
            idlelookposition=0;
            return animUp.getCurrentFrame();
        }else if(yMove > 0 && xMove==0){
            idlelookposition=4;
            return animDown.getCurrentFrame();
        //SECONDARY
        }else if(xMove < 0 && yMove<0){
            idlelookposition=7;
            return animUpleft.getCurrentFrame();    
        }else if(xMove > 0 && yMove<0){
            idlelookposition=1;
            return animUpright.getCurrentFrame();
        }else if(xMove < 0 && yMove>0){
            idlelookposition=5;
            return animDownleft.getCurrentFrame();
        }else if(xMove > 0 && yMove>0){
            idlelookposition=3;
            return animDownright.getCurrentFrame();
            //IDLE
        }else if(xMove == 0 && yMove==0 && idlelookposition==0){      
            return animIdleUp.getCurrentFrame();
        }else if(xMove == 0 && yMove==0 && idlelookposition==1){           
            return animIdleUpright.getCurrentFrame();
        }else if(xMove == 0 && yMove==0 && idlelookposition==2){            
            return animIdleRight.getCurrentFrame();
        }else if(xMove == 0 && yMove==0 && idlelookposition==3){            
            return animIdleDownright.getCurrentFrame();
        }else if(xMove == 0 && yMove==0 && idlelookposition==5){   
            return animIdleDownleft.getCurrentFrame();
        }else if(xMove == 0 && yMove==0 && idlelookposition==6){
            return animIdleLeft.getCurrentFrame();
        }else if(xMove == 0 && yMove==0 && idlelookposition==7){   
            return animIdleUpleft.getCurrentFrame();
        }else//if(xMove == 0 && yMove==0 && idlelookposition==4){  
            return animIdleDown.getCurrentFrame();
        
    }


}
