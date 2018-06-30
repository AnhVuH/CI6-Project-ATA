package game.player;

import base.FrameCounter;

import base.Vector2D;
import constant.Constant;
import input.KeyboardInput;

public class PlayerMove {
    private final float GRAVITY = Constant.Speed.GRAVITY;
    private final float FLY_SPEED = Constant.Speed.FLY_SPEED;
    private final float HORIZONTAL_SPEED = Constant.Speed.HORIZONTAL_SPEED;
    private PlayerCheckMoveVertical playerCheckMoveVertical;
    private PlayerCheckMoveHorizontal playerCheckMoveHorizontal;
    public Vector2D curentVelocity;

    private FrameCounter frameCounter;


    public PlayerMove() {

        this.frameCounter = new FrameCounter(Constant.Speed.DELAY_VERTICAL);

        this.playerCheckMoveHorizontal = new PlayerCheckMoveHorizontal();
        this.playerCheckMoveVertical = new PlayerCheckMoveVertical();
        this.curentVelocity = new Vector2D();
    }

    public void run(Player player) {
        if (frameCounter.run()) {
            player.velocity.y += GRAVITY;
            if (KeyboardInput.instance.upPressed) {
                player.velocity.y += -FLY_SPEED;
            }
//            if(KeyboardInput.instance.spacePressed){
//                player.velocity.y = 0;
//            }
            this.frameCounter.reset();
        }

        player.velocity.x = 0;

            if (KeyboardInput.instance.leftPressed ) {
                player.velocity.x = -HORIZONTAL_SPEED;
            }

            if (KeyboardInput.instance.rightPressed) {
                player.velocity.x = HORIZONTAL_SPEED;
            }



        this.playerCheckMoveHorizontal.run(player);
        this.playerCheckMoveVertical.run(player);
    }





}


