public class NotebookShop {
    public static void main(String[] args) {

        DataStore dataStore = new DataStore();

        for(int i=0;i<5;i++){
            dataStore.add();
        }

        dataStore.printInfo();

        dataStore.checkAvailability();

    }
}
