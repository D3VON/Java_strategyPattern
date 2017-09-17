package com.d3von;

public class ItemSulfuras extends Item {
    public ItemSulfuras(String name, int sellIn, int quality) {
        super(name, sellIn, 80);

    }

    public void updateQuality() {
        // "Sulfuras", being a legendary item, never has to be sold or decreases in Quality
        //Just for clarification, an item can never have its Quality increase above 50,
        // however "Sulfuras" is a legendary item and as such its Quality is 80 and it never alters.
    }
}
