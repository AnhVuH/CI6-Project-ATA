package game.platform;

import base.GameObject;
import base.Vector2D;
import constant.Constant;
import physic.BoxCollider;
import physic.PhysicBody;
import renderer.ImageRenderer;

public class StartStation  extends GameObject implements PhysicBody {
    public BoxCollider boxCollider;
    public StartStation(){

        this.renderer = new ImageRenderer("assets/images/grey_rect.png", Constant.Station.WIDTH, Constant.Station.HEIGHT);
        this.boxCollider = new BoxCollider(Constant.Station.WIDTH, Constant.Station.HEIGHT);
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
