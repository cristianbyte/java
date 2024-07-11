package com.crisitanbyte.design_patterns.adapter.adapter;

import java.io.InputStream;
import java.util.List;

import com.crisitanbyte.design_patterns.adapter.model.Person;

public class FileAdapter {

    private final InputFile inputFIle;
    
    public FileAdapter(InputFile inputFIle) {
        this.inputFIle = inputFIle;
    }

    public List<Person> readFile(InputStream inputStream) {
        return inputFIle.readFile(inputStream);
    }
}
