public class Nurse extends Person {

    private double extraHours;

    Nurse(String firstname, String lastname, double salary, double extraHours){
        super(firstname,lastname,salary);
        this.extraHours=extraHours;
    }

    double getExtraHours(){
        return extraHours;
    }

    void setExtraHours(double extraHours){
        this.extraHours=extraHours;
    }

    @Override
    String getInfo(){
        return super.getInfo()+";"+getExtraHours();
    }

    @Override
    void printInfo(){
        System.out.println(this.getInfo());
    }
}

