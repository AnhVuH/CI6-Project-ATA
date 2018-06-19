import input.KeyboardInput;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GameWindow extends JFrame {
    public final int WIDTH= 800;
    public final int HEIGHT= 400;
    GameCanvas gameCanvas;
    public long lastTime = 0;

    public GameWindow(){
        this.setSize(WIDTH,HEIGHT);
        this.setupGameCanvas();
        this.event();
        this.setVisible(true);
    }
    private void setupGameCanvas(){
        this.gameCanvas = new GameCanvas();
        this.add(this.gameCanvas);
    }


    private void keyboardEvent(){
        this.addKeyListener(KeyboardInput.instance);

    }

    private void windowEvent() {
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(1);
            }
        });
    }

    private void event(){
        this.keyboardEvent();
        this.windowEvent();
    }

    private void changeViewPort(){
        int maxOffsetX= this.gameCanvas.MAPWIDTH - this.WIDTH;
        int maxOffsetY = this.gameCanvas.MAPHEIGHT - this.HEIGHT;
        int minOffsetX =0;
        int minOffsetY =0;
        float camPositionX = gameCanvas.player.position.x-WIDTH/2;
        float camPositionY = gameCanvas.player.position.y -HEIGHT/2;

        if(camPositionX > maxOffsetX){
            camPositionX = maxOffsetX;
        }
        else if(camPositionX < minOffsetX){
            camPositionX = minOffsetX;
        }
        if(camPositionY > maxOffsetY){
            camPositionY = maxOffsetY;
        }
        else if(camPositionY < minOffsetY){
            camPositionY = minOffsetY;
        }
        gameCanvas.viewPort.position.set(-camPositionX,-camPositionY);
    }

    public void gameLoop() {
        while (true) {
            long currentTime = System.nanoTime();
            if (currentTime - this.lastTime >= 17_000_000) {
                this.gameCanvas.runAll();
                this.changeViewPort();
                this.gameCanvas.renderAll();
                this.lastTime = currentTime;
            }

        }
    }


}
