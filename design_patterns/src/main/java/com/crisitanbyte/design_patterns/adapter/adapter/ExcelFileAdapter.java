package com.crisitanbyte.design_patterns.adapter.adapter;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.crisitanbyte.design_patterns.adapter.model.Person;

public class ExcelFileAdapter implements InputFIle{

    @Override
    public List<Person> readFile(InputStream inputStream) {
        try {
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
            XSSFSheet sheet = workbook.getSheetAt(0);

            List<Person> people = new ArrayList<>();
            for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
                Row row = sheet.getRow(i);

                Person person = new Person();
                person.setName(String.valueOf( row.getCell(cell)));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    
}
