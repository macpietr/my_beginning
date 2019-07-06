import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Company implements Serializable {
    public static final String FILE_NAME="plik.obj";
    private static final long serialVersionUID = -7425273230264572679L;
    public static final int MAX=3;
    private int counter=0;
    private Employee[] employees = new Employee[MAX];
    private transient Scanner in =new Scanner(System.in);



    public int getInt(){
        int option=0;
        boolean error=true;
        while (error) {
            try {
                option = in.nextInt();
                in.nextLine();
                error=false;
            } catch (InputMismatchException e) {
                System.out.println("Błędne dane");
                in.nextLine();
            }
        }
        return option;
    }

    public Employee getRow(int i){
        return employees[i];
    }

    public void addRow(int i){
        employees[i]=createEmployee();
    }

    private Employee createEmployee(){
        String name=null;
        String lastname=null;
        double salary=0;
        if (counter<MAX){
            try {
                System.out.println("imie");
                name = in.nextLine();
                System.out.println("nazwisko");
                lastname = in.nextLine();
                System.out.println("wyplata");
                salary = in.nextDouble();
                in.nextLine();
            }catch (InputMismatchException e){
                System.out.println("nieprawidlowe dane");
            }
            counter++;
        }else{
            System.out.println("brak miejsca");
        }
        return new Employee(name,lastname,salary);
    }

}
