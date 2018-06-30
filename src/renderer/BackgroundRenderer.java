package renderer;

import base.Vector2D;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class BackgroundRenderer implements Renderer {
    private BufferedImage image;
    private int width;
    private int height;
    private Color color;
    private String path;

//    public BackgroundRenderer(Color color, int width, int height){
//        this.color = color;
//        this.width = width;
//        this.height = height;
//    }
    public BackgroundRenderer(String path, int width, int height){
        this.width = width;
        this.height = height;
        this.image = this.loadImage(path);
        this.path = path;
    }
    public void render(Graphics graphics, Vector2D position){
//        graphics.setColor(color);
//        graphics.fillRect((int)position.x, (int)position.y,this.width, this.height);
        graphics.drawImage(this.image,0,0,this.width,this.height,null);
    }

    private BufferedImage loadImage(String path) {
        try {
            return ImageIO.read(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
