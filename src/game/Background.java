package game;

import base.GameObject;
import renderer.BackgroundRenderer;
import renderer.ImageRenderer;

import java.awt.*;

public class Background extends GameObject {


    public Background() {

        this.renderer = new BackgroundRenderer(Color.BLACK, 1200,600 );
    }

    @Override
    public void render(Graphics graphics){

        super.render(graphics);
    }
}

