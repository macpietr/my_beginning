package com.maciej.library.model.comparator;

import com.maciej.library.model.Publication;

import java.util.Comparator;

public class DateComparator implements Comparator<Publication> {

    @Override
    public int compare(Publication p1, Publication p2){
        if(p1.getYear()==0 && p2.getYear()==0){
            return 0;
        }else if(p1.getYear()==0){
            return 1;
        }else if (p2.getYear()==0){
            return -1;
        }
        Integer i1 = p1.getYear();
        Integer i2 = p2.getYear();
        return -i1.compareTo(i2);
    }
}
