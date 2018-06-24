package game.platform;

import action.ActionAdapter;
import action.SequenceAction;
import action.WaitAction;
import base.GameObject;
import base.GameObjectManager;
import constant.Constant;

import java.util.List;

public class SetupStation extends GameObject {
    public SetupStation(){
        this.creatAction();
    }

    private void creatAction() {
        this.addAction(
                new SequenceAction(
                        //delay đợi cac platform được khởi tạo mới tìm vị trí platform Gift-station được
                        new WaitAction(1),
                        new ActionAdapter() {
                            @Override
                            public boolean run(GameObject owner) {
                                setupStation();
                                return true;
                            }
                        }
                )
        );
    }
    @Override
    public void run() {
        super.run();
    }

    private void setupStation() {
        List<Platform> Stations = GameObjectManager.instance.findPlatformsByName("Station");
            Platform station = Stations.get(0);
            Station newStation = GameObjectManager.instance.recycle(Station.class);
            newStation.position.set(station.position.subtract(0,Constant.Tile.HEIGHT/2 + Constant.Station.HEIGHT/2));
    }
}
