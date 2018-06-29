package input;

import constant.Constant;
import scene.GamePlayScene;
import scene.SceneManager;
import scene.SceneSpawner;

public class ClickButtonReact {
    // sử dụng object instance là kiểu static dùng chung cho class ko cần khởi tạo 1 object cụ thể
    // gọi hàm run trong class MouseInput
    public static ClickButtonReact instance = new ClickButtonReact();
    public void run(String labelButton){
        if(labelButton.equals(Constant.Button.START)|| labelButton.equals(Constant.Button.NEXT_SCENE))//"Start Button"
        {
            new SceneSpawner();
        }
        if(labelButton.equals(Constant.Button.REPLAY_ALL))//"Replay All"
        {
            GamePlayScene.level =0;
            new SceneSpawner();
        }
        if(labelButton.equals(Constant.Button.REPLAY_ONE)){
            GamePlayScene.level -=1;
            new SceneSpawner();
        }

    }
}
