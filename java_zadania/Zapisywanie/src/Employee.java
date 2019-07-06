import java.io.Serializable;

public class Employee extends Person {
    private static final long serialVersionUID = 4420226460862818754L;
    private double salary;

    public Employee(String name,String lastname, double salary){
        super(name,lastname);
        this.salary=salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String toString(){
        return super.getName()+"; "+super.getLastname()+"; "+getSalary();
    }
}
