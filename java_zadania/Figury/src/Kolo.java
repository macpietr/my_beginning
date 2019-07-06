public class Kolo implements Shape{

    private double r;

    Kolo(){};
    Kolo(double r){
        this.r=r;
    }

    public void setR(double r) {
        this.r = r;
    }

    public double getR() {
        return r;
    }

    @Override
    public double obwod() {
        return 2*Shape.PI*getR();
    }

    @Override
    public double pole() {
        return Shape.PI*getR()*getR();
    }

    @Override
    public String toString(){
        return "Promien: "+getR()+"; obwod: "+obwod()+"; pole: "+pole();
    }

}
