import java.util.InputMismatchException;
import java.util.Scanner;

public class DataReader {



    Scanner in = new Scanner(System.in);

    public double setDouble(){
        double x=0;
        Boolean error0=true;
        while(error0) {
            x = 0;
            try {
                x = in.nextInt();
                in.nextLine();
                error0=false;
            } catch (InputMismatchException ex) {
                System.err.println("serio? litery?");
                in.nextLine();
                System.out.println("Podaj wartości o które Cię proszono");
            }
        }
        return x;
    }

    public Trojkat createTrojkat(){
        System.out.println("Podaj boki:");
        double a=setDouble();
        double b=setDouble();
        double c=setDouble();
        System.out.println("Podaj wysokosc");
        double h=setDouble();
        if(a<=0||b<=0||c<=0||h<=0){
            throw new ArithmeticException("Bok <=0??");
        }
        if(a+b<=c||a+c<=b||b+c<=a){
            throw new GeometricException("Nie jest spełniony warunek trójkąta");
        }
        else {
            return new Trojkat(a, b, c, h);
        }
    }

    public Prostokat createProstokat(){
        System.out.println("Podaj boki");
        double a=setDouble();
        double b=setDouble();
        if(a>0&&b>0) {
            return new Prostokat(a, b);
        }else{
            throw new ArithmeticException("Bok <=0??");
        }
    }

    public Kolo createKolo(){
        System.out.println("Podaj promien");
        double r = setDouble();
        if(r>0) {
            return new Kolo(r);
        }else{
            throw new ArithmeticException("Promien <=0??");
        }
    }


}
