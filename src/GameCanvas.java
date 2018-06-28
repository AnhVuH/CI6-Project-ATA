import base.GameObjectManager;
import base.Vector2D;
import constant.Constant;
import game.Button;
import input.MouseInput;
import scene.SceneManager;
import scene.StartScene;
import viewport.ChangeViewPort;
import viewport.ViewPort;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GameCanvas extends JPanel {
    public Vector2D position;

    private  BufferedImage backBuffered;
    private Graphics graphics;
    private ViewPort viewPort;
    private ChangeViewPort changeViewPort;



    public GameCanvas(){
        this.position = new Vector2D();
        this.setSize(Constant.Canvas.WIDTH,Constant.Canvas.HEIGHT);
        this.setupBackBuffered();

        SceneManager.instance.changeScene(new StartScene());

//        new SceneSpawner();

        this.setVisible(true);
        this.viewPort = new ViewPort();
        this.changeViewPort = new ChangeViewPort();
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D graphics2D = (Graphics2D)g;
        graphics2D.drawImage(backBuffered,0 ,0 ,null );
    }

    private void setupBackBuffered(){
        this.backBuffered = new BufferedImage(Constant.Canvas.WIDTH,Constant.Canvas.HEIGHT ,BufferedImage.TYPE_4BYTE_ABGR );
        this.graphics = this.backBuffered.getGraphics();
    }


    public void renderAll(){
        GameObjectManager.instance.renderAll(this.graphics);
        viewPort.translate((Graphics2D)this.graphics);
        this.repaint();
    }

    public void runAll(){
        GameObjectManager.instance.runAll();
        SceneManager.instance.performChangeSceneIfNeeded();
        if(MouseInput.instance.clicked){
            MouseInput.instance.checkMouseClicked();
            System.out.println("click");
            MouseInput.instance.clicked = false;
        }
        this.changeViewPort.run(this.viewPort);


    }


}
