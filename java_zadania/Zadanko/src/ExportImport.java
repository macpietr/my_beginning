import java.io.*;

public class ExportImport implements Serializable {

    private static final String FILE_NAME="plik.o";

    public void exportData(DataSet ds){
        try (
                var fos = new FileOutputStream(FILE_NAME);
                var oos = new ObjectOutputStream(fos)
        ){
            oos.writeObject(ds);
        }catch (FileNotFoundException e){
            System.err.println("Nie odnaleziono pliku");
        }catch (IOException e){
            System.out.println("Błąd zapisu danych");
        }
    }

    public DataSet importData() {
        try (
                var fis = new FileInputStream(FILE_NAME);
                var ois = new ObjectInputStream(fis)
        ){
            return (DataSet) ois.readObject();
        } catch (FileNotFoundException e) {
            System.err.println("Nie odnaleziono pliku");
        } catch (IOException e) {
            System.err.println("Błąd odczytu pliku");
        } catch (ClassNotFoundException e) {
            System.err.println("Niezgodny typ danych");
        }
        finally {
            return null;
        }
    }

}