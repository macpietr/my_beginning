import java.util.InputMismatchException;
import java.util.Scanner;

public class Check {

    private String result;
    private int figura;

    DataReader dr = new DataReader();
    Scanner in = new Scanner(System.in);

    @Override
    public String toString(){
        return this.result;
    }

    public String checkTrojkat() {
        Boolean error = true;
        while (error) {
            try {
                Trojkat tr = new Trojkat();
                tr = dr.createTrojkat();
                error = false;
                this.result = tr.toString();
            } catch (ArithmeticException ex1) {
                System.err.println(ex1.getMessage());
            } catch (GeometricException ex2) {
                System.err.println(ex2.getMessage());
            }
        }
        return this.result;
    }

    public String checkProstokat(){
        Boolean error = true;
        while (error){
            try {
                Prostokat pr = new Prostokat();
                pr = dr.createProstokat();
                error=false;
                this.result=pr.toString();
            }catch (ArithmeticException ex1){
                System.err.println(ex1.getMessage());
            }

        }
        return this.result;
    }

    public String checkKolo(){
        Boolean error = true;
        while (error){
            Kolo ko = new Kolo();
            try {
                ko = dr.createKolo();
                error=false;
                this.result=ko.toString();
            }catch (ArithmeticException ex1){
                System.err.println(ex1.getMessage());
            }
        }
        return this.result;
    }

    public void checkMenu() {
        Boolean error = true;
        this.figura = 0;
        while (error) {
            System.out.println("1 - trojkat");
            System.out.println("2 - prostokat");
            System.out.println("3 - kolo");
            try {
                this.figura = in.nextInt();
                in.nextLine();
                error = false;
            } catch (InputMismatchException ex) {
                System.err.println("Głupi Ty? Co miałeś podać?");
                in.nextLine();
            }
        }
        if(this.figura<0 || this.figura>3){
            throw new IndexOutOfBoundsException("1,2,3!");
        }
    }

    public int getFigura() {
        return figura;
    }
}
