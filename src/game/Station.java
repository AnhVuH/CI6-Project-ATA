package game;

import base.GameObject;
import base.Vector2D;
import physic.BoxCollider;
import physic.PhysicBody;
import renderer.ImageRenderer;

public class Station extends GameObject implements PhysicBody {
    public BoxCollider boxCollider;
    public Station(){
        this.position = new Vector2D();
        this.renderer = new ImageRenderer("assets/images/grey_rect.png", 100, 50);
        this.boxCollider = new BoxCollider(100, 50);
    }

    @Override
    public void run(){
        super.run();
        this.boxCollider.position.set(this.position.x-this.boxCollider.getWidth()/2, this.position.y- this.boxCollider.getHeight()/2);
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }

    @Override
    public void getHit(GameObject gameObject) {

    }
}
