package maps;

import com.google.gson.Gson;
import utils.Utils;

import java.util.List;

public class Map {
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
//        System.out.println(gson.fromJson(mapContent, Map.class).layers);
//        System.out.println(gson.fromJson(mapContent, Map.class).tilesets.get(0).source);
        return gson.fromJson(mapContent, Map.class);
    }


}
