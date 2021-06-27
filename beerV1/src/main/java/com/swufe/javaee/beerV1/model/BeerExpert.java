package com.swufe.javaee.beerV1.model;

import java.util.ArrayList;
import java.util.List;

public class BeerExpert {
    public List<Beer> getBeers(String color) {
        List<Beer> beers = new ArrayList<>();
        if (color.equals("amber")) {
            beers.add(new Beer("Jack Amber", 100.0));
            beers.add(new Beer("Red Moose", 200.0));
        } else {
            beers.add(new Beer("Jali Pale Ale", 100.0));
            beers.add(new Beer("Gout Stout", 200.0));
        }
        return beers;
    }
}
