public class Calculator {

    double a;
    double b;

    double add(double a, double b){
        return a + b;
    }

    double substract(double a, double b){
        return a - b;
    }

    double multiply(double a, double b){
        return a * b;
    }

    double devide(double a, double b){
        return a / b;
    }

    void showAdd(){
        System.out.println(add(a, b));
    }

    void showSubstract(){
        System.out.println(substract( a,  b));
    }

    void showMultiply(){
        System.out.println(multiply( a,  b));
    }

    void showDevide(){
        System.out.println(devide( a,  b));
    }
}
