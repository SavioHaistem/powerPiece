package entities.akumanomis;

import enums.AkumasType;

public class Smile extends AkumaNoMi {

    public Smile(String name, AkumasType type, Integer id) {
        super(name, type, id);
        type = AkumasType.SMILE;
    }
}