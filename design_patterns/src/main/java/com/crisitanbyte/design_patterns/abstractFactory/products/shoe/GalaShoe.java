package com.crisitanbyte.design_patterns.abstractFactory.products.shoe;

import com.crisitanbyte.design_patterns.abstractFactory.products.Shoe;

public class GalaShoe implements Shoe {

    @Override
    public boolean isRunningShoe() {
        System.out.println("isRunningShoe: No");
        return false;
    }

    @Override
    public boolean hasLaces() {
        System.out.println("hasLaces: No");
        return false;
    }
    
}
