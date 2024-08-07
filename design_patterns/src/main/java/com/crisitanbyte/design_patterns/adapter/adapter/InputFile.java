package com.crisitanbyte.design_patterns.adapter.adapter;

import java.io.InputStream;
import java.util.List;

import com.crisitanbyte.design_patterns.adapter.model.Person;

public interface InputFile {
    List<Person> readFile(InputStream inputStream);
}
