package data;
import java.util.Scanner;
public class Patient {

    private String imie;
    private String nazwisko;
    private int pesel;

    public Patient(){};

    public Patient(String imie,String nazwisko,int pesel){
        this.imie=imie;
        this.nazwisko=nazwisko;
        this.pesel=pesel;
    }

    private Scanner in = new Scanner(System.in);

    public String getImie(){
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko(){
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public int getPesel() {
        return pesel;
    }

    public void setPesel(int pesel) {
        this.pesel = pesel;
    }

    public Patient nowyPacjent(){
        System.out.println("Podaj imie");
        String imie=in.nextLine();
        System.out.println("Podaj nazwisko");
        String nazwisko=in.nextLine();
        System.out.println("Podaj pesel");
        int pesel=in.nextInt();
        return new Patient(imie,nazwisko,pesel);
    }


}
