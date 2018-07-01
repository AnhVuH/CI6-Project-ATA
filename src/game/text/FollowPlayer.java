package game.text;

import constant.Constant;

public class FollowPlayer {
    public float run(float playerPositionX, float offsetX){
        int maxOffsetX= Constant.Canvas.WIDTH - Constant.Window.WIDTH;
        float positionX =0 ;


        if(playerPositionX < Constant.Window.WIDTH/2){
            positionX = offsetX;
        }
         else if( playerPositionX > Constant.Canvas.WIDTH - Constant.Window.WIDTH/2)
        {
            positionX = maxOffsetX +offsetX;
        }
        else{
            positionX = playerPositionX - Constant.Window.WIDTH/2 + offsetX;
        }


        return positionX;
    }
}
