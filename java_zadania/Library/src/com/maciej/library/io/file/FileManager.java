package com.maciej.library.io.file;

import com.maciej.library.model.Library;

public interface FileManager {
    Library importData();
    void exportData(Library library);
}
