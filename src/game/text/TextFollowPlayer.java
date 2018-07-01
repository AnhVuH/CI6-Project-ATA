package game.text;

import base.GameObject;
import base.GameObjectManager;
import base.Vector2D;
import game.player.Player;
import renderer.TextRenderer;

import java.awt.*;

public class TextFollowPlayer extends GameObject {
    public  FollowPlayer followPlayer;
    public Vector2D offsetWithWindow;

    public TextFollowPlayer (String text, Color color, String path, int fontsize, Vector2D offsetWithWindow){
        this.renderer = new TextRenderer(text, color, path, fontsize);
        this.followPlayer = new FollowPlayer();
        this.offsetWithWindow = offsetWithWindow;
    }

    @Override
    public void run() {
        super.run();
        Player player =GameObjectManager.instance.findObjectAlive(Player.class);
        if(player!=null){
            this.position.y = this.offsetWithWindow.y;
            this.position.x = this.followPlayer.run(player.position.x,this.offsetWithWindow.x);
        }





    }
}
