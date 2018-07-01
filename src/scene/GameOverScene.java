package scene;

import base.GameObjectManager;
import base.Vector2D;
import constant.Constant;
import game.Background;
import game.Button;
import game.text.Text;
import utils.Utils;

import javax.sound.sampled.Clip;
import java.awt.*;

public class GameOverScene implements Scene {
    private Clip gameOver;


    @Override
    public void init() {
//        Text  text = new Text(new Vector2D(Constant.Window.WIDTH/2 -100,Constant.Window.HEIGHT/2-50), "Game Over","Arial" , 50,Color.red );
        GameObjectManager.instance.recycle(Background.class);
        Text text = new Text(
                new Vector2D(Constant.Window.WIDTH/2 -145,Constant.Window.HEIGHT/2-140),
                "You Lose!!!", Color.RED, "assets/font/Pixeled.ttf", 60);
        GameObjectManager.instance.add(text);
        game.Button replayButton = new Button(
                new Vector2D(Constant.Window.WIDTH/2, Constant.Window.HEIGHT/2) ,
                300,
                120,
                Constant.Button.REPLAY_ALL,"assets/images/replay-all-button.png"); //"Replay All"
        GameObjectManager.instance.add(replayButton);
        this.gameOver =Utils.loadAudio("assets/audio/gameover.wav");
        this.gameOver.loop(0);
        this.gameOver.start();
    }

    @Override
    public void deinit() {
        GameObjectManager.instance.clear();
    }
}
