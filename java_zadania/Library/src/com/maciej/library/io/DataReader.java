
package com.maciej.library.io;
import java.util.InputMismatchException;
import java.util.Scanner;
import com.maciej.library.model.Book;
import com.maciej.library.model.LibraryUser;
import com.maciej.library.model.Magazine;

public class DataReader {

    private ConsolePrinter printer;
    private Scanner in = new Scanner(System.in);

    public DataReader(ConsolePrinter printer){
        this.printer=printer;
    }

    public void close(){
        in.close();
    }

    public String getString(){
        return in.nextLine();
    }

    public int getInt(){
        try{
            return in.nextInt();
        }catch (InputMismatchException e){
            throw e;
        }finally {
            in.nextLine();
        }
    }

    public Book createBook() {
        printer.printLine("Tytuł");
        String title = in.nextLine();
        printer.printLine("Autor");
        String author = in.nextLine();
        printer.printLine("Rok wydania");
        int releaseDate = getInt();
        printer.printLine("Ilość stron");
        int pages = getInt();
        printer.printLine("Wydawca");
        String publisher = in.nextLine();
        printer.printLine("Czy jest ISBN? [1]/[0]");
        int warun1 = in.nextInt();
        in.nextLine();
        boolean warun2 = (warun1 == 1);
        if (warun2) {
            printer.printLine("Podaj ISBN");
            String isbn = in.nextLine();
            return new Book(title, author, releaseDate, pages, publisher, isbn);
        } else {
            return new Book(title, author, releaseDate, pages, publisher);
        }
    }

        public Magazine createMagazine(){
            printer.printLine("Tytuł: ");
            String title = in.nextLine();
            printer.printLine("Wydawnictwo: ");
            String publisher = in.nextLine();
            printer.printLine("Język: ");
            String language = in.nextLine();
            printer.printLine("Rok wydania: ");
            int year = getInt();
            printer.printLine("Miesiąc: ");
            int month = getInt();
            printer.printLine("Dzień: ");
            int day = getInt();

            return new Magazine(title, publisher, language, year, month, day);
        }

        public LibraryUser createLibraryUser(){
            printer.printLine("Imię:");
            String firstName = in.nextLine();
            printer.printLine("Nazwisko:");
            String lastName = in.nextLine();
            printer.printLine("PESEL:");
            String pesel = in.nextLine();

            return new LibraryUser(firstName,lastName,pesel);
        }


}
