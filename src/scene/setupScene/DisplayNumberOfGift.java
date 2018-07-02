package scene.setupScene;

import action.ActionAdapter;
import action.RepeatActionForever;
import base.GameObject;
import base.GameObjectManager;
import base.Vector2D;
import game.text.TextFollowPlayer;
import game.gift.Gift;
import renderer.TextRenderer;

import java.awt.*;

public class DisplayNumberOfGift extends GameObject {

    public DisplayNumberOfGift(){
        this.createAction();
    }

    private void createAction() {
        this.addAction(new RepeatActionForever(
                        new ActionAdapter() {
                            @Override
                            public boolean run(GameObject owner) {
                                boolean created = false;
                                // tìm số quà còn lại trong map
                                long numberOfGift = GameObjectManager.instance.countObjectAlive(Gift.class);
                                TextFollowPlayer textFollowPlayer = GameObjectManager.instance.findObjectAlive(TextFollowPlayer.class);
//                        if ( player!=null) {
                                created = true;
                                if(textFollowPlayer==null){
                                    TextFollowPlayer text = new TextFollowPlayer(
                                            "Find " + numberOfGift+" more gifts", Color.white, "assets/font/Pixeled.ttf", 30,new Vector2D(300,70));
                                    GameObjectManager.instance.add(text);

                                }
                                else{
                                    if(numberOfGift>0){
                                        textFollowPlayer.renderer = new TextRenderer("Find " + numberOfGift+" more gifts", Color.white, "assets/font/Pixeled.ttf", 30);
                                    }
                                    else{
                                        textFollowPlayer.renderer = new TextRenderer("Go to station!!!", Color.white, "assets/font/Pixeled.ttf", 30);
                                    }

                                }

//                        }

                                return created;
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
