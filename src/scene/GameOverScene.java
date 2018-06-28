package scene;

import base.GameObjectManager;
import base.Vector2D;
import constant.Constant;
import game.Background;
import game.Button;
import game.Text;

import java.awt.*;

public class GameOverScene implements Scene {


    @Override
    public void init() {
        Text  text = new Text(new Vector2D(Constant.Window.WIDTH/2 -100,Constant.Window.HEIGHT/2-50), "Game Over","Arial" , 50,Color.red );
//        GameObjectManager.instance.recycle(Background.class);
        GameObjectManager.instance.add(text);
        game.Button replayButton = new Button(
                new Vector2D(Constant.Window.WIDTH/2, Constant.Window.HEIGHT/2) ,
                160,
                60,
                Color.GREEN,
                Constant.Button.REPLAY_ALL); //"Replay All"
        GameObjectManager.instance.add(replayButton);
        Text labelButton = new Text(
                new Vector2D(Constant.Window.WIDTH/2-50, Constant.Window.HEIGHT/2+10),
                "Replay",
                "Arial",
                30,
                Color.WHITE);
        GameObjectManager.instance.add(labelButton);
    }

    @Override
    public void deinit() {
        GameObjectManager.instance.clear();
    }
}
