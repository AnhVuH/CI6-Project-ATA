package scene;

import constant.Constant;

public class SceneSpawner {
    public SceneSpawner(){
            SceneManager.instance.changeScene(new GamePlayScene(Constant.Scene.ARRAY_PATH_SCENE[GamePlayScene.level]));
            GamePlayScene.startTime = System.currentTimeMillis()/1000;
            GamePlayScene.playTime =0;
    }

}
