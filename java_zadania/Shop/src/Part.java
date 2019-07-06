public class Part {
    private int id;
    private int serial;
    private String producer;
    private String model;

    public Part(int id,int serial,String producer,String model){
        this.id=id;
        this.serial=serial;
        this.producer=producer;
        this.model=model;
    }

    public int getId(){
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSerial() {
        return serial;
    }

    public void setSerial(int serial) {
        this.serial = serial;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getInfo(){
        return getId()+";"+getSerial()+";"+getModel()+";"+getProducer();
    }

    public void printInfo(){
        System.out.println(getInfo());
    }
}

