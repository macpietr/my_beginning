class Calculator {

    double a;
    double b;
    double c;


    Calculator (double a, double b){
        this.a=a;
        this.b=b;
    }

    Calculator (this.a, this.b, this.c){
        this(a,b);
        this.c=c;
    }

    double add(){
        double result = a+b;
        return result;
    }

    double add(){
        double result = c + add(a,b);
        return result;
    }

    double substract(){
        double result = a-b;
        return result;
    }

    double substract(){
        double result = substract(a,b) - c;
        return result;
    }

}
