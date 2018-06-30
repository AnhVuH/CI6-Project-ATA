package base;

import game.Button;
import game.gift.GiftTaker;
import game.platform.Platform;
import game.player.Player;
import physic.BoxCollider;
import physic.PhysicBody;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameObjectManager {

    public static GameObjectManager instance = new GameObjectManager();

    private List<GameObject> list;
    private List<GameObject> tempList;

    private GameObjectManager() {
        this.list = new ArrayList<>();
        this.tempList = new ArrayList<>();
    }

    public void add(GameObject gameObject) {
        this.tempList.add(gameObject);
    }

    public void runAll() {
        this.list
                .stream()
                .filter(gameObject -> gameObject.isAlive)
                .forEach(gameObject -> gameObject.run());
        this.list.addAll(this.tempList);
        this.tempList.clear();
    }

    public void renderAll(Graphics graphics) {
        this.list
                .stream()
                .filter(gameObject -> gameObject.isAlive)
                .forEach(gameObject -> gameObject.render(graphics));
    }
    public Player findPlayer() {
        return (Player) this.list
                .stream()
                .filter(gameObject -> gameObject instanceof Player)
                .findFirst()
                .orElse(null);
    }



        public <T extends GameObject> T checkCollision(BoxCollider boxCollider, Class<T> cls){
            return (T) this.list.stream()
                    .filter(gameObject -> gameObject.isAlive)
                    .filter(gameObject -> cls.isInstance(gameObject))
                    .filter(gameObject -> gameObject instanceof PhysicBody)
                    .filter(gameObject -> {
                        BoxCollider other = ((PhysicBody)gameObject).getBoxCollider();
                        return boxCollider.checkBoxCollider(other);
                    })
                    .findFirst()
                    .orElse(null);

        }

        public  <T extends GameObject> T findObjectAlive(Class<T> cls){
            return (T) this.list.stream()
                    .filter(gameObject -> gameObject.isAlive)
                    .filter(gameObject -> cls.isInstance(gameObject))
                    .findFirst()
                    .orElse(null);
        }

    public  <T extends GameObject> long countObjectAlive(Class<T> cls) {
        return this.list.stream()
                .filter(gameObject -> gameObject.isAlive)
                .filter(gameObject -> cls.isInstance(gameObject))
                .count();
    }

        public List<Platform> findPlatformsByName(String name){
            List<Platform> platformList = new ArrayList<>();
            this.list
                    .stream()
                    .filter(gameObject -> gameObject instanceof Platform)
                    .filter(gameObject -> ((Platform)gameObject).name.equals(name)
                    )
                    .forEach(gameObject -> {
                        platformList.add((Platform)gameObject);

                    });
            return platformList;
        }


        public <T extends GameObject> T recycle(Class<T> cls){
            T object = this.findObjectAlive(cls);
            if (object!= null){
                object.isAlive = true;
            }
            else{
                try {
                    object = cls.newInstance();
                    this.add(object);
                } catch (InstantiationException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            return object;

        }

        public List<game.Button> findButton(){
        List<Button> listButton = new ArrayList<>();
        this.list.stream()
                .filter(gameObject -> gameObject instanceof game.Button)
                .forEach(gameObject ->
                listButton.add((game.Button)gameObject));
        return listButton;
        }


    public void clear(){
        this.list.clear();
        this.tempList.clear();
//        System.out.println(this.findObjectAlive(Platform.class));
    }


}
