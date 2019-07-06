import java.io.Serializable;
import java.math.BigInteger;
import java.util.Scanner;

public class DataReader implements Serializable {

    private String number;

    private Scanner in = new Scanner(System.in);

    public BigInteger setNumber(){
        System.out.println("Podaj liczbę:");
        this.number = in.nextLine();
        return new BigInteger(this.number);
    }

    public String getNumber(){
        return number;
    }
}