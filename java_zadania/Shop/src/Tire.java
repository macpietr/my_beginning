public class Tire extends Part {
    private int size;
    public Tire(int id,int serial,String producer,String model,int size){
        super(id, serial, producer, model);
        this.size=size;
    }

    public int getSize(){
        return size;
    }

    public void setSize(int size){
        this.size=size;
    }

    public String getInfo(){
        return super.getInfo()+";"+getSize();
    }

    public void prinInfo(){
        System.out.println(this.getInfo());
    }
}
