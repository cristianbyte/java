package com.crisitanbyte.design_patterns.abstractFactory.products.shoe;

import com.crisitanbyte.design_patterns.abstractFactory.products.Shoe;

public class SportShoe implements Shoe {

    @Override
    public boolean isRunningShoe() {
        System.out.println("isRunningShoe: Yes");
        return true;
    }

    @Override
    public boolean hasLaces() {
        System.out.println("hasLaces: Yes");
        return true;
    }
    
}
