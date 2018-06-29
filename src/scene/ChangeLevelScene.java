package scene;

import base.GameObjectManager;
import base.Vector2D;
import constant.Constant;
import game.Button;
import game.Text;

import java.awt.*;

public class ChangeLevelScene implements Scene {


    @Override
    public void init() {
        long minute = (GamePlayScene.playTime)/60;
        long second = (GamePlayScene.playTime)%60;
        Text textScore = new Text(
                new Vector2D(Constant.Window.WIDTH/2 -200,Constant.Window.HEIGHT/2-50),
                "Your time: " + minute +" minutes " +second+" seconds","Arial" ,
                30,
                Color.red );

        GameObjectManager.instance.add(textScore);

        game.Button replayButton = new Button(
                new Vector2D(Constant.Window.WIDTH/2-100, Constant.Window.HEIGHT/2) ,
                100,
                40,
                Constant.Button.REPLAY_ONE,"assets/images/replay-button.png"); //"Replay One"
        GameObjectManager.instance.add(replayButton);

        if (GamePlayScene.level < Constant.Scene.ARRAY_PATH_SCENE.length){
            game.Button nextButton = new Button(
                    new Vector2D(Constant.Window.WIDTH/2, Constant.Window.HEIGHT/2) ,
                    100,
                    40,
                    Constant.Button.NEXT_SCENE,"assets/images/next-button.png"); //"Next Scene"
            GameObjectManager.instance.add(nextButton);
        }
        else{
            Text text = new Text(new Vector2D(Constant.Window.WIDTH/2 -100,Constant.Window.HEIGHT/2-150), "You Win!!!","Arial" , 50,Color.red );

            GameObjectManager.instance.add(text);

            game.Button scoreButton = new Button(
                    new Vector2D(Constant.Window.WIDTH/2, Constant.Window.HEIGHT/2) ,
                    100,
                    40,
                    Constant.Button.SCORE,"assets/images/score3.png"); //"Score"
            GameObjectManager.instance.add(scoreButton);
        }

    }

    @Override
    public void deinit() {
        GameObjectManager.instance.clear();

    }
}
