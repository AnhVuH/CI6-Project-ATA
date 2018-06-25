package scene;


import base.GameObjectManager;
import game.Background;
import scene.setupScene.GiftSpawner;
import scene.setupScene.SetupPlayer;
import scene.setupScene.SetupStation;
import game.player.Player;
import maps.Map;


public class GamePlayScene1 implements Scene{

    private void setupCharacter(){
        GameObjectManager.instance.recycle(GiftSpawner.class);
        GameObjectManager.instance.recycle(SetupStation.class);
        GameObjectManager.instance.recycle(SetupPlayer.class);

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
