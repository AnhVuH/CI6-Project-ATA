package scene;

import constant.Constant;

public class SceneSpawner {
    public SceneSpawner(){
        if(GamePlayScene.level < Constant.Scene.ARRAY_PATH_SCENE.length){
            SceneManager.instance.changeScene(new GamePlayScene(Constant.Scene.ARRAY_PATH_SCENE[GamePlayScene.level]));
        }
        else{
            SceneManager.instance.changeScene(new GameWinScene());

        }

    }

}
