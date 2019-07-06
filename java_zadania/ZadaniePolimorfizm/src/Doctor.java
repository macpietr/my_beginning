public class Doctor extends Person {
    private double premia;

    Doctor(String firstname, String lastname, double salary, double premia){
        super(firstname,lastname,salary);
        this.premia=premia;
    }

    double getPremia() {
        return premia;
    }

    public void setPremia(double premia) {
        this.premia=premia;
    }

    @Override
    String getInfo(){
        return super.getInfo()+";"+getPremia();
    }

    @Override
    void printInfo(){
        System.out.println(this.getInfo());
    }
}
