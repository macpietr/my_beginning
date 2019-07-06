import javax.swing.text.html.Option;

public enum Licznik1 {

    EXIT(0,"wyjdz"),
    SAVE(1,"zapisz"),
    READ(2,"wczytaj");


    private String description;
    private int value;

    private Licznik1(int value, String description){
        this.value=value;
        this.description=description;
    }

    public String getDescription() {
        return description;
    }

    public int getValue() {
        return value;
    }
    @Override
    public String toString(){
        return getValue()+" - "+getDescription();
    }

    static Licznik1 createFromInt(int option) {
        return Licznik1.values()[option];
    }
}
