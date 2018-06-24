package game.player;

import base.GameObjectManager;
import game.platform.Platform;
import game.Station;
import physic.BoxCollider;

public class PlayerCheckMoveHorizontal {
    public void run(Player player) {
        this.checkMove(player,Platform.class);
        this.checkMove(player, Station.class);
        player.position.x += player.velocity.x;

    }

    private void checkMove(Player player,Class cls){
        BoxCollider nextBoxCollider = player.boxCollider.shift(player.velocity.x, 0);
        if (GameObjectManager.instance.checkCollision(nextBoxCollider, cls) != null) {
            player.playerMove.curentVelocity.x = player.velocity.x;
            boolean moveContinue = true;
            float shiftDistance = Math.signum(player.velocity.x);
            while (moveContinue) {
                if (GameObjectManager.instance.checkCollision(player.boxCollider.shift(shiftDistance, 0), cls) != null) {
                    moveContinue = false;
                    player.boxCollider.position.addUp(shiftDistance, 0) ;
                } else {
                    shiftDistance += Math.signum(player.velocity.x);
                    player.position.addUp(Math.signum(player.velocity.x), 0);
                }
            }
            player.velocity.x = 0;
        }
    }
}
