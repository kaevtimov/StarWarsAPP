package source.kevtimov.starwarsapp.models;

public class DarkSideHero {
    public String name;
    public String type;
    public String info;

    public DarkSideHero(){
        //default
    }

    public DarkSideHero(String name, String type, String info){
        this.name = name;
        this.type = type;
        this.info = info;
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
