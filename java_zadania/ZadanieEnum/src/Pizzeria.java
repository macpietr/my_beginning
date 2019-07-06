import java.util.Scanner;

public class Pizzeria {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Menu:");
        Pizza[] menu = Pizza.values();
        for (Pizza m: menu) {
            System.out.println(m);
        }
        System.out.println("Podaj numer pizzy, którą wybrałeś");
        int numer = in.nextInt();
        System.out.println("Twoje zamówienie:");
        System.out.println(menu[numer-1].toString());

    }
}
