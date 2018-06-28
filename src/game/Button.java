package game;

import base.GameObject;
import base.Vector2D;
import constant.Constant;

import java.awt.*;

public class Button extends GameObject {
    private Color buttonColor;
    public String label;
    public int width, height;


    public Button( Vector2D position,int width, int height,Color buttonColor, String label){
        this.position = position;
        this.width = width;
        this.height = height;
        this.buttonColor = buttonColor;
        this.label = label;
    }

    @Override
    public void render(Graphics graphics) {
        graphics.setColor(this.buttonColor);
        graphics.fillRect((int)this.position.x- this.width/2,(int)this.position.y - this.height/2,width,height);
    }
}
