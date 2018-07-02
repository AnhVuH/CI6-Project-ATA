package scene;


import base.GameObjectManager;
import game.Background;
import scene.setupScene.*;
import maps.Map;


// tạo 1 class chung cho các Game Play scene, khi đổi scene chỉ cần truyền link của map

public class GamePlayScene implements Scene{
    private String mapPath;
    // sử dụng biến static để lưu thứ tự của play scene trong list ở Constant.Scene
    public static int level =0;
    public static long startTime =0;
    public static long totalPlayTime =0;
    public static long playTime =0;


    public GamePlayScene(String mapPath){
        this.mapPath = mapPath;
        //biến level sẽ tăng sau mỗi lần khởi tạo 1 đối tượng mới và đối với tất cả các đối tượng giá trị này đều bằng nhau
        level +=1;
    }


    private void setupCharacter(){
        //auto setup các object trong map theo vị trí các tile đặc biệt trong map
        GameObjectManager.instance.recycle(GiftSpawner.class);
        GameObjectManager.instance.recycle(SetupStation.class);
        GameObjectManager.instance.recycle(SetupPlayer.class);
        GameObjectManager.instance.recycle(DisplayNumberOfGift.class);
        GameObjectManager.instance.recycle(DisplayLevel.class);


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
