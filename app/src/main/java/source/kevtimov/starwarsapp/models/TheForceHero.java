package source.kevtimov.starwarsapp.models;

public class TheForceHero {


    public String name;
    public String type;
    public String info;

    public TheForceHero(){
        //default
    }

    public TheForceHero(String name, String type, String info){
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
