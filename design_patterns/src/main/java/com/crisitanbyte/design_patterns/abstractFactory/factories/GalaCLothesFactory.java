package com.crisitanbyte.design_patterns.abstractFactory.factories;

import com.crisitanbyte.design_patterns.ClothesFactory;
import com.crisitanbyte.design_patterns.abstractFactory.products.Shirt;
import com.crisitanbyte.design_patterns.abstractFactory.products.Shoe;
import com.crisitanbyte.design_patterns.abstractFactory.products.Trousers;
import com.crisitanbyte.design_patterns.abstractFactory.products.shirt.GalaShirt;
import com.crisitanbyte.design_patterns.abstractFactory.products.shoe.GalaShoe;
import com.crisitanbyte.design_patterns.abstractFactory.products.trousers.GalaTrousers;

public class GalaCLothesFactory implements ClothesFactory {

    @Override
    public Shirt createShirt() {
        return new GalaShirt();
    }

    @Override
    public Trousers createTrousers() {
        return new GalaTrousers();
    }

    @Override
    public Shoe createShoe() {
        return new GalaShoe();
    }
    
}
