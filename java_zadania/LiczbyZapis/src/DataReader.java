import java.util.Scanner;

public class DataReader {

    private int number;

    private Scanner in = new Scanner(System.in);

    public int setNumber(){
        System.out.println("Podaj liczbę:");
        this.number = in.nextInt();
        in.nextLine();
        return this.number;
    }

    public int getNumber(){
        return number;
    }
}