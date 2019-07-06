package io;
import data.Patient;

public class Hospital {
    private int n=0;
    private Patient[] kolejka = new Patient[10];
    public Hospital(){};

    public void getKolejka(){
        System.out.println(kolejka[1].getImie()+" "+kolejka[1].getNazwisko());
    }

    public void dodajDoKolejki(){
        if(n<kolejka.length){
            kolejka[n] = new Patient();
            kolejka[n]=kolejka[n].nowyPacjent();
            n++;
        }
        else {
            System.out.println("Limit został osiągnięty.");
        }
    }

    public void wyswietl(){
        int m = 1;
        for (int i=0;i<n;i++) {
            if (n==0) {
                System.out.println("Nic tu nie ma");
            }
            else {
                System.out.println(m + ". " + kolejka[i].getImie() + " " + kolejka[i].getNazwisko() + "; " + kolejka[i].getPesel());
            }
        }
    }
}


