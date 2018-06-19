package game.player;

import base.FrameCounter;
import base.GameObject;

import base.Vector2D;
import game.Platform;
import physic.BoxCollider;
import physic.PhysicBody;
import physic.RunHitObject;
import renderer.ImageRenderer;

public class Player extends GameObject implements PhysicBody {
    protected Vector2D velocity;
    private PlayerMove playerMove;
    protected BoxCollider boxCollider;
    public RunHitObject runHitObject;
    protected boolean hitPlatformX = false;
    protected boolean hitPlatformY = false;


    public Player(){
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer("assets/images/white_square_tiny.png",10,10);
        this.boxCollider = new BoxCollider(10,10);
        this.playerMove = new PlayerMove();
        this.runHitObject = new RunHitObject(Platform.class);
    }

    public void run(){
        this.boxCollider.position.set(this.position.x-this.boxCollider.getWidth()/2, this.position.y- this.boxCollider.getHeight()/2);
//        if(this.hitPlatformX){
//            this.boxCollider.position.set(this.boxCollider.position.addUp(Math.signum(this.velocity.x)*2, 0)) ;
//            System.out.println(this.boxCollider.position.x);
//        }
//        if(this.hitPlatformY){
//            this.boxCollider.position.set(this.boxCollider.position.addUp(0,Math.signum(this.velocity.y)*2)) ;
////            System.out.println(this.boxCollider.position.y);
//        }
        this.playerMove.run(this);
        this.runHitObject.run(this);

    }



    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }

    @Override
    public void getHit(GameObject gameObject) {
        System.out.println("hit");
        this.isAlive = false;

    }
}
