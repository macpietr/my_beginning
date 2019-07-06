import java.util.*;

public class Calculate {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        Calculator calc = new Calculator();

        int koniec = 0;
        while (koniec != 1){

        System.out.println("Podaj liczbę");
        calc.a= in.nextDouble();

        int warun = 0;
        while (warun <=0 || warun  > 4) {


        System.out.println("Wybierz działąnie");
        System.out.println("1 = +");
        System.out.println("2 = -");
        System.out.println("3 = *");
        System.out.println("4 = /");
        warun = in.nextInt();





        }

        System.out.println("Podaj liczbę");
        calc.b = in.nextDouble();

            switch (warun) {
                case 1:
                    calc.add(calc.a, calc.b);
                    calc.showAdd();
                    break;
                case 2:
                   calc.substract(calc.a, calc.b);
                    calc.showSubstract();
                    break;
                case 3:
                    calc.multiply(calc.a, calc.b);
                    calc.showMultiply();
                    break;
                case 4:

                    System.out.println(calc.devide(calc.a, calc.b));
                    break;
            }
            int pomoc = 0;
            while (pomoc <= 0 || pomoc > 2){
                System.out.println("1 - koniec, 2 - jeszcze raz");
                pomoc = in.nextInt();
            }
            koniec = pomoc;
        }

    }




}
