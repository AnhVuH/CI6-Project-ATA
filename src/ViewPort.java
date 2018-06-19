import base.Vector2D;
import renderer.Renderer;

import java.awt.*;
import java.awt.geom.AffineTransform;

public class ViewPort  {
    public Vector2D position;
    public ViewPort(){
        this.position = new Vector2D();

    }


    public void translate(Graphics2D graphics2D) {
        AffineTransform affineTransform = new AffineTransform();
        affineTransform.translate(this.position.x,this.position.y );
        graphics2D.setTransform(affineTransform);

    }
}
