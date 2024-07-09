package com.crisitanbyte.design_patterns.abstractFactory.products.shirt;

import com.crisitanbyte.design_patterns.abstractFactory.products.Shirt;

public class GalaShirt implements Shirt{

    @Override
    public boolean hasLongSleeves() {
        System.out.println("hasLongSleeves: Yes");
        return true;
    }

    @Override
    public boolean hasButtons() {
        System.out.println("hasButtons: Yes");
        return true;
    }
    
}
