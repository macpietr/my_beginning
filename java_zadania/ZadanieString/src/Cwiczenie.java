import java.util.Scanner;

public class Cwiczenie {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        StringBuilder stringBuilder = new StringBuilder();
        System.out.println("Podaj liczbę wyrazów");
        int n = in.nextInt();
        in.nextLine();
        String[] tablica = new String[n];
        for (int i=0;i<n;i++){
            System.out.println("Podaj stringa");
            tablica[i]=in.nextLine();
        }
        System.out.println("Twoje wyrazy:");
        for(String t: tablica){
            System.out.println(t);
        }
        for (int i=0;i<n;i++){
            stringBuilder.append(tablica[i].substring((tablica[i].length()-1)));
        }
        String result = stringBuilder.toString();
        System.out.println(result);
        in.close();
    }
}
