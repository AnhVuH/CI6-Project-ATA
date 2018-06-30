package game.player;

import base.FrameCounter;
import base.GameObject;

import base.GameObjectManager;
import base.Vector2D;
import constant.Constant;
import game.gift.GiftTaker;
import game.platform.Platform;

import game.platform.StartStation;
import game.platform.Station;
import physic.BoxCollider;
import physic.PhysicBody;

import physic.RunHitObject;
import renderer.ImageRenderer;
import scene.GameOverScene;
import scene.SceneManager;

public class DeadPlayer extends Player implements PhysicBody {
    private final float GRAVITY = 1f;
    protected Vector2D velocity;
    protected BoxCollider boxCollider;
    private DeadPlayerCheckMove deadPlayerCheckMove;
    private FrameCounter frameCounter;
    private RunHitObject runHitObject;

    public DeadPlayer(){
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer("assets/images/ufo-dead.png",Constant.Player.WIDTH,Constant.Player.HEIGHT);
        this.boxCollider = new BoxCollider(Constant.Player.WIDTH,Constant.Player.HEIGHT);
        this.deadPlayerCheckMove = new DeadPlayerCheckMove();
        this.frameCounter = new FrameCounter(10);
        this.runHitObject = new RunHitObject(Platform.class, Station.class,StartStation.class);
    }


    public void run(){
        this.boxCollider.position.set(this.position.x-this.boxCollider.getWidth()/2, this.position.y- this.boxCollider.getHeight()/2);
        if (frameCounter.run()) {
            this.velocity.y += GRAVITY;
            this.frameCounter.reset();
        }
        GiftTaker giftTaker =GameObjectManager.instance.findObjectAlive(GiftTaker.class);
        if(giftTaker!=null){
            giftTaker.isAlive=false;
        }
        this.deadPlayerCheckMove.run(this);
        this.runHitObject.run(this);
    }




    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }

    @Override
    public void getHit(GameObject gameObject) {
        SceneManager.instance.changeScene(new GameOverScene());

    }
}
