package game.player;


import base.GameObject;

import base.GameObjectManager;
import base.Vector2D;
import constant.Constant;
import game.Gift;
import game.Platform;
import game.Station;
import physic.BoxCollider;
import physic.PhysicBody;
import physic.RunHitObject;
import renderer.ImageRenderer;

public class Player extends GameObject implements PhysicBody {
    protected Vector2D velocity;
    protected PlayerMove playerMove;
    protected BoxCollider boxCollider;
    public RunHitObject runHitObject;


    public Player(){
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer("assets/maps/ATA-MAPS/ufo.png",Constant.Player.PLAYER_WIDTH,Constant.Player.PLAYER_HEIGHT);
        this.boxCollider = new BoxCollider(Constant.Player.PLAYER_WIDTH,Constant.Player.PLAYER_HEIGHT);
        this.playerMove = new PlayerMove();
        this.runHitObject = new RunHitObject(Platform.class,Station.class,Gift.class);
    }

    public void run(){
        this.boxCollider.position.set(this.position.x-this.boxCollider.getWidth()/2, this.position.y- this.boxCollider.getHeight()/2);
        this.playerMove.run(this);
        this.runHitObject.run(this);
    }


    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }

    @Override
    public void getHit(GameObject gameObject) {
        if(gameObject instanceof Platform){
            this.isAlive = false;
            DeadPlayer deadPlayer = GameObjectManager.instance.recycle(DeadPlayer.class);
            deadPlayer.position.set(this.position);
        }
        else if(gameObject instanceof Station){
            if(playerMove.curentVelocity.x !=0 || playerMove.curentVelocity.y >Constant.Speed.DEAD_VELOCIY){
                System.out.println(playerMove.curentVelocity.x);
                System.out.println(playerMove.curentVelocity.y);
                this.isAlive = false;
                DeadPlayer deadPlayer = GameObjectManager.instance.recycle(DeadPlayer.class);
                deadPlayer.position.set(this.position);
            }
            else{
                System.out.println(playerMove.curentVelocity.y);
                System.out.println("safe");
            }

        }

    }
}
