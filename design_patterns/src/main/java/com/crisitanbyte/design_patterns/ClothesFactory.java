package com.crisitanbyte.design_patterns;

import com.crisitanbyte.design_patterns.abstractFactory.products.Shirt;
import com.crisitanbyte.design_patterns.abstractFactory.products.Shoe;
import com.crisitanbyte.design_patterns.abstractFactory.products.Trousers;

public interface ClothesFactory {
    Shirt createShirt();
    Trousers createTrousers();
    Shoe createShoe();
}
