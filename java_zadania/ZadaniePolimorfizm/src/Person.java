public class Person {
    private String firstname;
    private String lastname;
    private double salary;

    Person(String firstname,String lastname, double salary){
        this.firstname=firstname;
        this.lastname=lastname;
        this.salary=salary;
    }

    String getFirstname(){
        return firstname;
    }

    void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    String getLastname(){
        return lastname;
    }

    void setLastname(String lastname) {
        this.lastname = lastname;
    }

    double getSalary() {
        return salary;
    }

    void setSalary(double salary) {
        this.salary = salary;
    }

    String getInfo(){
        return getFirstname()+";"+getLastname()+";"+getSalary();
    }

    void printInfo(){
        System.out.println(getInfo());
    }
}
