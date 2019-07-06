public class App {
    public static void main(String[] args) {
        ExportImport ei = new ExportImport();

        DataSet ds = new DataSet();

        ds.setNumbers();

        ei.exportData(ds);

        DataSet ds2 = null;

        ds2=ei.importData();

        ds2.printNumbers();
    }
}
