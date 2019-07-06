import java.util.Scanner;

public class DataReader {
    private double a;
    private double b;
    private String action;
    public String warun;

    Scanner in=new Scanner(System.in);

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public String getAction() {
        return this.action;
    }

    public void setA() {
        System.out.println("Podaj 1. liczbę");
        this.a = in.nextDouble();
        in.nextLine();
    }

    public void setB() {
        System.out.println("Podaj 2. liczbę");
        this.b = in.nextDouble();
        in.nextLine();
    }

    public void setAction()throws UnknownOperatorException {
        Boolean error=true;
        while (error) {
            System.out.println("Działanie (+,-,*,/):");
            this.action = in.nextLine();
            if(this.action=="+"||this.action=="-"||this.action=="*"||this.action=="/"){
                throw new UnknownOperatorException("Niewławściwy operator");
            }else{
                error=false;
                warun=getAction();
            }
        }
    }



}
