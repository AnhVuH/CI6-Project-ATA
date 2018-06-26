package scene;

import java.util.List;

public class SceneManager  {
    private Scene currentScene;
    private Scene nextScene;
    public static SceneManager instance = new SceneManager();


    private SceneManager(){
    }

    public void changeScene(Scene scene){
        this.nextScene = scene;
    }

    public void performChangeSceneIfNeeded(){
        if(this.nextScene!=null){
            if(this.currentScene!=null){
                this.currentScene.deinit();
            }
            this.nextScene.init();
            this.currentScene = this.nextScene;
            this.nextScene = null;
        }
    }

}
