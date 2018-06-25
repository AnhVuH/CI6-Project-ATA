package scene.setupScene;

import action.ActionAdapter;

import base.GameObject;
import base.GameObjectManager;
import constant.Constant;
import game.gift.Gift;
import game.platform.Platform;

import java.util.List;

public class GiftSpawner extends GameObject {

    public GiftSpawner(){
        this.createAction();
    }

    private void createAction() {
        this.addAction(
                        new ActionAdapter() {
                            @Override
                            public boolean run(GameObject owner) {
                                return setupGift();
                            }
                        }

        );
    }


    @Override
    public void run() {
        super.run();
    }

    private boolean setupGift(){
        List<Platform> giftStations = GameObjectManager.instance.findPlatformsByName("Gift-station");
        boolean created = false;
        if(giftStations.size()!=0) {
            giftStations.forEach(giftStation->{
//                System.out.println("Gift");
                Gift newGift = GameObjectManager.instance.recycle(Gift.class);
                newGift.position.set(giftStation.position.subtract(0,Constant.Tile.HEIGHT/2 + Constant.Gift.HEIGHT/2));
            });
            created = true;
        }
        return created;
    }
}
