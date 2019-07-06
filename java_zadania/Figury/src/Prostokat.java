public class Prostokat implements Shape{

    private double a;
    private double b;
    private double pole;
    private double obwod;

    Prostokat(){};
    Prostokat(double a,double b){
        this.a=a;
        this.b=b;
    }

    public void setA(double a) {
        this.a = a;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getB() {
        return b;
    }

    public double getA() {
        return a;
    }

    @Override
    public double obwod() {
        this.obwod = 2*getA()+2*getB();
        return obwod;
    }

    @Override
    public double pole() {
        this.pole = getA()*getB();
        return pole;
    }

    @Override
    public String toString(){
        return "Boki: "+this.a+"x"+this.b+"; obwod: "+this.obwod()+"; pole: "+this.pole();
    }
}
