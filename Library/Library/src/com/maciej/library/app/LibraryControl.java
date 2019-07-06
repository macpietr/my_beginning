package com.maciej.library.app;

import com.maciej.library.exception.*;
import com.maciej.library.io.ConsolePrinter;
import com.maciej.library.io.DataReader;
import com.maciej.library.io.file.FileManager;
import com.maciej.library.io.file.FileManagerBuilder;
import com.maciej.library.model.*;
import com.maciej.library.model.comparator.AlphabeticalTitleComparator;

import java.util.Collection;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.regex.PatternSyntaxException;


class LibraryControl {

    private ConsolePrinter printer = new ConsolePrinter();
    private DataReader dataReader = new DataReader(printer);
    private FileManager fileManager;

    private Library library;

    LibraryControl(){
        fileManager = new FileManagerBuilder(printer,dataReader).build();
        try {
            library=fileManager.importData();
            printer.printLine("Zaimportowane dane z pliku");
        }catch (DataImportException | InvalidDataException e){
            printer.printLine(e.getMessage());
            printer.printLine("Zainicjowano nową bazę");
            library = new Library();
        }
    }

    void controlLoop() {
        Option option;

        do {
            printOptions();
            option = getOption();
            switch (option) {
                case ADD_BOOK:
                    addBook();
                    break;
                case PRINT_BOOKS:
                    printBooks();
                    break;
                case ADD_MAGAZINE:
                    addMagazine();
                    break;
                case PRINT_MAGAZINES:
                    printMagazines();
                    break;
                case DELETE_BOOK:
                    deleteBook();
                    break;
                case DELETE_MAGAZINE:
                    deleteMagazine();
                    break;
                case ADD_USER:
                    addUser();
                    break;
                case PRINT_USERS:
                    printUsers();
                    break;
                case FIND_BOOK:

                case EXIT:
                    exit();
                    break;
                default:
                    printer.printLine("Nie ma takiej opcji, wprowadź ponownie: ");
            }

        } while (option != Option.EXIT);
    }

    private Option getOption(){
        boolean optionOk=false;
        Option option=null;
        while (!optionOk){
            try{
                option=Option.createFromInt(dataReader.getInt());
                optionOk=true;
            }catch (NoSuchOptionException e){
                printer.printLine(e.getMessage()+", podaj ponownie");
            }catch (InputMismatchException ignored){
                printer.printLine("Wprowadzono wartość, która nie jest liczbą, podaj ponownie:");
            }
        }
        return option;
    }

    private void printOptions(){
        printer.printLine("Wybierz opcję");
        for(Option option: Option.values()){
            printer.printLine(option.toString());
        }
    }

    private void addBook(){
        try {
            Book book = dataReader.createBook();
            library.addPublication(book);
        }catch (InputMismatchException e){
            printer.printLine("Nie udało się utworzyć książki, niepoprawne dane");
        }catch (ArrayIndexOutOfBoundsException e){
            printer.printLine("Osiągnięto limit pojemności, nie można dodać kolejnej książki");
        }
    }

    private void printBooks(){
    printer.printBooks(library.getSortedPublications(
            (p1,p2) -> p1.getTitle().compareTo(p2.getTitle())
    ));
    }
    private void printMagazines(){
        printer.printMagazines(library.getSortedPublications(
                (p1,p2) -> p1.getTitle().compareTo(p2.getTitle())
        ));
    }

    private void printUsers(){
        printer.printUsers(library.getSortedUsers(Comparator.comparing(
                LibraryUser::getLastName, String.CASE_INSENSITIVE_ORDER)
        ));
    }

    private void findBook(){
        printer.printLine("Podaj tytuł publikacji");
        String title = dataReader.getString();
        String notFoundMessage = "Brak publikacji o takim tytule";
        library.findPublicationByTitle(title)
                .map(Publication::toString)
                .ifPresentOrElse(System.out::println, ()-> System.out.println(notFoundMessage));
    }


    private void addMagazine(){
        try {
            Magazine magazine = dataReader.createMagazine();
            library.addPublication(magazine);
        }catch (InputMismatchException e){
            printer.printLine("Nie udało się utworzyć magazynu, niepoprawne dane.");
        }catch (ArrayIndexOutOfBoundsException e){
            printer.printLine("Osiągnięto limit pojemności, nie można dodać kolejnego magazynu.");
        }
    }



    private void deleteMagazine(){
        try{
            Magazine magazine = dataReader.createMagazine();
            if(library.removePublication(magazine)){
                printer.printLine("Usunięto magazyn");
            }else{
                printer.printLine("Brak wskazanego magazynu");
            }
        }catch (InputMismatchException e){
            printer.printLine("Niepoprawne dane");
        }
    }

    private void deleteBook(){
        try{
            Book book = dataReader.createBook();
            if(library.removePublication(book)){
                printer.printLine("Usunięto książkę");
            }else{
                printer.printLine("Brak wskazanej książki");
            }
        }catch (InputMismatchException e){
            printer.printLine("Niepoprawne dane");
        }
    }

    private void addUser(){
        LibraryUser libraryUser = dataReader.createLibraryUser();
        try{
            library.addUser(libraryUser);
        }catch (UserAlreadyExistsException e){
            printer.printLine(e.getMessage());
        }
    }

    private void exit(){
        try{
            fileManager.exportData(library);
            printer.printLine("Export danych do pliku zakończony powodzeniem");
        }catch (DataExportException e){
            printer.printLine(e.getMessage());
        }
        dataReader.close();
        System.out.println("No to narciarz");
    }

    private enum Option {
        EXIT(0,"Wyjście"),
        ADD_BOOK(1,"Dodaj książkę"),
        ADD_MAGAZINE(2, "Dodaj magazyn"),
        PRINT_BOOKS(3, "Wyświetl książki"),
        PRINT_MAGAZINES(4, "Wyświetl magazyny"),
        DELETE_BOOK(5,"Usuń książkę"),
        DELETE_MAGAZINE(6,"Usuń magazyn"),
        ADD_USER(7,"Dodaj użytkownika"),
        PRINT_USERS(8,"Wyświetl użytkowników"),
        FIND_BOOK(9,"Znajdź książkę");


        private int value;
        private String description;

        Option(int value, String description){
            this.value=value;
            this.description=description;
        }

        public int getValue(){
            return value;
        }

        public String getDescription(){
            return description;
        }

        @Override
        public String toString(){
            return value+" - "+description;
        }

        static Option createFromInt(int option) throws NoSuchOptionException {
            try {
                return Option.values()[option];
            } catch (ArrayIndexOutOfBoundsException e){
                throw new NoSuchOptionException("Brak opcji o id"+option);
            }
        }


    }
}
