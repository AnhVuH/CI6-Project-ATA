package game.player;


import base.GameObject;

import base.GameObjectManager;
import base.Vector2D;
import constant.Constant;
import game.gift.Gift;
import game.platform.Platform;
import game.platform.StartStation;
import game.platform.Station;
import physic.BoxCollider;
import physic.PhysicBody;
import physic.RunHitObject;
import renderer.ImageRenderer;
import scene.GameWinScene;
import scene.SceneManager;
import scene.SceneSpawner;
import scene.setupScene.DisplayNumberOfGift;

public class Player extends GameObject implements PhysicBody {
    protected Vector2D velocity;
    protected PlayerMove playerMove;
    protected BoxCollider boxCollider;
    public RunHitObject runHitObject;



    public Player(){
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer("assets/images/ufo.png",Constant.Player.WIDTH,Constant.Player.HEIGHT);
//        this.renderer = new ImageRenderer("assets/images/_ufo__by_mrichston_zpsgr01l96i.gif",Constant.Player.WIDTH,Constant.Player.HEIGHT);
        this.boxCollider = new BoxCollider(Constant.Player.WIDTH,Constant.Player.HEIGHT);
        this.playerMove = new PlayerMove();
        this.runHitObject = new RunHitObject(
                Platform.class,
                Station.class,
                StartStation.class,
                Gift.class);
    }



    public void run(){
        super.run();
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
        //kiểm tra nếu chạm vào platform là chết
        if(gameObject instanceof Platform){
            this.isAlive = false;
            DeadPlayer deadPlayer = GameObjectManager.instance.recycle(DeadPlayer.class);
            deadPlayer.position.set(this.position);
        }
        else if(gameObject instanceof Station|| gameObject instanceof Gift ||gameObject instanceof StartStation){
            //nếu va chạm với gift hoặc station theo phương ngang hoặc theo phương dọc nhưng tốc độ quá lớn cũng chêt
            if(playerMove.curentVelocity.x !=0 || playerMove.curentVelocity.y >Constant.Speed.DEAD_VELOCIY){

                this.isAlive = false;
                DeadPlayer deadPlayer = GameObjectManager.instance.recycle(DeadPlayer.class);
                deadPlayer.position.set(this.position);
            }
            else{

                if(gameObject instanceof Gift){
                    // nếu đáp xuống lấy quà quá lệch ->chết
                    if(this.position.x < gameObject.position.x- Constant.Gift.WIDTH/2
                            || this.position.x > gameObject.position.x + Constant.Gift.WIDTH/2 ){
                        this.isAlive = false;
                        DeadPlayer deadPlayer = GameObjectManager.instance.recycle(DeadPlayer.class);
                        deadPlayer.position.set(this.position);
                    }
                    //sau khi lấy được 1 gift thì đếm và hiển thị lại số gift cần lấy
                    else{
                        GameObjectManager.instance.add(new DisplayNumberOfGift());
                    }

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
                            new SceneSpawner();
                        }
                    }


                }

            }

        }

    }
}
