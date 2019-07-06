

public class Control {

    private double sum;
    private double dif;
    private double mul;
    private double div;

    DataReader dr = new DataReader();



    private void setSum(){
        this.sum=dr.getA()+dr.getB();
    }

    private double getSum() {
        return sum;
    }

    private void setDif() {
        this.dif = dr.getA()-dr.getB();
    }

    private double getDif() {
        return dif;
    }

    private void setMul() {
        this.mul = dr.getA()*dr.getB();
    }

    private double getMul() {
        return mul;
    }

    private void setDiv() {
        Boolean error=true;
        while (error) {
            try{
                this.div = dr.getA() / dr.getB();
                error=false;
            }catch (ArithmeticException ex){
                System.err.println("Nie dziel przez 0");
                dr.setB();
                dr.getB();
            }
        }
    }

    private double getDiv() {
        return div;
    }

    public void controlPanel(){
        try{
            dr.setAction();
        }catch (UnknownOperatorException ex2){
            System.err.println(ex2.getMessage());
        }

        if (dr.warun=="+"){
            setSum();
            System.out.println(getSum());
        }else if(dr.warun=="-"){
            setDif();
            System.out.println(getDif());
        }else if(dr.warun=="*"){
            setMul();
            System.out.println(getMul());
        }else if(dr.warun=="/"){
            setDiv();
            System.out.println(getDiv());
        }
    }
}
