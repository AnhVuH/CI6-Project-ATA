import base.GameObjectManager;
import game.Background;
import game.Player;
import input.KeyboardInput;
import maps.Map;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GameCanvas extends JPanel {
    BufferedImage backBuffered;
    Graphics graphics;
    Player player;

    public GameCanvas(){
        this.setSize(1200,800 );
        this.setupBackBuffered();
        this.setupCharacter();
        this.addPlatform();
        this.setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(backBuffered,0 ,0 ,null );
    }

    private void setupBackBuffered(){
        this.backBuffered = new BufferedImage(1200,800 ,BufferedImage.TYPE_4BYTE_ABGR );
        this.graphics = this.backBuffered.getGraphics();
    }

    private void setupCharacter(){
        GameObjectManager.instance.recycle(Background.class);
        this.player = GameObjectManager.instance.recycle(Player.class);
        this.player.position.set(500,100);

    }

    private void addPlatform(){
        Map map = Map.load("assets/maps/Map.json");
        map.generate();
    }


    public void renderAll(){
        GameObjectManager.instance.renderAll(this.graphics);
        this.repaint();
    }

    public void runAll(){
        GameObjectManager.instance.runAll();
//        KeyboardInput.instance.reset();

    }


}
