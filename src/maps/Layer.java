package maps;

import base.GameObjectManager;
import game.Platform;

import java.util.List;

public class Layer {
    private List<Integer> data;
    private int width;
    private int height;

    public void generate() {
        for(int tileY =0; tileY <height; tileY++){
            for(int tileX =0; tileX<width; tileX++){
                int mapData = data.get(tileY * width + tileX);
                if(mapData !=0){
                    Platform platform = new Platform();
                    platform.position.set(tileX*20+10,tileY*20+10);
                    GameObjectManager.instance.add(platform);
                }
            }
        }
    }

    @Override
    public String toString() {
        return "Layer{" +
                "data=" + data +
                ", width=" + width +
                ", height=" + height +
                '}';
    }
}
