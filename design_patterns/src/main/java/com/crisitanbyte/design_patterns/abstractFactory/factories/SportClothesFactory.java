package com.crisitanbyte.design_patterns.abstractFactory.factories;

import com.crisitanbyte.design_patterns.ClothesFactory;
import com.crisitanbyte.design_patterns.abstractFactory.products.Shirt;
import com.crisitanbyte.design_patterns.abstractFactory.products.Shoe;
import com.crisitanbyte.design_patterns.abstractFactory.products.Trousers;
import com.crisitanbyte.design_patterns.abstractFactory.products.shirt.SportShirt;
import com.crisitanbyte.design_patterns.abstractFactory.products.shoe.SportShoe;
import com.crisitanbyte.design_patterns.abstractFactory.products.trousers.SportTrousers;

public class SportClothesFactory implements ClothesFactory {

    @Override
    public Shirt createShirt() {
        return new SportShirt();
    }

    @Override
    public Trousers createTrousers() {
        return new SportTrousers();
    }

    @Override
    public Shoe createShoe() {
        return new SportShoe();
    }
}
