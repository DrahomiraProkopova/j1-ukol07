package cz.czechitas.ukol7.barvy;

public enum Barvy {
    ZLUTA("žlutá"),
    CERVENA("červená"),
    MODRA("modrá"),;

    private final String text;

    Barvy(String text){
        this.text = text;
    }

    public String getText(){
        return text;
    }

}
