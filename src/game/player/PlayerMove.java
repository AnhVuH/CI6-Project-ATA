package game.player;

import base.FrameCounter;
import base.GameObjectManager;
import game.Platform;
import input.KeyboardInput;
import physic.BoxCollider;

public class PlayerMove {
    private final float GRAVITY = 1f;
    private final float FLYSPEED =1.5f;
    private final float HORIZONTALSPEED = 2f;

    private FrameCounter frameCounter;

    public PlayerMove() {
        this.frameCounter = new FrameCounter(8);
    }

    public void run(Player player) {
        if (frameCounter.run()) {
            player.velocity.y += GRAVITY;
            if (KeyboardInput.instance.upPressed) {
                player.velocity.y += -FLYSPEED;
            }
            this.frameCounter.reset();
        }


        player.velocity.x = 0;

        if (KeyboardInput.instance.leftPressed ) {
            player.velocity.x = -HORIZONTALSPEED;
        }

        if (KeyboardInput.instance.rightPressed) {
            player.velocity.x = HORIZONTALSPEED;
        }
        this.moveHorizontal(player);
        this.moveVertical(player);
    }


    private void moveHorizontal(Player player) {
        BoxCollider nextBoxCollider = player.boxCollider.shift(player.velocity.x, 0);

        Platform platform = GameObjectManager.instance.checkCollision(nextBoxCollider, Platform.class);

        if (platform != null) {
            boolean moveContinue = true;
            float shiftDistance = Math.signum(player.velocity.x);
            while (moveContinue) {
                if (GameObjectManager.instance.checkCollision(player.boxCollider.shift(shiftDistance, 0), Platform.class) != null) {
                    moveContinue = false;
                    player.boxCollider.position.set(player.boxCollider.position.add(Math.signum(shiftDistance), 0)) ;
                } else {
                    shiftDistance += Math.signum(player.velocity.x);
                    player.position.addUp(Math.signum(player.velocity.x), 0);
                }
            }
            player.velocity.x = 0;
        }
        player.position.x += player.velocity.x;

    }

    private void moveVertical(Player player) {
        BoxCollider nextBoxCollider = player.boxCollider.shift(0, player.velocity.y);

        Platform platform = GameObjectManager.instance.checkCollision(nextBoxCollider, Platform.class);

        if (platform != null) {
            boolean moveContinue = true;
            float shiftDistance = Math.signum(player.velocity.y );
            while (moveContinue ) {
                if (GameObjectManager.instance.checkCollision(player.boxCollider.shift(0, shiftDistance), Platform.class) != null) {
                    moveContinue = false;
                    player.boxCollider.position.set(player.boxCollider.position.addUp(0,Math.signum(shiftDistance))) ;

                } else {
                    shiftDistance += Math.signum(player.velocity.y );
                    player.position.addUp(0, Math.signum(player.velocity.y ));
                }
            }
            player.velocity.y = 0;
        }
        player.position.y += player.velocity.y;
    }

}


