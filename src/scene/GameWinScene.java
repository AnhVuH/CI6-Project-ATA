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

public class GameWinScene implements Scene {
    private Clip sound;
    @Override
    public void init() {
        GameObjectManager.instance.recycle(Background.class);
        long minute = (GamePlayScene.totalPlayTime)/60;
        long second = (GamePlayScene.totalPlayTime)%60;

        Text textScore = new Text(
                new Vector2D(Constant.Window.WIDTH/2 -275,Constant.Window.HEIGHT/2-60),
                "Your total time: " + minute +" minutes " +second+" seconds", Color.white, "assets/font/Pixeled.ttf", 30);

        GameObjectManager.instance.add(textScore);

        game.Button backButton = new Button(
                new Vector2D(Constant.Window.WIDTH/2, Constant.Window.HEIGHT/2) ,
                250,
                100,
                Constant.Button.BACK_HOME,"assets/images/back-home.png"); //"Back home"
        GameObjectManager.instance.add(backButton);
        this.sound = Utils.loadAudio("assets/audio/Communications satellite.wav");
        this.sound.loop(-1);
        this.sound.start();

    }

    @Override
    public void deinit() {
        GameObjectManager.instance.clear();
        this.sound.stop();
    }
}
