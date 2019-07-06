import java.util.Scanner;

public class Hospital {

    private static final int WORKERS_AMOUNT = 3;
    private int licznik = 0;
    private Scanner in = new Scanner(System.in);
    private Person[] worker = new Person[WORKERS_AMOUNT];

    public Person add() {
        if (licznik >= WORKERS_AMOUNT) {
            System.out.println("Przekroczony limit");
        } else {
            System.out.println("1-lekarz");
            System.out.println("2-pielegniarka");
            int warun = in.nextInt();
            in.nextLine();
            switch (warun) {
                case 1:
                    String fn = in.nextLine();
                    String ln = in.nextLine();
                    double salary = in.nextDouble();
                    double premia = in.nextDouble();
                    Person person = new Doctor(fn, ln, salary, premia);
                    worker[licznik] = person;
                    break;
                case 2:
                    String fn2 = in.nextLine();
                    String ln2 = in.nextLine();
                    double salary2 = in.nextDouble();
                    double eH = in.nextDouble();
                    Person person2 = new Nurse(fn2, ln2, salary2, eH);
                    worker[licznik] = person2;
                    break;
            }
        }
        licznik++;
        return worker[licznik];
    }


        public void printInfo () {
            for (int i = 0; i < licznik; i++) {
                worker[i].printInfo();
            }

        }

}
