package maps;

import com.google.gson.Gson;
import utils.Utils;

import java.util.List;

public class Map {
    public List<Layer> layers;

    public void generate(){
        if(layers.size()>0){
            Layer layer = layers.get(0);
            layer.generate();
        }
    }

    public static Map load(String url){
        String mapContent = Utils.readTextFile(url);
        Gson gson = new Gson();
        return gson.fromJson(mapContent, Map.class);
    }

}
