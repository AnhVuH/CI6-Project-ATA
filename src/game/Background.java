package game;

import base.GameObject;
import constant.Constant;
import renderer.BackgroundRenderer;
import renderer.ImageRenderer;

import java.awt.*;

public class Background extends GameObject {
    public final int MAPWIDTH= Constant.Canvas.WIDTH;
    public final int MAPHEIGHT= Constant.Canvas.HEIGHT;

    public Background() {

        this.renderer = new BackgroundRenderer(Color.BLACK,MAPWIDTH,MAPHEIGHT);
    }

    @Override
    public void render(Graphics graphics){

        super.render(graphics);
    }
}

