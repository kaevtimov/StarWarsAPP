package source.kevtimov.starwarsapp.models;

import java.io.Serializable;

public class DarkSideHero extends Hero implements Serializable{

    public int darkSideAnger;

    public DarkSideHero(){
        //default
    }

    public DarkSideHero(String name, String type, String info, int darkSideAnger) {
        super(name, type, info);
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
