public enum Pizza {
    MARGHARITA(true,true,false,false),
    CAPRICIOSA(true,true,true,false),
    PROSCIUTTO(true,true,false,true);

    private final Boolean souce;
    private final Boolean cheese;
    private final Boolean mashrooms;
    private final Boolean ham;



    private Pizza(Boolean souce,Boolean cheese, Boolean mashrooms, Boolean ham){
        this.souce=souce;
        this.cheese=cheese;
        this.mashrooms=mashrooms;
        this.ham=ham;
    }

    public Boolean getSouce() {
        return souce;
    }

    public Boolean getCheese() {
        return cheese;
    }

    public Boolean getMashrooms() {
        return mashrooms;
    }

    public Boolean getHam() {
        return ham;
    }

    @Override
    public String toString(){
        String result = (this.ordinal()+1)+". "+this.name()+": ";
        if(getSouce()==true){
            result = result + "sos pomidorowy";
        }
        if (getCheese()==true){
            result = result +", ser";
        }
        if (getMashrooms()==true){
            result = result +", pieczarki";
        }
        if (getHam()==true){
            result = result +", szynka";
        }
        return result;
    }

}
