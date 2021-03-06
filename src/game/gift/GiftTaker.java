package game.gift;

import base.FrameCounter;
import base.GameObject;
import base.GameObjectManager;
import constant.Constant;
import game.player.Player;
import physic.BoxCollider;
import physic.PhysicBody;
import physic.RunHitObject;
import renderer.ImageRenderer;
import scene.setupScene.DisplayNumberOfGift;
import utils.Utils;

import javax.sound.sampled.Clip;
import java.awt.*;

public class GiftTaker extends GameObject implements PhysicBody {
    public BoxCollider boxCollider;
    public RunHitObject runHitObject;
    private FrameCounter frameCounter = new FrameCounter(4);
    private Clip gift;
    public GiftTaker(){
        this.renderer = new ImageRenderer("assets/images/yellow_square.jpg", Constant.GiftTaker.WIDTH, Constant.GiftTaker.HEIGHT);
        this.boxCollider = new BoxCollider(Constant.GiftTaker.WIDTH, Constant.GiftTaker.HEIGHT);
        this.runHitObject= new RunHitObject(Gift.class);
        this.gift = Utils.loadAudio("assets/audio/gift.wav");
    }

    @Override
    public void run() {
        super.run();
        this.boxCollider.position.set(this.position.x-this.boxCollider.getWidth()/2, this.position.y- this.boxCollider.getHeight()/2);
        this.runHitObject.run(this);

    }

    @Override
    public void render(Graphics graphics) {
        if(frameCounter.run()){
            frameCounter.reset();
            return;
        }
        super.render(graphics);
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }

    @Override
    public void getHit(GameObject gameObject) {
        if(gameObject instanceof Gift){
            this.gift.loop(0);
            this.gift.start();
            GameObjectManager.instance.add(new DisplayNumberOfGift());
        }


    }
}
