package maps;

import com.google.gson.Gson;
import utils.Utils;

import java.util.List;

public class Map {
    // các tên thuộc tính phải trùng với các key trong file json
    public List<Layer> layers;
    public List<Tile> tilesets;

    public void generate(){
        if(layers.size()>0){
            Layer layer = layers.get(0);
            layer.generate(this.tilesets);
        }
    }

    public static Map load(String url){
        String mapContent = Utils.readTextFile(url);
        Gson gson = new Gson();
        return gson.fromJson(mapContent, Map.class);

    }


}
