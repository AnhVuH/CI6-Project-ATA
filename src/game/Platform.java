package game;

import base.GameObject;
import physic.BoxCollider;
import physic.PhysicBody;
import renderer.ImageRenderer;


public class Platform extends GameObject implements PhysicBody {

    private BoxCollider boxCollider;
    public Platform() {
        this.renderer = new ImageRenderer("assets/images/green_square.png", 20, 20);
        this.boxCollider = new BoxCollider(20,20 );
    }

    public void run(){
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
