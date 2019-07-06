import java.io.Serializable;

public class Person implements Serializable {
    private static final long serialVersionUID = 3812017177088226529L;
    private String name;
    private String lastname;

    public Person(String name,String lastname){
        this.name=name;
        this.lastname=lastname;
    }


    public String getLastname() {
        return lastname;
    }

    public String getName() {
        return name;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setName(String name) {
        this.name = name;
    }
}
