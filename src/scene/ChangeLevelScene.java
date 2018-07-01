package scene;

import base.GameObjectManager;
import base.Vector2D;
import constant.Constant;
import game.Background;
import game.Button;
import game.Text;

import java.awt.*;

public class ChangeLevelScene implements Scene {


    @Override
    public void init() {
        long minute = (GamePlayScene.playTime)/60;
        long second = (GamePlayScene.playTime)%60;
        GameObjectManager.instance.recycle(Background.class);

        Text textScore = new Text(
                new Vector2D(Constant.Window.WIDTH/2 -215,Constant.Window.HEIGHT/2-80),
                "Your time: " + minute +" minutes " +second+" seconds", Color.white, "assets/font/Pixeled.ttf", 30);
        GameObjectManager.instance.add(textScore);

        game.Button replayButton = new Button(
                new Vector2D(Constant.Window.WIDTH/2, Constant.Window.HEIGHT/2) ,
                200,
                80,
                Constant.Button.REPLAY_ONE,"assets/images/replay-button.png"); //"Replay One"
        GameObjectManager.instance.add(replayButton);

        if (GamePlayScene.level < Constant.Scene.ARRAY_PATH_SCENE.length){
            game.Button nextButton = new Button(
                    new Vector2D(Constant.Window.WIDTH/2, Constant.Window.HEIGHT/2+100) ,
                    200,
                    80,
                    Constant.Button.NEXT_SCENE,"assets/images/next-button.png"); //"Next Scene"
            GameObjectManager.instance.add(nextButton);
        }
        else{


            Text text = new Text(
                    new Vector2D(Constant.Window.WIDTH/2 -105,Constant.Window.HEIGHT/2-150),
                    "You Win!!!", Color.ORANGE, "assets/font/Pixeled.ttf", 50);

            GameObjectManager.instance.add(text);

            game.Button scoreButton = new Button(
                    new Vector2D(Constant.Window.WIDTH/2, Constant.Window.HEIGHT/2 +100) ,
                    180,
                    70,
                    Constant.Button.SCORE,"assets/images/score3.png"); //"Score"
            GameObjectManager.instance.add(scoreButton);
        }

    }

    @Override
    public void deinit() {
        GameObjectManager.instance.clear();

    }
}
