package source.kevtimov.starwarsapp.models.heroes;

import java.io.Serializable;

public class TheForceHero extends Hero implements Serializable{

    public int theForcePower;

    public TheForceHero(){
    //default
    }

    public TheForceHero(String name, String type, String info, String heroImage, int theForcePower) {
        super(name, type, info, heroImage);
        this.theForcePower = theForcePower;
    }



    @Override
    public String toString(){
        return String.format("%s", getName());
    }

    public int getTheForcePower() {
        return theForcePower;
    }
}
