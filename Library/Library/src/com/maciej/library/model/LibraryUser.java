package com.maciej.library.model;

import java.util.ArrayList;
import java.util.List;

public class LibraryUser extends User {

    public LibraryUser(String firstName, String lastName, String pesel) {
        super(firstName, lastName, pesel);
    }

    private List<Publication> publicationHistory = new ArrayList<>();
    private List<Publication> borrowedPublications = new ArrayList<>();

    public  List<Publication> getPublicationHistory(){
        return  publicationHistory;
    }

    public List<Publication> getBorrowedPublications() {
        return borrowedPublications;
    }

    private void addPublicationToHistory(Publication pub){
        publicationHistory.add(pub);
    }

    public void borrowPublication(Publication pub){
        borrowedPublications.add(pub);
    }

    public boolean returnPublication(Publication pub){
        boolean result = false;
        if(borrowedPublications.remove(pub)){
            result = true;
            addPublicationToHistory(pub);
        }
        return result;
    }

    public String toCsv(){
        return getFirstName()+";"+getFirstName()+";"+getPesel();
    }
}
