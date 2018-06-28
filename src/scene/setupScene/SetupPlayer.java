package scene.setupScene;

import action.ActionAdapter;
import base.GameObject;
import base.GameObjectManager;
import constant.Constant;
import game.platform.StartStation;
import game.player.Player;

public class SetupPlayer extends GameObject {
    public SetupPlayer(){
        this.creatAction();
    }

    public void creatAction(){
        this.addAction(
                new ActionAdapter() {
                    @Override
                    public boolean run(GameObject owner) {
                        //tìm vị tí của start station
                        StartStation startStation = GameObjectManager.instance.findObjectAlive(StartStation.class);

                        boolean created = false;
                        if(startStation!=null){
                            // khởi tạo 1 player ở vị trí start station đã tìm được
                            Player player = GameObjectManager.instance.recycle(Player.class);
                            player.position.set(startStation.position.subtract(0,Constant.Station.HEIGHT/2 + Constant.Player.HEIGHT/2));
                            created = true;
                        }

                        return created;
                    }
                }
        );
    }



    @Override
    public void run() {
        super.run();
    }

}
