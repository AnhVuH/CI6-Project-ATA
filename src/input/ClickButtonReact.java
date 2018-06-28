package input;

import constant.Constant;
import scene.GamePlayScene;
import scene.SceneManager;
import scene.SceneSpawner;

public class ClickButtonReact {
    public static ClickButtonReact instance = new ClickButtonReact();
    public void run(String labelButton){
        if(labelButton.equals(Constant.Button.START))//"Start Button"
        {
            new SceneSpawner();
        }
        if(labelButton.equals(Constant.Button.REPLAY_ALL))//"Replay All"
        {
            GamePlayScene.level =0;
            new SceneSpawner();
        }

    }
}
