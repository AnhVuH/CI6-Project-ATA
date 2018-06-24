package game.player;

import base.GameObjectManager;
import game.platform.Platform;
import game.Station;
import physic.BoxCollider;

public class DeadPlayerCheckMove {
    public void run(DeadPlayer player) {
        this.checkMove(player, Platform.class);
        this.checkMove(player, Station.class);
        player.position.y += player.velocity.y;

    }

    private void checkMove(DeadPlayer player,Class cls){
        BoxCollider nextBoxCollider = player.boxCollider.shift(0, player.velocity.y);
        if(GameObjectManager.instance.checkCollision(nextBoxCollider, cls) !=null){
            boolean moveContinue = true;
            float shiftDistance = 1;
            while (moveContinue ) {
                if (GameObjectManager.instance.checkCollision(player.boxCollider.shift(0, shiftDistance), cls) != null) {
                    moveContinue = false;
                    player.boxCollider.position.addUp(0,shiftDistance) ;

                } else {
                    shiftDistance += 1;
                    player.position.addUp(0, 1);
                }
            }
            player.velocity.y = 0;
        }

    }
}
