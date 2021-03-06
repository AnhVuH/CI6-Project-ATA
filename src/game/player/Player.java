package game.player;


import base.FrameCounter;
import base.GameObject;

import base.GameObjectManager;
import base.Vector2D;
import constant.Constant;
import game.gift.Gift;
import game.gift.GiftTaker;
import game.platform.Platform;
import game.platform.StartStation;
import game.platform.Station;
import input.KeyboardInput;
import physic.BoxCollider;
import physic.PhysicBody;
import physic.RunHitObject;
import renderer.ImageRenderer;
import scene.*;
import scene.setupScene.DisplayNumberOfGift;
import utils.Utils;

import javax.sound.sampled.Clip;

public class Player extends GameObject implements PhysicBody {
    protected Vector2D velocity;
    protected PlayerMove playerMove;
    protected BoxCollider boxCollider;
    public RunHitObject runHitObject;

    private Clip win;





    public Player(){
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer("assets/images/ufo.png",Constant.Player.WIDTH,Constant.Player.HEIGHT);

        this.boxCollider = new BoxCollider(Constant.Player.WIDTH,Constant.Player.HEIGHT);
        this.playerMove = new PlayerMove();
        this.runHitObject = new RunHitObject(
                Platform.class,
                Station.class,
                StartStation.class,
                Gift.class
               );
        this.win = Utils.loadAudio("assets/audio/win.wav");
    }



    public void run(){
        super.run();
        this.boxCollider.position.set(this.position.x-this.boxCollider.getWidth()/2, this.position.y- this.boxCollider.getHeight()/2);
        this.playerMove.run(this);
        this.runHitObject.run(this);
        if(KeyboardInput.instance.spacePressed){
            GiftTaker oldgiftTaker = GameObjectManager.instance.findObjectAlive(GiftTaker.class);
            if(oldgiftTaker!=null){
                oldgiftTaker.position = this.position.add(0,Constant.Player.HEIGHT/2+Constant.GiftTaker.HEIGHT/2);
            }
            else{
                GiftTaker giftTaker = GameObjectManager.instance.recycle(GiftTaker.class);
            giftTaker.position = this.position.add(0,Constant.Player.HEIGHT/2+Constant.GiftTaker.HEIGHT/2);
            }
        }
        else{
            GiftTaker oldgiftTaker = GameObjectManager.instance.findObjectAlive(GiftTaker.class);
            if(oldgiftTaker!=null){ oldgiftTaker.isAlive =false;
            }



        }
    }


    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }

    @Override
    public void getHit(GameObject gameObject) {
        //kiểm tra nếu chạm vào platform là chết
        if(gameObject instanceof Platform){
            this.playerMove.fly.stop();

            this.isAlive = false;
            DeadPlayer deadPlayer = GameObjectManager.instance.recycle(DeadPlayer.class);
            deadPlayer.position.set(this.position);
        }
        else if(gameObject instanceof Station|| gameObject instanceof Gift ||gameObject instanceof StartStation){
            this.playerMove.fly.stop();
            //nếu va chạm với gift hoặc station theo phương ngang hoặc theo phương dọc nhưng tốc độ quá lớn cũng chêt
            if(playerMove.curentVelocity.x !=0 || playerMove.curentVelocity.y >Constant.Speed.DEAD_VELOCIY){

                this.isAlive = false;
                DeadPlayer deadPlayer = GameObjectManager.instance.recycle(DeadPlayer.class);
                deadPlayer.position.set(this.position);
            }
            else{

                //đáp lệch station quá chêt
                if(this.position.x < gameObject.position.x- Constant.Station.WIDTH/2
                        || this.position.x  > gameObject.position.x + Constant.Station.WIDTH/2 )
                {
                    this.isAlive = false;
                    DeadPlayer deadPlayer = GameObjectManager.instance.recycle(DeadPlayer.class);
                    deadPlayer.position.set(this.position);
                }
                else {
                    // đáp vào station cuối sau khi đã ăn hết quà thì qua bài mới
                    if(gameObject instanceof Station && GameObjectManager.instance.findObjectAlive(Gift.class)==null){
                        this.playerMove.fly.stop();
                        GamePlayScene.playTime = System.currentTimeMillis()/1000 - GamePlayScene.startTime;
                        GamePlayScene.totalPlayTime +=GamePlayScene.playTime;
                        this.win.loop(0);
                        this.win.start();
                        SceneManager.instance.changeScene(new ChangeLevelScene());


                    }
                }
            }

        }



    }
}



//                if(gameObject instanceof Gift){
//                    // nếu đáp xuống lấy quà quá lệch ->chết
//                    if(this.position.x < gameObject.position.x- Constant.Gift.WIDTH/2
//                            || this.position.x > gameObject.position.x + Constant.Gift.WIDTH/2 ){
//                        this.isAlive = false;
//                        DeadPlayer deadPlayer = GameObjectManager.instance.recycle(DeadPlayer.class);
//                        deadPlayer.position.set(this.position);
//                    }
//                    //sau khi lấy được 1 gift thì đếm và hiển thị lại số gift cần lấy
//                    else{
//                        GameObjectManager.instance.add(new DisplayNumberOfGift());
//                    }
//
//                }
//                else{
                    //đáp lệch station quá chêt
//                    if(this.position.x < gameObject.position.x- Constant.Station.WIDTH/2
//                            || this.position.x  > gameObject.position.x + Constant.Station.WIDTH/2 )
//                    {
//                        this.isAlive = false;
//                        DeadPlayer deadPlayer = GameObjectManager.instance.recycle(DeadPlayer.class);
//                        deadPlayer.position.set(this.position);
//                    }
//                    else {
//                        // đáp vào station cuối sau khi đã ăn hết quà thì qua bài mới
//                        if(gameObject instanceof Station && GameObjectManager.instance.findObjectAlive(Gift.class)==null){
//                                GamePlayScene.playTime = System.currentTimeMillis()/1000 - GamePlayScene.startTime;
//                                GamePlayScene.totalPlayTime +=GamePlayScene.playTime;
//
//                                SceneManager.instance.changeScene(new ChangeLevelScene());
//
//
//                        }
//                    }


//                }

//            }
//
//        }
//
//    }
//}
