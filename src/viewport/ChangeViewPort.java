package viewport;

import base.GameObjectManager;
import constant.Constant;
import game.player.DeadPlayer;
import game.player.Player;

public class ChangeViewPort {
    public void run(ViewPort viewPort){
        int maxOffsetX= Constant.Canvas.WIDTH - Constant.Window.WIDTH;
        int maxOffsetY = Constant.Canvas.HEIGHT - Constant.Window.HEIGHT;
        int minOffsetX =0;
        int minOffsetY =0;
        float camPositionX =0 ;
        float camPositionY =0;
        DeadPlayer deadPlayer = GameObjectManager.instance.findObjectAlive(DeadPlayer.class);
        Player player = GameObjectManager.instance.findObjectAlive(Player.class);


        if(player!=null){
            camPositionX = player.position.x- Constant.Window.WIDTH/2;
            camPositionY = player.position.y - Constant.Window.HEIGHT/2;
        }
        else if(deadPlayer!=null) {
            camPositionX = deadPlayer.position.x- Constant.Window.WIDTH/2;
            camPositionY = deadPlayer.position.y - Constant.Window.HEIGHT/2;
        }

        if(camPositionX > maxOffsetX){
            camPositionX = maxOffsetX;
        }
        else if(camPositionX < minOffsetX){
            camPositionX = minOffsetX;
        }
        if(camPositionY > maxOffsetY){
            camPositionY = maxOffsetY;
        }
        else if(camPositionY < minOffsetY){
            camPositionY = minOffsetY;
        }

        viewPort.position.set(-camPositionX,-camPositionY);
    }
}
