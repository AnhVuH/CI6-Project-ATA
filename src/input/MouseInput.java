package input;


import base.GameObjectManager;
import base.Vector2D;
import game.Button;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

public class MouseInput implements MouseListener {
    public static MouseInput instance = new MouseInput();
    public boolean clicked;
    public Vector2D positionClicked;



    @Override
    public void mouseClicked(MouseEvent e) {
        this.clicked = true;
        this.positionClicked = new Vector2D(e.getX(), e.getY());


    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {


    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public void checkMouseClicked(){
        List<Button> buttonList = GameObjectManager.instance.findButton();
        if(buttonList.size()>0){
            buttonList.forEach(button -> {
                float leftEdge = button.position.x - button.width/2;
                float rightEdge = button.position.x + button.width/2;
                float topEdge = button.position.y - button.height/2;
                float bottomEdge = button.position.y + button.height/2;
                if(
                        leftEdge<this.positionClicked.x
                        && this.positionClicked.x < rightEdge
                        && topEdge< this.positionClicked.y
                        && this.positionClicked.y< bottomEdge
                        )
                {
                    System.out.println(button.label);
                    ClickButtonReact.instance.run(button.label);

                }

            });
        }
//        this.clicked = false;



    }

}
