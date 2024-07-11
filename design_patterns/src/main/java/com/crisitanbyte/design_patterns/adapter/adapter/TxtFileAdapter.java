package com.crisitanbyte.design_patterns.adapter.adapter;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

import com.crisitanbyte.design_patterns.adapter.model.Person;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class TxtFileAdapter implements InputFile {
    @Override
    public List<Person> readFile(InputStream inputStream) {
        
        Reader reader = new InputStreamReader(inputStream);
        
        ColumnPositionMappingStrategy<Person> strategy = new ColumnPositionMappingStrategy<>();
        strategy.setType(Person.class);
        strategy.setColumnMapping(new String[]{"name", "lastName", "age"});

        CsvToBean<Person> csvToBean = new CsvToBeanBuilder<Person>(reader)
        .withMappingStrategy(strategy)
        .withType(Person.class)
        .withSeparator(';')
        .withSkipLines(1)
        .withIgnoreLeadingWhiteSpace(true)
        .build();

        List<Person> personsList = csvToBean.parse();

        return personsList; 
    }
}
