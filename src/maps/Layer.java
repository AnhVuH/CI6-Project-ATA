package maps;

import base.GameObjectManager;
import constant.Constant;
import game.platform.Platform;

import java.util.List;

public class Layer {
    //các tên thuộc tính phải trùng với tên các trường trong trường layers của file json
    private List<Integer> data; // mảng 1 chiều lưu các id firstgid
    private int width; // chiều rộng của map tính bằng số tile
    private int height;

    public void generate(List<Tile> tileList) {
        for(int tileY =0; tileY < this.height; tileY++){
            for(int tileX =0; tileX< this.width; tileX++){
                int mapData = data.get(tileY * this.width + tileX);
                if(mapData !=0){
                    // tìm các tile có id trùng với vị trí đang xét trong map
                    Tile firstgidOfTile = tileList.stream().filter(tile -> tile.firstgid==mapData).findFirst().orElse(null);
                    if(firstgidOfTile !=null){
                        //tìm link file ảnh của tile
                        String pathTile = firstgidOfTile.findPath();
                        //tạo 1 platform tương ứng với tile
                        Platform platform = new Platform(pathTile,firstgidOfTile.name);
                        platform.position.set(tileX*Constant.Tile.WIDTH + Constant.Tile.WIDTH /2,tileY*Constant.Tile.HEIGHT + Constant.Tile.HEIGHT/2);
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
