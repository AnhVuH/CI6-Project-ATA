package scene;


import base.GameObjectManager;
import game.Background;
import scene.setupScene.GiftSpawner;
import scene.setupScene.DisplayNumberOfGift;
import scene.setupScene.SetupPlayer;
import scene.setupScene.SetupStation;
import maps.Map;


public class GamePlayScene implements Scene{
    private String mapPath;
    public static int level =0;


    public GamePlayScene(String mapPath){
        this.mapPath = mapPath;
    }


    private void setupCharacter(){
        GameObjectManager.instance.recycle(GiftSpawner.class);
        GameObjectManager.instance.recycle(SetupStation.class);
        GameObjectManager.instance.recycle(SetupPlayer.class);
        GameObjectManager.instance.recycle(DisplayNumberOfGift.class);

    }

    private void addPlatform(String mapPath){
        Map map = Map.load(mapPath);
        map.generate();
    }

    @Override
    public void init() {
        GameObjectManager.instance.recycle(Background.class);
        this.addPlatform(this.mapPath);
        this.setupCharacter();

    }

    @Override
    public void deinit() {

        GameObjectManager.instance.clear();

    }
}
