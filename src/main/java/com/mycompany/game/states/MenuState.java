package com.mycompany.game.states;

import com.mycompany.game.Handler;
import com.mycompany.game.gfx.Assets;
import com.mycompany.game.ui.ClickListener;
import com.mycompany.game.ui.UIImageButton;
import com.mycompany.game.ui.UIManager;
import java.awt.Graphics;

public class MenuState extends State {

    private UIManager uiManager;
    
    public MenuState(Handler handler){
        super(handler);
        uiManager = new UIManager(handler);
        
        handler.getMouseManager().setUIManager(uiManager);
        
        uiManager.addObject(new UIImageButton(200,200,128,64,Assets.btn_start, new ClickListener(){
            @Override
            public void onClick() {
                handler.getMouseManager().setUIManager(null);
                State.setState(handler.getGame().gameState);
            }
        }));
    }
    
    
    
    @Override
    public void tick() {
        uiManager.tick();
        
        
        //TEMPORARILY
         handler.getMouseManager().setUIManager(null);
                State.setState(handler.getGame().gameState);
    }

    @Override
    public void render(Graphics g) {
        uiManager.render(g);
    }
    
}
