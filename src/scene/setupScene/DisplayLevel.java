package scene.setupScene;

import action.ActionAdapter;
import action.SequenceAction;
import action.WaitAction;
import base.GameObject;
import base.GameObjectManager;
import base.Vector2D;
import constant.Constant;
import game.text.Text;
import scene.GamePlayScene;

import java.awt.*;

public class DisplayLevel extends GameObject {
    public DisplayLevel(){
        this.createAction();
    }
    private void createAction(){
        this.addAction(new SequenceAction(
                new ActionAdapter() {
                    @Override
                    public boolean run(GameObject owner) {
                        Text level = new Text(
                                new Vector2D(Constant.Window.WIDTH / 2 -100, Constant.Window.HEIGHT / 2-50),
                                "Level" + GamePlayScene.level ,
                                Color.white, "assets/font/Pixeled.ttf", 50);
                        GameObjectManager.instance.add(level);
                        return true;
                    }
                },
                new WaitAction(50),
                new ActionAdapter() {
                    @Override
                    public boolean run(GameObject owner) {
                       Text text = GameObjectManager.instance.findObjectAlive(Text.class);
                       if(text !=null)
                       {
                           text.isAlive = false;
                       }

                        return true;
                    }
                }
        ));
    }
}
