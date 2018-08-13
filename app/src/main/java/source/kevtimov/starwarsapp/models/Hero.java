package source.kevtimov.starwarsapp.models;

import java.io.Serializable;

public abstract class Hero implements Serializable{
    public String name;
    public String type;
    public String info;
    public int heroImage;

    public Hero(){
        //default
    }

    public Hero(String name, String type, String info, int heroImage){
        this.name = name;
        this.type = type;
        this.info = info;
        this.heroImage = heroImage;
    }

    public int getHeroImage() {
        return heroImage;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getInfo() {
        return info;
    }

    @Override
    public String toString(){
        return String.format("%s", getName());
    }

}
