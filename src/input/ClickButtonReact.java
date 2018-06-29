package input;

import constant.Constant;
import scene.GamePlayScene;
import scene.GameWinScene;
import scene.SceneManager;
import scene.SceneSpawner;

public class ClickButtonReact {
    public static ClickButtonReact instance = new ClickButtonReact();
    public void run(String labelButton){
        if(labelButton.equals(Constant.Button.START)|| labelButton.equals(Constant.Button.NEXT_SCENE))//"Start Button"
        {
            new SceneSpawner();
        }
        if(labelButton.equals(Constant.Button.REPLAY_ALL))//"Replay All"
        {
            GamePlayScene.level =0;
            GamePlayScene.totalPlayTime =0;
            new SceneSpawner();
        }
        if(labelButton.equals(Constant.Button.REPLAY_ONE)){
            GamePlayScene.level -=1;
            GamePlayScene.totalPlayTime -= GamePlayScene.playTime;
            new SceneSpawner();
        }
        if(labelButton.equals(Constant.Button.SCORE)){
            SceneManager.instance.changeScene(new GameWinScene());
        }

    }
}
