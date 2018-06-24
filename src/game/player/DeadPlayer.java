package game.player;

import base.FrameCounter;
import base.GameObject;

import base.Vector2D;
import constant.Constant;
import game.platform.Platform;

import game.Station;
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
        this.renderer = new ImageRenderer("assets/maps/ATA-MAPS/ufo-dead.png",Constant.Player.PLAYER_WIDTH,Constant.Player.PLAYER_HEIGHT);
        this.boxCollider = new BoxCollider(Constant.Player.PLAYER_WIDTH,Constant.Player.PLAYER_HEIGHT);
        this.deadPlayerCheckMove = new DeadPlayerCheckMove();
        this.frameCounter = new FrameCounter(10);
        this.runHitObject = new RunHitObject(Platform.class, Station.class);
    }


    public void run(){
        this.boxCollider.position.set(this.position.x-this.boxCollider.getWidth()/2, this.position.y- this.boxCollider.getHeight()/2);
        if (frameCounter.run()) {
            this.velocity.y += GRAVITY;
            this.frameCounter.reset();
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
