package com.maciej.library.io.file;

import com.maciej.library.exception.DataExportException;
import com.maciej.library.exception.InvalidDataException;
import com.maciej.library.model.*;

import java.io.*;
import java.util.Collection;
import java.util.Scanner;

public class CsvFileManager implements FileManager {
    private static final String PUBLICATIONS_FILE_NAME="Library.csv";
    private static final String USERS_FILE_NAME="Library_users.csv";

    @Override
    public void exportData(Library library){
        exportPublications(library);
        exportUsers(library);
    }

    private void exportPublications(Library library){
        Collection<Publication> publications = library.getPublications().values();
        exportToCsv(publications, PUBLICATIONS_FILE_NAME);
    }

    private void exportUsers(Library library){
        Collection<LibraryUser> libraryUsers = library.getUsers().values();
        exportToCsv(libraryUsers, USERS_FILE_NAME);
    }


    private <T extends CsvConvertible> void exportToCsv(Collection<T> collection, String fileName){
        try(FileWriter fileWriter = new FileWriter(fileName);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)){
            for(T element : collection){
                bufferedWriter.write(element.toCsv());
                bufferedWriter.newLine();
            }
        }catch (IOException e){
            throw new DataExportException("Błąd zapisu danych do pliku"+fileName);
        }
    }

    public Library importData() {
        Library library = new Library();
        importPublications(library);
        importUsers(library);
        return library;
    }

    private void importPublications(Library library){
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(PUBLICATIONS_FILE_NAME))){
            bufferedReader.lines()
                    .map(this::createObjectFromString)
                    .forEach(library::addPublication);
        }catch(FileNotFoundException e){
                throw new DataExportException("Brak pliku"+PUBLICATIONS_FILE_NAME);
        }catch (IOException e){
            throw new DataExportException("Błąd odczytu pliku"+PUBLICATIONS_FILE_NAME);
        }
    }

    private void importUsers(Library library){
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(USERS_FILE_NAME))){
            bufferedReader.lines()
                    .map(this::createUserFromString)
                    .forEach(library::addUser);
        }catch (FileNotFoundException e){
            throw new DataExportException("Brak pliku"+USERS_FILE_NAME);
        }catch (IOException e){
            throw new DataExportException("Błąd odczytu pliku"+USERS_FILE_NAME);
        }
    }

    private LibraryUser createUserFromString(String csvText){
        String[] split = csvText.split(";");
        String firstname = split[0];
        String lastname = split[1];
        String pesel = split[2];
        return new LibraryUser(firstname,lastname,pesel);
    }

    private Publication createObjectFromString(String csvText){
        String[] split = csvText.split(";");
        String type = split[0];
        if(Book.TYPE.equals(type)) {
            return createBook(split);
        }else if(Magazine.TYPE.equals(type)){
            return createMagazine(split);
        }
        throw new InvalidDataException("Nieznany tryp publikacji:"+type);
    }

    private Book createBook(String[] data){
        String title = data[1];
        String publisher = data[2];
        int year = Integer.valueOf(data[3]);
        String author = data[4];
        int pages = Integer.valueOf(data[5]);
        String isbn = data[6];
        return new Book(title,author,year,pages,publisher,isbn);
    }

    private Magazine createMagazine(String[] data){
        String title = data[1];
        String publisher = data[2];
        int year = Integer.valueOf(data[3]);
        int month = Integer.valueOf(data[4]);
        int day = Integer.valueOf(data[5]);
        String language = data[6];
        return new Magazine(title,publisher,language,year,month,day);
    }

}
