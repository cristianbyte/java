package com.crisitanbyte.design_patterns.abstractFactory.products.shirt;

import com.crisitanbyte.design_patterns.abstractFactory.products.Shirt;

public class SportShirt implements Shirt{

    @Override
    public boolean hasLongSleeves() {
        System.out.println("hasLongSleeves: No");
        return false;
    }

    @Override
    public boolean hasButtons() {
        System.out.println("hasButtons: No");
        return false;
    }
    
}
