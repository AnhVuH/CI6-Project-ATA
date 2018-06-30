package game.player;

import base.FrameCounter;

import base.Vector2D;
import constant.Constant;
import input.KeyboardInput;
import utils.Utils;

import javax.sound.sampled.Clip;

public class PlayerMove {
    private final float GRAVITY = Constant.Speed.GRAVITY;
    private final float FLY_SPEED = Constant.Speed.FLY_SPEED;
    private final float HORIZONTAL_SPEED = Constant.Speed.HORIZONTAL_SPEED;
    private PlayerCheckMoveVertical playerCheckMoveVertical;
    private PlayerCheckMoveHorizontal playerCheckMoveHorizontal;
    public Vector2D curentVelocity;
    public Clip fly;


    private FrameCounter frameCounter;


    public PlayerMove() {

        this.frameCounter = new FrameCounter(Constant.Speed.DELAY_VERTICAL);

        this.playerCheckMoveHorizontal = new PlayerCheckMoveHorizontal();
        this.playerCheckMoveVertical = new PlayerCheckMoveVertical();
        this.curentVelocity = new Vector2D();
        this.fly = Utils.loadAudio("assets/audio/Satellite noise 2.wav");
    }

    public void run(Player player) {
        if (frameCounter.run()) {
            player.velocity.y += GRAVITY;
            if (KeyboardInput.instance.upPressed) {
                player.velocity.y += -FLY_SPEED;
                this.fly.loop(-1);
                this.fly.start();
            }
            else{
                this.fly.stop();
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


