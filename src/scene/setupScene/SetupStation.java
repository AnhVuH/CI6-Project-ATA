package scene.setupScene;

import action.ActionAdapter;
import action.GroupAction;
import base.GameObject;
import base.GameObjectManager;
import constant.Constant;
import game.platform.Platform;
import game.platform.StartStation;
import game.platform.Station;

import java.util.List;

public class SetupStation extends GameObject {
    public SetupStation(){
        this.creatAction();
    }

    private void creatAction() {
        this.addAction(new GroupAction(
                        new ActionAdapter() {
                            @Override
                            public boolean run(GameObject owner) {

                                return setupStation();
                            }
                        },
                        new ActionAdapter() {
                            @Override
                            public boolean run(GameObject owner) {

                                return setupStartStation();
                            }
                        }

        )


        );
    }
    @Override
    public void run() {
        super.run();
    }

    private boolean setupStation() {
        List<Platform> stations = GameObjectManager.instance.findPlatformsByName("Station");
        boolean created = false;
        if(stations.size()!=0){
//            System.out.println("station");
            Platform station = stations.get(0);
            Station newStation = GameObjectManager.instance.recycle(Station.class);
            newStation.position.set(station.position.subtract(0,Constant.Tile.HEIGHT/2 + Constant.Station.HEIGHT/2));
            created = true;
        }
        return created;

    }


    private boolean setupStartStation() {
        List<Platform> startStations = GameObjectManager.instance.findPlatformsByName("Start-Station");
        boolean created = false;
        if(startStations.size()!=0){
//            System.out.println("start Station");
            Platform station = startStations.get(0);
            StartStation newStation = GameObjectManager.instance.recycle(StartStation.class);
            newStation.position.set(station.position.subtract(0,Constant.Tile.HEIGHT/2 + Constant.Station.HEIGHT/2));
            created = true;
        }
        return created;

    }
}
