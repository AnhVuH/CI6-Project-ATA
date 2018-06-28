import base.GameObjectManager;
import constant.Constant;
import input.KeyboardInput;
import input.MouseInput;

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

    private void mouseEvent(){
//        this.addMouseListener(MouseInput.instance);
        // phải sử dụng getContentPane để lấy tọa độ 0,0 không tính phần bao của cửa sổ window
        // lệnh getX, getY lấy tọa độ so với điểm 0,0 là phần nội dung bên trong ko tính phần bao
        this.getContentPane().addMouseListener(MouseInput.instance);
    }

    private void event(){
        this.keyboardEvent();
        this.mouseEvent();
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
