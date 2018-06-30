package scene;

import base.GameObjectManager;
import base.Vector2D;
import constant.Constant;
import game.Background;
import game.Button;
import game.Text;
import utils.Utils;

import javax.sound.sampled.Clip;
import java.awt.*;

public class StartScene implements Scene {
    private Clip startSound;

    @Override
    public void init() {
        Button startButton = new Button(
                new Vector2D(Constant.Window.WIDTH/2, Constant.Window.HEIGHT/2) ,
                300,
                80,
                Constant.Button.START,"assets/images/start-button.png"); // "Start Button"
        GameObjectManager.instance.recycle(Background.class);
        GameObjectManager.instance.add(startButton);
        this.startSound = Utils.loadAudio("assets/audio/Communications satellite.wav");
        this.startSound.loop(-1);
        this.startSound.start();

    }

    @Override
    public void deinit() {
        GameObjectManager.instance.clear();
        this.startSound.stop();

    }
}
