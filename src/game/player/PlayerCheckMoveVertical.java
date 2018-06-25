package game.player;

import base.GameObjectManager;
import game.gift.Gift;
import game.platform.Platform;
import game.platform.StartStation;
import game.platform.Station;
import physic.BoxCollider;

public class PlayerCheckMoveVertical {
    public void run(Player player) {
        this.checkMove(player,Platform.class);
        this.checkMove(player,Station.class);
        this.checkMove(player,StartStation.class);
        this.checkMove(player, Gift.class);
        player.position.y += player.velocity.y;

    }

    private void checkMove(Player player,Class cls){
        BoxCollider nextBoxCollider = player.boxCollider.shift(0, player.velocity.y);
        if(GameObjectManager.instance.checkCollision(nextBoxCollider, cls) !=null){
            boolean moveContinue = true;

            player.playerMove.curentVelocity.y = player.velocity.y;

            float shiftDistance = Math.signum(player.velocity.y );
            while (moveContinue ) {
                if (GameObjectManager.instance.checkCollision(player.boxCollider.shift(0, shiftDistance), cls) != null) {
                    moveContinue = false;
                   player.boxCollider.position.addUp(0,shiftDistance);

                } else {
                    shiftDistance += Math.signum(player.velocity.y );
                    player.position.addUp(0, Math.signum(player.velocity.y ));
                }
            }
            player.velocity.y = 0;
        }

    }


}
