import base.GameObjectManager;
import base.Vector2D;
import game.Background;
import game.player.Player;
import maps.Map;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GameCanvas extends JPanel {
    public final int MAPWIDTH= 1600;
    public final int MAPHEIGHT= 600;
    public Vector2D position;

    private  BufferedImage backBuffered;
    private Graphics graphics;
    public Player player;
    public ViewPort viewPort;

    public GameCanvas(){
        this.position = new Vector2D();
        this.setSize(MAPWIDTH,MAPHEIGHT);
        this.setupBackBuffered();
        this.setupCharacter();
        this.addPlatform();
        this.setVisible(true);
        this.viewPort = new ViewPort();
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D graphics2D = (Graphics2D)g;
        graphics2D.drawImage(backBuffered,0 ,0 ,null );
    }

    private void setupBackBuffered(){
        this.backBuffered = new BufferedImage(MAPWIDTH,MAPHEIGHT ,BufferedImage.TYPE_4BYTE_ABGR );
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
        viewPort.translate((Graphics2D)this.graphics);
        this.repaint();
    }

    public void runAll(){
        GameObjectManager.instance.runAll();

    }


}
