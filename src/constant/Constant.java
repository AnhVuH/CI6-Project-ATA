package constant;

import java.util.Arrays;
import java.util.List;

public class Constant {
    public static class Window{
        public static final int WIDTH = 900;
        public static final int HEIGHT = 660;
    }

    public static class Canvas{
        public static final int WIDTH = 1560;
        public static final int HEIGHT =660;
    }

    public static class Speed{
        public static final float GRAVITY = 1f;
        public static final float FLY_SPEED = 1.5f;
        public static final float HORIZONTAL_SPEED = 2f;
        public static final int DELAY_VERTICAL = 6;
        public static final float DEAD_VELOCIY = 4.5f;

    }

    public static  class Tile{
        public static final int WIDTH = 26;
        public static final int HEIGHT = 26;
    }

    public static class Player{
        public static final int WIDTH = 40;
        public static final int HEIGHT = 40;
    }

    public static class Gift{
        public static final int WIDTH = 20;
        public static final int HEIGHT= 20;
    }

    public static class Station{
        public static final int WIDTH = 80;
        public static final int HEIGHT= 40;
    }

    public static class Scene{
        public static final String[] ARRAY_PATH_SCENE = {"assets/maps/ATA-MAPS/atamap1.1.json",
                "assets/maps/ATA-MAPS/atamap1.1.json",
//                "assets/maps/ATA-MAPS/atamap2.json",
//                "assets/maps/ATA-MAPS/atamap3.json"
                };

    }

    public static class Button{
        public static final String START ="Start Button";
        public static final String REPLAY_ALL= "Replay All";
        public static final String REPLAY_ONE= "Replay One";
        public static final String NEXT_SCENE= "Next Scene";
        public static final String SCORE= "SCORE";

    }


}
