package game.gift;

import base.GameObject;
import constant.Constant;
import game.player.Player;
import physic.BoxCollider;
import physic.PhysicBody;
import renderer.ImageRenderer;

public class Gift extends GameObject implements PhysicBody {
    BoxCollider boxCollider;
    public Gift(){
        this.renderer = new ImageRenderer("assets/images/yellow_square.jpg",Constant.Gift.WIDTH,Constant.Gift.HEIGHT);
        this.boxCollider = new BoxCollider(Constant.Gift.WIDTH,Constant.Gift.HEIGHT);

    }

    @Override
    public void run() {
        super.run();
        this.boxCollider.position.set(this.position.x-this.boxCollider.getWidth()/2, this.position.y- this.boxCollider.getHeight()/2);
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }

    @Override
    public void getHit(GameObject gameObject) {
        if(gameObject instanceof Player){
            this.isAlive = false;
        }

    }
}
