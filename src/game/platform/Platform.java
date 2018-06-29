package game.platform;

import base.GameObject;
import constant.Constant;
import physic.BoxCollider;
import physic.PhysicBody;
import renderer.ImageRenderer;


public class Platform extends GameObject implements PhysicBody {

    private BoxCollider boxCollider;
    public String name;


    public Platform(String path, String name) {
        this.renderer = new ImageRenderer(path, Constant.Tile.WIDTH, Constant.Tile.HEIGHT);
        this.name = name;
        if(name.equals("left_angle")|| name.equals("right_angle")){
            this.boxCollider = new BoxCollider(Constant.Tile.WIDTH/2,Constant.Tile.HEIGHT/2);
        }
        else{
            this.boxCollider = new BoxCollider(Constant.Tile.WIDTH, Constant.Tile.HEIGHT);
        }

    }

    public void run(){
        super.run();
        if(name.equals("left_angle")){
            this.boxCollider.position.set(this.position.x , this.position.y - this.boxCollider.getHeight()/ 2);
        }
        else {
            this.boxCollider.position.set(this.position.x - this.boxCollider.getWidth() / 2, this.position.y - this.boxCollider.getHeight() / 2);
        }
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }

    @Override
    public void getHit(GameObject gameObject) {

    }
}
