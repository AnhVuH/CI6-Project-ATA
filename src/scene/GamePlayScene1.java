package scene;


import base.GameObject;
import base.GameObjectManager;
import game.Background;
import game.gift.GiftSpawner;
import game.platform.SetupStation;
import game.platform.Station;
import game.player.Player;
import maps.Map;


public class GamePlayScene1 implements Scene{

    private void setupCharacter(){
        Player player = GameObjectManager.instance.recycle(Player.class);
        player.position.set(200,80);

//        Station station = GameObjectManager.instance.recycle(Station.class);
//        station.position.set(1000, 500);

        GameObjectManager.instance.recycle(GiftSpawner.class);
        GameObjectManager.instance.recycle(SetupStation.class);

    }


    private void addPlatform(){
        Map map = Map.load("assets/maps/ATA-MAPS/atamap1.json");
        map.generate();
    }

    @Override
    public void init() {
        GameObjectManager.instance.recycle(Background.class);
        this.addPlatform();
        this.setupCharacter();
    }

    @Override
    public void deinit() {

        GameObjectManager.instance.clear();

    }
}
