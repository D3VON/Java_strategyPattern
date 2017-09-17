package com.d3von;

public class ItemConjure extends Item {
    public ItemConjure(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    // "Conjured" items degrade in Quality twice as fast as normal items
    public void updateQuality(){

        sellIn -= 1;

        // "Conjured" items degrade in Quality twice as fast as normal items
        //- The Quality of an item is never negative
        if(0 < quality){ // skip if quality already zero
            quality -= 2;
            if (0 > sellIn) { // Once the sell by date has passed, Quality degrades twice as fast
                quality -= 4;
            }
        }
    }

}
