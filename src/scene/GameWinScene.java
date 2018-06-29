package scene;

import base.GameObjectManager;
import base.Vector2D;
import constant.Constant;

import game.Background;
import game.Button;
import game.Text;

import java.awt.*;

public class GameWinScene implements Scene {
    @Override
    public void init() {
        GameObjectManager.instance.recycle(Background.class);
        long minute = (GamePlayScene.totalPlayTime)/60;
        long second = (GamePlayScene.totalPlayTime)%60;
        Text textScore = new Text(
                new Vector2D(Constant.Window.WIDTH/2 -200,Constant.Window.HEIGHT/2-50),
                "Your total time: " + minute +" minutes " +second+" seconds","Arial" ,
                30,
                Color.red );
        GameObjectManager.instance.add(textScore);

        game.Button replayButton = new Button(
                new Vector2D(Constant.Window.WIDTH/2-50, Constant.Window.HEIGHT/2) ,
                100,
                40,
                Constant.Button.REPLAY_ALL,"assets/images/replay-all-button.png"); //"Replay all"
        GameObjectManager.instance.add(replayButton);

    }

    @Override
    public void deinit() {
        GameObjectManager.instance.clear();
    }
}
