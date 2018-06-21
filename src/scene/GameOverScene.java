package scene;

import base.GameObjectManager;
import base.Vector2D;
import constant.Constant;
import game.Background;
import game.Text;

import java.awt.*;

public class GameOverScene implements Scene {


    @Override
    public void init() {
        Text  text = new Text(new Vector2D(Constant.Window.WIDTH/2 -100,Constant.Window.HEIGHT/2-50), "Game Over","Arial" , 50,Color.red );
//        GameObjectManager.instance.recycle(Background.class);
        GameObjectManager.instance.add(text);
    }

    @Override
    public void deinit() {
        GameObjectManager.instance.clear();
    }
}
