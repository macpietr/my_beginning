package com.maciej.library.io.file;

import com.maciej.library.exception.NoSuchFileTypeException;
import com.maciej.library.io.ConsolePrinter;
import com.maciej.library.io.DataReader;

public class FileManagerBuilder {
    private ConsolePrinter printer;
    private DataReader reader;

    public FileManagerBuilder(ConsolePrinter printer, DataReader reader){
        this.printer=printer;
        this.reader=reader;
    }

    public FileManager build(){
        printer.printLine("Wbierz format danych");
        FileType fileType = getFileType();
        switch (fileType){
            case CSV:
                return new CsvFileManager();
            case SERIAL:
                return new SerializableFileManager();
            default:
                throw new NoSuchFileTypeException("Nieobsługiwany typ danych");
        }
    }

    private FileType getFileType(){
        boolean typeOK=false;
        FileType result = null;
        do{
            printTypes();
            String type=reader.getString().toUpperCase();
            try{
                result = FileType.valueOf(type);
                typeOK=true;
            }catch (IllegalArgumentException e){
                printer.printLine("Nieobsługiwany typ danych, wybierz ponownie.");
            }
        }while (!typeOK);
        return result;
    }

    private void printTypes(){
        for (FileType value: FileType.values()){
            printer.printLine(value.name());
        }
    }
}
