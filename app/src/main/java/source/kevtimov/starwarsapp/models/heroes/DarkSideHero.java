package source.kevtimov.starwarsapp.models.heroes;

import java.io.Serializable;

public class DarkSideHero extends Hero implements Serializable{

    public int darkSideAnger;

    public DarkSideHero(){
        //default
    }

    public DarkSideHero(String name, String type, String info, String heroImage, int darkSideAnger) {
        super(name, type, info, heroImage);
        this.darkSideAnger = darkSideAnger;
    }

    public int getDarkSideAnger() {
        return darkSideAnger;
    }

    @Override
    public String toString(){
        return String.format("%s", getName());
    }
}
