package game.player;

import base.FrameCounter;
import base.GameObject;

import base.GameObjectManager;
import base.Vector2D;
import game.Platform;

import physic.BoxCollider;
import physic.PhysicBody;

import renderer.ImageRenderer;

public class DeadPlayer extends GameObject implements PhysicBody {
    private final float GRAVITY = 1f;
    protected Vector2D velocity;
    protected BoxCollider boxCollider;
    private FrameCounter frameCounter;
    public DeadPlayer(){
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer("assets/images/white_square_tiny.png",10,10);
        this.boxCollider = new BoxCollider(10,10);
        this.frameCounter = new FrameCounter(10);
    }


    public void run(){
        this.boxCollider.position.set(this.position.x-this.boxCollider.getWidth()/2, this.position.y- this.boxCollider.getHeight()/2);
        if (frameCounter.run()) {
            this.velocity.y += GRAVITY;
            this.frameCounter.reset();
        }
        this.moveVertical(this);
    }

    private void moveVertical(DeadPlayer player) {
        BoxCollider nextBoxCollider = player.boxCollider.shift(0, player.velocity.y);

        Platform platform = GameObjectManager.instance.checkCollision(nextBoxCollider, Platform.class);

        if (platform != null) {
            boolean moveContinue = true;
            float shiftDistance = Math.signum(player.velocity.y );
            while (moveContinue ) {
                if (GameObjectManager.instance.checkCollision(player.boxCollider.shift(0, shiftDistance), Platform.class) != null) {
                    moveContinue = false;

                } else {
                    shiftDistance += Math.signum(player.velocity.y );
                    player.position.addUp(0, Math.signum(player.velocity.y ));
                }
            }
            player.velocity.y = 0;
        }
        player.position.y += player.velocity.y;
    }

    @Override
    public BoxCollider getBoxCollider() {
        return null;
    }

    @Override
    public void getHit(GameObject gameObject) {

    }
}
