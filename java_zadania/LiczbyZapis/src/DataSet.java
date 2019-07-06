import java.io.Serializable;
import java.math.BigInteger;

public class DataSet implements Serializable {

    private int counter=0;
    private static final int MAX_NUMBERS=5;

    DataReader dr = new DataReader();


    int[] numbers = new int[MAX_NUMBERS];

    public void setNumbers(){
        for(int i=0;i<MAX_NUMBERS;i++){
            addNumber();
        }
    }

    public void addNumber(){
        if(counter<MAX_NUMBERS){
            numbers[counter]=dr.setNumber();
            counter++;
        }else{
            System.out.println("Przekroczono liczbę maxymalną");
        }
    }

    public int[] getNumbers(){
        return numbers;
    }

    public String toString(int i){
        return "No. "+i+". "+dr.getNumber();
    }

    public void printNumbers(){
        for (int i=0;i<MAX_NUMBERS;i++){
            System.out.println(toString(i));
        }
    }

}
