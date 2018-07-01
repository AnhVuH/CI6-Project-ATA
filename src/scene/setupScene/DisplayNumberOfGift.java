package scene.setupScene;

import action.ActionAdapter;
import action.SequenceAction;
import action.WaitAction;
import base.GameObject;
import base.GameObjectManager;
import base.Vector2D;
import constant.Constant;
import game.Text;
import game.gift.Gift;
import game.player.Player;

import java.awt.*;

public class DisplayNumberOfGift extends GameObject {

    public DisplayNumberOfGift(){
        this.createAction();
    }

    private void createAction() {
        this.addAction(new SequenceAction(
                new ActionAdapter() {
                    @Override
                    public boolean run(GameObject owner) {
                        // tìm số quà còn lại trong map
                        long numberOfGift = GameObjectManager.instance.countObjectAlive(Gift.class);
                        // tìm player để lấy vị trí của player hiển thị dòng text số quà còn lại phía trên
                        Player player = GameObjectManager.instance.findObjectAlive(Player.class);

                        boolean created = false;
                        if (numberOfGift > 0 && player!=null) {
                            created = true;
//                            Text text = new Text(new Vector2D(player.position.x,50), "Find more " + numberOfGift+" gifts " , "Arial", 30, Color.red);
                            Text text = new Text(new Vector2D(player.position.x,50),
                                        "Find more " + numberOfGift+" gifts ", Color.white, "assets/font/Pixeled.ttf", 30);
                            GameObjectManager.instance.add(text);

                        }

                        return created;
                    }
                }
                ,
                new WaitAction(50),
                new ActionAdapter() {
                    @Override
                    public boolean run(GameObject owner) {
                        Text text = GameObjectManager.instance.findObjectAlive(Text.class);
                        text.isAlive = false;
                        return true;
                    }
                }
                )

        );
    }


    @Override
    public void run() {
        super.run();
    }
}
