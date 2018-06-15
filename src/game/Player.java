package game;

import base.FrameCounter;
import base.GameObject;
import base.GameObjectManager;
import base.Vector2D;
import input.KeyboardInput;
import physic.BoxCollider;
import physic.PhysicBody;
import renderer.ImageRenderer;

public class Player extends GameObject implements PhysicBody {
    private Vector2D velocity;
    private final float GRAVITY = 1f;

    private final float FLYSPEED = 3f;
    private FrameCounter frameCounter = new FrameCounter(25);

    public BoxCollider boxCollider;

    public Player(){
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer("assets/images/white_square_tiny.png",10,10);
        this.boxCollider = new BoxCollider(10,10);
    }

    public void run(){
        this.boxCollider.position.set(this.position.x-this.boxCollider.getWidth()/2, this.position.y- this.boxCollider.getHeight()/2);

        if(KeyboardInput.instance.upPressed){
            if(this.frameCounter.run()){
                this.velocity.addUp(0,GRAVITY-FLYSPEED );
                this.frameCounter.reset();
            }
        }
        else{
            this.velocity.addUp(0,GRAVITY);
        }
        System.out.println(this.velocity.y);

        this.moveVertical();
        this.position.addUp(this.velocity);
    }

    private void moveVertical(){
        BoxCollider nextBoxCollider = this.boxCollider.shift(0, this.velocity.y);
//        System.out.println("nextBox:" + nextBoxCollider.position.y);

        Platform platform = GameObjectManager.instance.checkCollision(nextBoxCollider,Platform.class);

        if(platform !=null){
            boolean moveContinue = true;
            float shiftDistance = 1;
            while(moveContinue) {
//                System.out.println("distance :"+shiftDistance);
                if(GameObjectManager.instance.checkCollision(this.boxCollider.shift(0, shiftDistance),Platform.class) !=null){
                    moveContinue = false;
                }
                else{
                    shiftDistance++;
                    this.position.addUp(0,1);
                }
            }
            this.velocity.y = 0;
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
