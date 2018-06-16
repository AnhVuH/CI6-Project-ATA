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
    private final float GRAVITY = 0.5f;

    private final float FLYSPEED = 3.5f;
    private final float HORIZONTALSPEED = 3f;
    private FrameCounter frameCounter = new FrameCounter(10);

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
                this.velocity.y += GRAVITY-FLYSPEED;
                this.frameCounter.reset();
            }
        }
        else {
            this.velocity.y +=GRAVITY;
        }

        this.velocity.x=0;

        if(KeyboardInput.instance.leftPressed){
                this.velocity.x = -HORIZONTALSPEED;
        }

        if(KeyboardInput.instance.rightPressed){
                this.velocity.x = HORIZONTALSPEED;
        }

        this.moveHorizontal();
        this.moveVertical();
        this.position.addUp(this.velocity);
    }

    private void moveHorizontal() {
        BoxCollider nextBoxCollider = this.boxCollider.shift( this.velocity.x, 0);

        Wall wall = GameObjectManager.instance.checkCollision(nextBoxCollider,Wall.class);

        if(wall !=null){
            boolean moveContinue = true;
            float shiftDistance = this.velocity.x/Math.abs(this.velocity.x);
            while(moveContinue) {
                if(GameObjectManager.instance.checkCollision(this.boxCollider.shift(shiftDistance, 0),Platform.class) !=null){
                    moveContinue = false;
                }
                else{
                    shiftDistance += this.velocity.x/Math.abs(this.velocity.x);
                    this.position.addUp(this.velocity.x/Math.abs(this.velocity.x),0);
                }
            }
            this.velocity.x = 0;
        }

    }

    private void moveVertical(){
        BoxCollider nextBoxCollider = this.boxCollider.shift(0, this.velocity.y);
//        System.out.println("nextBox:" + nextBoxCollider.position.y);

        Platform platform = GameObjectManager.instance.checkCollision(nextBoxCollider,Platform.class);
        Wall wall = GameObjectManager.instance.checkCollision(nextBoxCollider,Wall.class);

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
        else if(wall != null){
            this.velocity.y =0;
//            KeyboardInput.instance.collide = true;
//            KeyboardInput.instance.upPressed = false;

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
