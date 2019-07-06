public class Apple extends  Friut {
    private String odmiana;
    Apple(String odmiana){
        super();
        this.odmiana=odmiana;
    }

    public void setOdmiana(String odmiana){
        this.odmiana=odmiana;
    }

    public String getOdmiana(){
        return odmiana;
    }
    @Override
    public void printInfo(){
        super.printInfo();
        System.out.println(": "+getOdmiana());
    }
}
