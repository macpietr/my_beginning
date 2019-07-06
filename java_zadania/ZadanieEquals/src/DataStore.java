
import java.util.Scanner;
public class DataStore {

    private static final int ILOSC=30;
    private int counter=0;
    Scanner in=new Scanner(System.in);
    Computer[] computers = new Computer[ILOSC];


    public void add(){
        System.out.println("Podaj producenta");
        String producer = in.nextLine();
        System.out.println("Podaj model");
        int model = in.nextInt();
        in.nextLine();
        computers[counter] = new Computer(producer,model);
        counter++;
    }

    public void printInfo(){
        for(int i=0;i<counter;i++){
            System.out.println(computers[i].toString());
        }
    }

    public void checkAvailability(){
        int licznik=0;
        for(int i=0;i<counter-1;i++){
            if(computers[i].equals(computers[i+1])) {
                licznik++;
            }
        }
        System.out.println("Tyle jest podobnych komputerów: "+ licznik);
    }

}
