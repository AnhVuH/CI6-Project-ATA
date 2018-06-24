import base.GameObjectManager;
import constant.Constant;
import input.KeyboardInput;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GameWindow extends JFrame {
    private GameCanvas gameCanvas;
    public long lastTime = 0;


    public GameWindow(){
        this.setSize(Constant.Window.WIDTH,Constant.Window.HEIGHT);
        this.setupGameCanvas();
        this.event();
        this.setResizable(false);
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

    public void gameLoop() {
        while (true) {
            long currentTime = System.nanoTime();
            if (currentTime - this.lastTime >= 17_000_000) {
                this.gameCanvas.renderAll();
                this.gameCanvas.runAll();
                this.lastTime = currentTime;
            }

        }
    }


}
