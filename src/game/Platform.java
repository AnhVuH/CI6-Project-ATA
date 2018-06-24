package game;

import base.GameObject;
import constant.Constant;
import physic.BoxCollider;
import physic.PhysicBody;
import renderer.ImageRenderer;


public class Platform extends GameObject implements PhysicBody {

    private BoxCollider boxCollider;
    public String name;

    public Platform() {
        this.renderer = new ImageRenderer("assets/images/green_square.png", Constant.Tile.TILE_WIDTH, Constant.Tile.TILE_HEIGHT);
        this.boxCollider = new BoxCollider(Constant.Tile.TILE_WIDTH, Constant.Tile.TILE_HEIGHT );
    }
    public Platform(String path) {
        this.renderer = new ImageRenderer(path, Constant.Tile.TILE_WIDTH, Constant.Tile.TILE_HEIGHT);
        this.boxCollider = new BoxCollider(Constant.Tile.TILE_WIDTH, Constant.Tile.TILE_HEIGHT);
    }

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
