package com.crisitanbyte.design_patterns;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

import com.crisitanbyte.design_patterns.abstractFactory.factories.GalaCLothesFactory;
import com.crisitanbyte.design_patterns.abstractFactory.factories.SportClothesFactory;
import com.crisitanbyte.design_patterns.abstractFactory.products.shirt.GalaShirt;
import com.crisitanbyte.design_patterns.abstractFactory.products.shirt.SportShirt;
import com.crisitanbyte.design_patterns.adapter.adapter.FileAdapter;
import com.crisitanbyte.design_patterns.adapter.adapter.InputFile;
import com.crisitanbyte.design_patterns.adapter.adapter.TxtFileAdapter;
import com.crisitanbyte.design_patterns.adapter.model.Person;

public class DesignPatternsApplication {

	private static final String path = 
		"src" + File.separator +
		"assets" + File.separator;

	public static void main(String[] args) throws FileNotFoundException {
		System.out.println("--------------- Abstract Factory");
		ClothesFactory sportClothesFactory = new SportClothesFactory();
		GalaCLothesFactory galaClothesFactory = new GalaCLothesFactory();
		SportShirt sportShirt = (SportShirt) sportClothesFactory.createShirt();
		GalaShirt galaShirt = (GalaShirt) galaClothesFactory.createShirt();
		System.out.println("---- Sport Shirt:");
		sportShirt.hasButtons();
		sportShirt.hasLongSleeves();
		System.out.println("---- Gala Shirt:");
		galaShirt.hasButtons();
		galaShirt.hasLongSleeves();


		System.out.println("--------------- Adapter");

		// InputFile inputFileAdapter = new ExcelFileAdapter();
		// FileAdapter fileAdapter = new FileAdapter(inputFileAdapter);

		// InputStream inputStream = new FileInputStream(path + "data-AdapterFile.xlsx");
		// List<Person> personList = fileAdapter.readFile(inputStream);

		InputFile csvFileAdapter = new TxtFileAdapter();
		FileAdapter fileAdapter = new FileAdapter(csvFileAdapter);

		InputStream inputStream = new FileInputStream(path + "data-AdapterFile.txt" );
		List<Person> personList = fileAdapter.readFile(inputStream);

		System.out.println(personList);
	}

    public static String getPath() {
        return path;
    }
}
