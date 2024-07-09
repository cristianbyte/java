package com.crisitanbyte.design_patterns;

import com.crisitanbyte.design_patterns.abstractFactory.factories.GalaCLothesFactory;
import com.crisitanbyte.design_patterns.abstractFactory.factories.SportClothesFactory;
import com.crisitanbyte.design_patterns.abstractFactory.products.shirt.GalaShirt;
import com.crisitanbyte.design_patterns.abstractFactory.products.shirt.SportShirt;

public class DesignPatternsApplication {
	public static void main(String[] args) {
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
	}
}
