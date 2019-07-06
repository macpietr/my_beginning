public class Trojkat implements Shape {

    private double a;
    private double b;
    private double c;
    private double h;

    Trojkat(){};
    Trojkat(double a,double b, double c, double h){
        this.a=a;
        this.b=b;
        this.c=c;
        this.h=h;
    };

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public double getH() {
        return h;
    }

    public void setA(double a) {
        this.a = a;
    }

    public void setB(double b) {
        this.b = b;
    }

    public void setC(double c) {
        this.c = c;
    }

    public void setH(double h) {
        this.h = h;
    }

    @Override
    public double obwod() {
        return getA()+getB()+getC();
    }

    @Override
    public double pole() {
        return getA()*getH()/2;
    }

    @Override
    public String toString(){
        return "Boki: "+getA()+"; "+getB()+"; "+getC()+"; wysokosc: "+getH()+"; obwod: "+obwod()+"; pole: "+pole();
    }
}
