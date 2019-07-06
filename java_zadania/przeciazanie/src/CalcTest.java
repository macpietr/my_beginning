import java.util.*;

public class CalcTest {
    public static void main(String[] args) {


        Calculator calc1 = new Calculator(1,2);
        Calculator calc2 = new Calculator(1,2,3);
        double calc1 = calc1.add();
        double calc2 = calc2.add();
        double calc3 = calc1.substract();
        double calc4 = calc2.substract();

        System.out.println(calc1);
        System.out.println(calc2);
        System.out.println(calc3);
        System.out.println(calc4);



    }
}
