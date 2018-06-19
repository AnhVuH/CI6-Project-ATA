package game;

import base.GameObject;
import renderer.BackgroundRenderer;
import renderer.ImageRenderer;

import java.awt.*;

public class Background extends GameObject {
    public final int MAPWIDTH= 1600;
    public final int MAPHEIGHT= 600;

    public Background() {

        this.renderer = new BackgroundRenderer(Color.BLACK,MAPWIDTH,MAPHEIGHT);
    }

    @Override
    public void render(Graphics graphics){

        super.render(graphics);
    }
}

