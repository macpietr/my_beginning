import java.util.Scanner;
import java.util.InputMismatchException;

public class Panel {

    private static final int PROGRAM=1;
    private static final int EXIT=0;
    private String result;
    private int operator;

    Scanner in = new Scanner(System.in);
    DataReader dr = new DataReader();
    Check chk = new Check();

    public void control() {
        Boolean error=true;
        while (error) {
            try {
                chk.checkMenu();
                error=false;
            } catch (IndexOutOfBoundsException ex) {
                System.err.println(ex.getMessage());
            }
        }
        int figura=chk.getFigura();
        switch (figura) {
            case Shape.TROJKAT:
                chk.checkTrojkat();
                result = chk.toString();
                System.out.println(result);
            break;
            case Shape.PROSTOKAT:
                chk.checkProstokat();
                result=chk.toString();
                System.out.println(result);
            break;
            case Shape.KOLO:
                chk.checkKolo();
                result=chk.toString();
                System.out.println(result);
            break;
        }
        menu();
    }

    public void menu(){
        Boolean error=true;
        this.operator = 2;
        while (error) {
            try {
                while(this.operator>1 || this.operator < 0) {
                    System.out.println("1 - program");
                    System.out.println("0 - wyjście");
                    this.operator = in.nextInt();
                    in.nextLine();
                    if (this.operator>1 || this.operator < 0){
                        System.out.println("1 lub 2!!");
                    }
                }
                error=false;
            } catch (InputMismatchException ex) {
                System.err.println("Takie trudne wcisnąc 1 lub 0?");
                in.nextLine();
            }
        }
        switch (this.operator){
            case PROGRAM:
                Boolean error2=true;
                while (error2) {
                    try {
                        control();
                        error2=false;
                    } catch (InputMismatchException ex) {
                        System.out.println(ex.getMessage());
                        in.nextLine();
                    }
                }
            break;
            case EXIT:
                System.out.println("PAPATKI!");
            break;
            default:
                throw new IndexOutOfBoundsException("Dostepne wartości to 1 lub 0");
        }
    }

    public void loop(){
        Boolean error=true;
        while (error){
            try{
                menu();
            }catch (InputMismatchException ex){
                System.err.println(ex.getMessage());
                in.nextLine();
            }
        }
    }
}
