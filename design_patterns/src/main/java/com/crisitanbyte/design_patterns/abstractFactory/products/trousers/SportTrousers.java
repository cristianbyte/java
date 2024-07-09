package com.crisitanbyte.design_patterns.abstractFactory.products.trousers;

import com.crisitanbyte.design_patterns.abstractFactory.products.Trousers;

public class SportTrousers implements Trousers{

    @Override
    public boolean hasPockets() {
        System.out.println("hasPockets: Yes");
        return true;
    }

    @Override
    public String getClosureType() {
        System.out.println("ClosureType: None");
        return "None";
    }
    
}
