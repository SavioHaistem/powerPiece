package entities;

import entities.models.LifeBar;
import interfaces.AtackableEntity;

public class Player extends Entity {

    public Player(Integer maxLife, LifeBar lifeBar, String name) {
        super(lifeBar, name);
    }

    @Override
    public void atack(Entity entity,int damage) {

    }

    @Override
    public String say(String sayed) {
        return null;
    }
}
