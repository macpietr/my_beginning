package app;


import io.Hospital;
import java.util.Scanner;

public class HospitalApp {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        Hospital hospital = new Hospital();
        int warunek1 = 1;
        while (warunek1 > 0) {
            System.out.println("0 - wyjście");
            System.out.println("1 - dopisanie pacjenta");
            System.out.println("2 - wyświetl kolejkę");

            int warunek2 = in.nextInt();
            switch (warunek2) {
                case 0:
                    warunek1 = warunek2;
                    break;
                case 1:
                    hospital.dodajDoKolejki();
                    break;
                case 2:
                    hospital.wyswietl();

                    break;
                default:
                    System.out.println("eee?");
                    break;
            }

        }
    in.close();
    }
}