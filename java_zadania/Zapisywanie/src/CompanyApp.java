import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;
public class CompanyApp {
    public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    Company company = new Company();
        Licznik1 warun=null;
        while (warun!=Licznik1.EXIT) {
            System.out.println("Menu:");
            for (Licznik1 l:Licznik1.values()){
                System.out.println(l.toString());
            }
            warun=Licznik1.createFromInt(company.getInt());
            switch (warun) {
                case SAVE:
                    Company cp = new Company();
                    writer(cp);
                break;
                case READ:
                    Company cp2 = null;
                    reader(cp2);
                break;
                case EXIT:
                    System.out.println("PAPA");
                break;
            }
        }
    }

    public static void writer(Company cp){
        try (
                FileOutputStream fos = new FileOutputStream(Company.FILE_NAME);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
        ) {
            for (int i = 0; i < Company.MAX; i++) {
                cp.addRow(i);
            }
            oos.writeObject(cp);
        } catch (IOException ex) {
            System.out.println("Błąd");
            ex.printStackTrace();
        }
    }


    public static void reader(Company cp2){
        try (
                FileInputStream fis = new FileInputStream(Company.FILE_NAME);
                ObjectInputStream ois = new ObjectInputStream(fis);
        ) {
            cp2 = (Company) ois.readObject();
            for (int i = 0; i < Company.MAX; i++) {
                System.out.println(cp2.getRow(i).toString());
            }
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Błąd");
            ex.printStackTrace();
        }
    }
}
