package maps;

import base.GameObjectManager;
import constant.Constant;
import game.platform.Platform;

import java.util.List;

public class Layer {
    private List<Integer> data;
    private int width;
    private int height;

    public void generate(List<Tile> tileList) {
        for(int tileY =0; tileY < this.height; tileY++){
            for(int tileX =0; tileX< this.width; tileX++){
                int mapData = data.get(tileY * this.width + tileX);
                if(mapData !=0){
                    Tile firstgidOfTile = tileList.stream().filter(tile -> tile.firstgid==mapData).findFirst().orElse(null);
                    if(firstgidOfTile !=null){
                        String pathTile = firstgidOfTile.findPath();
                        Platform platform = new Platform(pathTile,firstgidOfTile.name);
                        platform.position.set(tileX*Constant.Tile.TILE_WIDTH + Constant.Tile.TILE_WIDTH /2,tileY*Constant.Tile.TILE_HEIGHT + Constant.Tile.TILE_HEIGHT/2);
                        GameObjectManager.instance.add(platform);
                    }

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
