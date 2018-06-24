package game.gift;

import action.ActionAdapter;
import action.SequenceAction;
import action.WaitAction;
import base.GameObject;
import base.GameObjectManager;
import constant.Constant;
import game.platform.Platform;

import java.util.List;

public class GiftSpawner extends GameObject {

    public GiftSpawner(){
        this.createAction();
    }

    private void createAction() {
        this.addAction(
                new SequenceAction(
                        //delay đợi cac platform được khởi tạo mới tìm vị trí platform Gift-station được
                        new WaitAction(1),
                        new ActionAdapter() {
                            @Override
                            public boolean run(GameObject owner) {
                                setupGift();
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

    private void setupGift(){
        List<Platform> giftStations = GameObjectManager.instance.findPlatformsByName("Gift-station");
        giftStations.forEach(giftStation->{
            Gift newGift = GameObjectManager.instance.recycle(Gift.class);
            newGift.position.set(giftStation.position.subtract(0,Constant.Tile.HEIGHT/2 + Constant.Gift.HEIGHT/2));
        });

    }
}